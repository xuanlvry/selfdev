package com.my.test.encryption.sdk;

import javax.crypto.Cipher;
import java.io.*;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Enumeration;

/**
 * 证书工具类
 * @author Chengfei.Sun on 2015/11/27.
 */
public class CertUtil {
    /** 证书容器. */
    private static KeyStore keyStore = null;

    private static String password;

    static {
        init("E:\\MyProjects\\testProject\\src\\main\\resources\\linyi.pfx", "abcdef");
    }

    public static void init(String filePath, String pfxPassword) {
        if (keyStore != null) {
            return;
        }
        try {
            password = pfxPassword;
            keyStore = loadKetStore(filePath, pfxPassword);
        } catch (Exception e) {
            LogUtil.writeErrorLog("证书初始化错误", e);
        }
    }

    public static String getSignCertId() throws KeyStoreException {
        String keyAlias = getKeyAlias(keyStore);

        X509Certificate cert = (X509Certificate) keyStore.getCertificate(keyAlias);
        return cert.getSerialNumber().toString();
    }

    /**
     * 加载证书
     *
     * @param pfxFilepath 证书路径
     * @param pfxPassword 密码
     * @throws Exception
     */
    public static KeyStore loadKetStore(String pfxFilepath, String pfxPassword)
            throws Exception {
        KeyStore keyStore = null;
        File fPkcs12 = null;
        if (pfxFilepath != null) {
            fPkcs12 = new File(pfxFilepath);
        }
        FileInputStream fis = new FileInputStream(fPkcs12);
        try {
            keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(fis, pfxPassword.toCharArray());
        } catch (KeyStoreException ex) {
            throw new Exception("不能正确解释pfx文件! ");
        } catch (CertificateException ex) {
            throw new Exception("证书格式问题!");
        } catch (NoSuchAlgorithmException ex) {
            throw new Exception("算法不支持!");
        } catch (FileNotFoundException ex) {
            throw new Exception("pfx文件没找到");
        } catch (IOException ex) {
            throw new Exception("读取pfx有误!");
        }
        return keyStore;
    }

    /**
     * 获取证书别名
     *
     * @param keyStore
     * @return
     */
    @SuppressWarnings("unchecked")
    public static String getKeyAlias(KeyStore keyStore) {
        String keyAlias = "";
        try {
            Enumeration enums = keyStore.aliases();
            while (enums.hasMoreElements()) {
                keyAlias = (String) enums.nextElement();
            }
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return keyAlias;
    }

    /**
     * 获取私钥，获取私钥，可以使用私钥进行数据加密后在网络上传输。
     *
     * @param keyStore
     * @param pfxPassword
     * @return
     */
    public static PrivateKey getPrivateKey(KeyStore keyStore, String pfxPassword) {
        PrivateKey privateKey = null;
        try {
            String keyAlias = getKeyAlias(keyStore);
            privateKey = (PrivateKey) keyStore.getKey(keyAlias,
                    pfxPassword.toCharArray());
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return privateKey;
    }

    public static PrivateKey getPrivateKey() {
        return getPrivateKey(keyStore, password);
    }

    /**
     * 获取公钥，使用公钥对私钥加密过的数据进行解密，可以得到相关的明文。
     *
     * @param keyStore
     * @return
     */
    public static PublicKey getPublicKey(KeyStore keyStore) {
        PublicKey publicKey = null;
        try {
            String keyAlias = getKeyAlias(keyStore);
            Certificate certificate = keyStore.getCertificate(keyAlias);
            publicKey = certificate.getPublicKey();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return publicKey;
    }

    public static PublicKey getPublicKey() {
        return getPublicKey(keyStore);
    }

    /**
     * 获取公钥，使用公钥对私钥加密过的数据进行解密，可以得到相关的明文。
     *
     * @param certFilename
     * @return
     */
    public static PublicKey getPublicKey(String certFilename) throws FileNotFoundException, CertificateException {
        InputStream certFileIs = new FileInputStream(certFilename);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate cert = (X509Certificate) cf.generateCertificate(certFileIs);

        return cert.getPublicKey();
    }

    /**
     * 公钥加密，使用公钥加密的数据，需要使用私钥进行解密。
     *
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, PublicKey publicKey)
            throws Exception {
        // 对数据加密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encodedata = cipher.doFinal(data.getBytes());
        return byte2hex(encodedata);
    }

    /**
     * 公钥解密，使用公钥对私钥加密过的数据进行解密。
     *
     * @param data
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static String decryptByPublicKey(String data, PublicKey publicKey)
            throws Exception {
        // 对数据解密
        Cipher cipher = Cipher.getInstance(publicKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        byte[] decodedata = cipher.doFinal(hex2byte(data));
        return new String(decodedata);
    }

    /**
     * 私钥加密，使用私钥加密的数据，需要使用公钥进行解密。
     *
     * @param data
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data, PrivateKey privateKey)
            throws Exception {
        // 对数据加密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        byte[] encodedata = cipher.doFinal(data.getBytes());
        return byte2hex(encodedata);
    }

    /**
     * 私钥解密，可以使用私钥对公钥加密过的数据进行解密。
     *
     * @param encodestr
     * @param privateKey
     * @return
     * @throws Exception
     */
    public static String decryptByPrivateKey(String encodestr,
                                             PrivateKey privateKey) throws Exception {
        // 对数据解密
        Cipher cipher = Cipher.getInstance(privateKey.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] data = cipher.doFinal(hex2byte(encodestr));
        return new String(data);
    }

    /**
     * 验证Certificate是否过期或无效
     *
     * @param keyStore
     * @param date     当前时间
     * @return
     */
    public static boolean verifyCertificate(KeyStore keyStore, Date date) {
        boolean status = true;
        try {
            // 取得证书
            String keyAlias = getKeyAlias(keyStore);
            Certificate[] certs = (Certificate[]) keyStore.getCertificateChain(keyAlias);
            if (certs != null && certs.length > 0) {
                // 取得公钥
                X509Certificate x509Certificate = (X509Certificate) certs[0];
                // 验证证书是否过期或无效
                x509Certificate.checkValidity(date);
            }
        } catch (Exception e) {
            status = false;
        }
        return status;
    }

    /**
     * 构造签名
     *
     * @param keyStore
     * @param pfxPassword
     * @param dataStr     证书别名
     * @return
     */
    public static String createSignature(KeyStore keyStore, String pfxPassword,
                                         String dataStr) {
        try {
            // 取得证书
            String keyAlias = getKeyAlias(keyStore);
            Certificate[] certs = (Certificate[]) keyStore.getCertificateChain(keyAlias);
            X509Certificate x509Certificate = null;
            if (certs != null && certs.length > 0) {
                x509Certificate = (X509Certificate) certs[0];
                // 验证证书是否过期或无效
            }
            if (x509Certificate != null) {
                Signature signature = Signature.getInstance(x509Certificate
                        .getSigAlgName());
                PrivateKey privateKey = getPrivateKey(keyStore, pfxPassword);
                signature.initSign(privateKey);
                signature.update(dataStr.getBytes());
                byte[] data = signature.sign();
                return byte2hex(data);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将二进制转化为16进制字符串
     *
     * @param b 二进制字节数组
     * @return String
     */
    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    /**
     * 验证签名
     *
     * @param keyStore
     * @param dataStr
     * @param dataStr
     * @return
     */
    public static boolean verfySignature(KeyStore keyStore, String dataStr,
                                         String signStr) {
        try {
            // 取得证书
            String keyAlias = getKeyAlias(keyStore);
            Certificate[] certs = keyStore.getCertificateChain(keyAlias);
            X509Certificate x509Certificate = null;
            if (certs != null && certs.length > 0) {
                x509Certificate = (X509Certificate) certs[0];
                // 验证证书是否过期或无效
            }
            Signature signature = Signature.getInstance(x509Certificate
                    .getSigAlgName());
            PublicKey publicKey = getPublicKey(keyStore);
            signature.initVerify(publicKey);
            signature.update(dataStr.getBytes());
            return signature.verify(hex2byte(signStr));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 十六进制字符串转化为2进制
     *
     * @param hex
     * @return
     */
    private static byte[] hex2byte(String hex) {
        byte[] ret = null;
        // try {
        byte[] tmp = hex.getBytes();
        int length = tmp.length / 2;
        ret = new byte[length];
        for (int i = 0; i < length; i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }

    /**
     * 将两个ASCII字符合成一个字节； 如："EF"--> 0xEF
     *
     * @param src0 byte
     * @param src1 byte
     * @return byte
     */
    private static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[]{src0}))
                .byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[]{src1}))
                .byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }
}
