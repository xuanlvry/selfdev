package com.my.test.encryption.sdk;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.KeyStoreException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * 签名工具类
 *
 * @author Chengfei.Sun on 2015/12/02.
 */
public class SDKUtil {
    /**
     * 生成签名值
     *
     * @param data     待签名数据Map键值对形式
     * @param encoding 编码
     * @return 签名是否成功
     */
    public static boolean sign(Map<String, String> data, String encoding) throws KeyStoreException {
        if (StringUtils.isEmpty(encoding)) {
            encoding = "UTF-8";
        }
        // 设置签名证书序列号
        data.put(SDKConstants.param_certId, CertUtil.getSignCertId());
        // 将Map信息转换成key1=value1&key2=value2的形式
        String stringData = coverMap2String(data);
        LogUtil.writeLog("待签名请求报文串:[" + stringData + "]");
        /**
         * 签名\base64编码
         */
        byte[] byteSign = null;
        String stringSign = null;
        try {
            // 通过SHA1进行摘要并转16进制
            byte[] signDigest = SecureUtil.sha1X16(stringData, encoding);
            byteSign = SecureUtil.base64Encode(SecureUtil.signBySoft(
                    CertUtil.getPrivateKey(), signDigest));
            stringSign = new String(byteSign);
            LogUtil.writeLog("签名：" + stringSign);
            // 设置签名域值
            data.put(SDKConstants.param_signature, stringSign);
            return true;
        } catch (Exception e) {
            LogUtil.writeErrorLog("签名异常", e);
            return false;
        }
    }

    /**
     * 验证签名
     *
     * @param resData  返回报文数据
     * @param encoding 编码格式
     * @return
     */
    public static boolean validate(Map<String, String> resData, String encoding) {
        LogUtil.writeLog("验签处理开始");
        if (StringUtils.isEmpty(encoding)) {
            encoding = "UTF-8";
        }
        String stringSign = resData.get(SDKConstants.param_signature);

        // 从返回报文中获取certId ，然后去证书静态Map中查询对应验签证书对象
        String certId = resData.get(SDKConstants.param_certId);
        LogUtil.writeLog("对返回报文串验签使用的验签公钥序列号：[" + certId + "]");

        // 将Map信息转换成key1=value1&key2=value2的形式
        String stringData = coverMap2String(resData);
        LogUtil.writeLog("待验签返回报文串：[" + stringData + "]");

        try {
            // 验证签名需要用发给商户的公钥证书.
            return SecureUtil.validateSignBySoft(CertUtil.getPublicKey(), stringSign, stringData, encoding);
        } catch (UnsupportedEncodingException e) {
            LogUtil.writeErrorLog(e.getMessage(), e);
        } catch (Exception e) {
            LogUtil.writeErrorLog(e.getMessage(), e);
        }
        return false;
    }

    /**
     * 将Map中的数据转换成key1=value1&key2=value2的形式 不包含签名域signature
     *
     * @param data 待拼接的Map数据
     * @return 拼接好后的字符串
     */
    public static String coverMap2String(Map<String, String> data) {
        TreeMap<String, String> tree = new TreeMap<String, String>();
        Iterator<Entry<String, String>> it = data.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, String> en = it.next();
            if (SDKConstants.param_signature.equals(en.getKey().trim())) {
                continue;
            }
            tree.put(en.getKey(), en.getValue());
        }
        it = tree.entrySet().iterator();
        StringBuffer sf = new StringBuffer();
        while (it.hasNext()) {
            Entry<String, String> en = it.next();
            sf.append(en.getKey() + SDKConstants.EQUAL + en.getValue()
                    + SDKConstants.AMPERSAND);
        }
        return sf.substring(0, sf.length() - 1);
    }

    /**
     * 将形如key=value&key=value的字符串转换为相应的Map对象
     *
     * @param result
     * @return
     */
    public static Map<String, String> convertResultStringToMap(String result) {
        Map<String, String> map = null;
        try {

            if (StringUtils.isNotBlank(result)) {
                if (result.startsWith("{") && result.endsWith("}")) {
                    result = result.substring(1, result.length() - 1);
                }
                map = parseQString(result);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 解析应答字符串，生成应答要素
     *
     * @param str 需要解析的字符串
     * @return 解析的结果map
     * @throws UnsupportedEncodingException
     */
    public static Map<String, String> parseQString(String str)
            throws UnsupportedEncodingException {
        Map<String, String> map = new HashMap<String, String>();
        int len = str.length();
        StringBuilder temp = new StringBuilder();
        char curChar;
        String key = null;
        boolean isKey = true;
        boolean isOpen = false;//值里有嵌套
        char openName = 0;
        if (len > 0) {
            for (int i = 0; i < len; i++) {// 遍历整个带解析的字符串
                curChar = str.charAt(i);// 取当前字符
                if (isKey) {// 如果当前生成的是key

                    if (curChar == '=') {// 如果读取到=分隔符
                        key = temp.toString();
                        temp.setLength(0);
                        isKey = false;
                    } else {
                        temp.append(curChar);
                    }
                } else {// 如果当前生成的是value
                    if (isOpen) {
                        if (curChar == openName) {
                            isOpen = false;
                        }

                    } else {//如果没开启嵌套
                        if (curChar == '{') {//如果碰到，就开启嵌套
                            isOpen = true;
                            openName = '}';
                        }
                        if (curChar == '[') {
                            isOpen = true;
                            openName = ']';
                        }
                    }
                    if (curChar == '&' && !isOpen) {// 如果读取到&分割符,同时这个分割符不是值域，这时将map里添加
                        putKeyValueToMap(temp, isKey, key, map);
                        temp.setLength(0);
                        isKey = true;
                    } else {
                        temp.append(curChar);
                    }
                }

            }
            putKeyValueToMap(temp, isKey, key, map);
        }
        return map;
    }

    private static void putKeyValueToMap(StringBuilder temp, boolean isKey,
                                         String key, Map<String, String> map)
            throws UnsupportedEncodingException {
        if (isKey) {
            key = temp.toString();
            if (key.length() == 0) {
                throw new RuntimeException("QString format illegal");
            }
            map.put(key, "");
        } else {
            if (key.length() == 0) {
                throw new RuntimeException("QString format illegal");
            }
            map.put(key, temp.toString());
        }
    }

}
