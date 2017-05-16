package com.my.test.aes;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * Created by xueao on 2016/12/15.
 */
public class AESUtil {
    private static final String ALGORITHM = "AES";
    private static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";
    private static final String CHARSET = "UTF-8";
    private static final String SHA1PRNGSET = "SHA1PRNG";

    /**
     * AES 加密
     *
     * @param source
     * @param key
     * @return
     * @throws Exception
     * @author lfjiang 2016年12月5日
     */
    public static String encrypt(String source, String key) throws Exception {
        if (StringUtils.isBlank(source)) {
            throw new Exception("aes encr data is null");
        }
        if (StringUtils.isBlank(key)) {
            throw new Exception("aes encr key is null");
        }
        try {
            byte[] result = process(source, key, true);
            return byte2hex(result);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * AES 解密
     *
     * @param cipherText
     * @param key
     * @return
     * @throws Exception
     * @author lfjiang 2016年12月5日
     */
    public static final String decrypt(String cipherText, String key)
            throws Exception {
        if (StringUtils.isBlank(cipherText)) {
            throw new Exception("aes encr data is null");
        }
        if (StringUtils.isBlank(key)) {
            throw new Exception("aes encr key is null");
        }
        try {
            byte[] result = process(cipherText, key, false);
            return new String(result, CHARSET);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * 加解密处理
     *
     * @param data
     * @param key
     * @param isEncr
     * @return
     * @throws Exception
     * @author lfjiang 2016年12月5日
     */
    private static final byte[] process(String data, String key, boolean isEncr)
            throws Exception {
        final byte[] datas = isEncr ? data.getBytes(CHARSET) : hex2byte(data);
        final byte[] keys = key.getBytes(CHARSET);
        KeyGenerator kgen = KeyGenerator.getInstance(ALGORITHM);
        SecureRandom random = SecureRandom.getInstance(SHA1PRNGSET);
        random.setSeed(keys);
        kgen.init(128, random);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec skey = new SecretKeySpec(enCodeFormat, ALGORITHM);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);// 创建密码器
        cipher.init(isEncr ? Cipher.ENCRYPT_MODE : Cipher.DECRYPT_MODE, skey);// 初始化
        return cipher.doFinal(datas);
    }

    /**
     * byte二进制 转 hex 十六进制
     *
     * @param bytes
     * @return
     * @author lfjiang 2016年12月5日
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder retString = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            retString.append(Integer.toHexString(0x0100 + (bytes[i] & 0x00FF))
                    .substring(1).toUpperCase());
        }
        return retString.toString();
    }

    /**
     * hex十六进制 转 byte二进制
     *
     * @param hex
     * @return
     * @author lfjiang 2016年12月5日
     */
    private static byte[] hex2byte(String hex) {
        if (StringUtils.isBlank(hex)) {
            return null;
        }
        byte[] bts = new byte[hex.length() / 2];
        for (int i = 0; i < bts.length; i++) {
            bts[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2),
                    16);
        }
        return bts;
    }

}
