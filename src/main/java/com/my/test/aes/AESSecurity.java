package com.my.test.aes;

import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Created by Chengfei.Sun on 17/03/30.
 */
public class AESSecurity {
    /**
     * java字节码转字符串
     * @param b
     * @return
     */
    public static String byte2hex(byte[] b) { //一个字节的数，

        // 转成16进制字符串

        String hs = "";
        String tmp = "";
        for (int n = 0; n < b.length; n++) {
            //整数转成十六进制表示
            tmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (tmp.length() == 1) {
                hs = hs + "0" + tmp;
            } else {
                hs = hs + tmp;
            }
        }
        tmp = null;
        return hs.toUpperCase(); //转成大写

    }

    /**
     * 字符串转java字节码
     * @param b
     * @return
     */
    public static byte[] hex2byte(byte[] b) {
        if ((b.length % 2) != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] b2 = new byte[b.length / 2];
        for (int n = 0; n < b.length; n += 2) {
            String item = new String(b, n, 2);
            // 两位一组，表示一个字节,把这样表示的16进制字符串，还原成一个进制字节

            b2[n / 2] = (byte) Integer.parseInt(item, 16);
        }
        b = null;
        return b2;
    }

    public static String encrypt(String input, String key) {
        byte[] crypted = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(byte2hex(crypted));
    }

    public static String decrypt(String input, String key) {
        byte[] output = null;
        try {
            SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(hex2byte(input.getBytes()));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new String(output);
    }

    public static void main(String[] args) throws Exception {
        String key = "0b7e416a4c14dccaee7b76550246ab8d";
        String data = "萌虎数据对接加密算法测试test001";

        System.out.println(AESSecurity.encrypt(data, key));
//        System.out.println(AESSecurity.decrypt(, key));
//        System.out.println(AESSecurity.encrypt(data, key));
    }

}
