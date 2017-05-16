package com.my.test.encryption;

import com.my.test.encryption.sdk.HttpClient;
import com.my.test.encryption.sdk.LogUtil;
import com.my.test.encryption.sdk.SDKUtil;
import org.apache.commons.lang3.StringUtils;

import java.security.KeyStoreException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 基础服务，提供基础方法
 *
 * @author Chengfei.Sun on 2015/12/2.
 */
public class BaseService {
    private static String encoding = "UTF-8";

    /**
     * 数据提交，对数据进行签名,供商户调用
     *
     * @param contentData
     * @return
     */
    public static Map<String, String> signData(Map<String, ?> contentData) throws KeyStoreException {
        Map.Entry<String, String> obj = null;
        Map<String, String> submitFromData = new HashMap<String, String>();
        for (Iterator<?> it = contentData.entrySet().iterator(); it.hasNext(); ) {
            obj = (Map.Entry<String, String>) it.next();
            String value = obj.getValue();
            if (StringUtils.isNotBlank(value)) {
                // 对value值进行去除前后空处理
                submitFromData.put(obj.getKey(), value.trim());
            }
        }
        /**
         * 签名
         */
        SDKUtil.sign(submitFromData, encoding);
        return submitFromData;
    }

    public static Map<String, String> submitUrl(Map<String, String> submitFromData, String requestUrl) {
        String resultString = "";
        LogUtil.writeLog("请求服务器地址:" + requestUrl);

        /**
         * 发送后台请求数据
         */
        HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
        try {
            int status = hc.send(submitFromData, encoding);
            if (200 == status) {
                resultString = hc.getResult();
            }
        } catch (Exception e) {
            LogUtil.writeErrorLog("请求服务器发生异常", e);
        }
        Map<String, String> resData = new HashMap<String, String>();

        /**
         * 验证签名
         */
        if (null != resultString && !"".equals(resultString)) {
            // 将返回结果转换为map
            resData = SDKUtil.convertResultStringToMap(resultString);
            if (SDKUtil.validate(resData, encoding)) {
                LogUtil.writeLog("验证签名成功,可以继续后边的逻辑处理");
            } else {
                LogUtil.writeLog("验证签名失败,必须验签签名通过才能继续后边的逻辑...");
            }
        }
        return resData;
    }
}
