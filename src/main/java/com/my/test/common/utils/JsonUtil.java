package com.my.test.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;

/**
 * JSON转换工具类
 * @author Chengfei.Sun on 2016/2/16.
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * JAVA对象转换成JSON字符串
     * @param object
     * @return
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JSON字符串转换成JAVA对象
     * @param json
     * @param valueType
     * @return
     */
    public static <T> T toObject(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * JAVA对象转换为Map
     * @param object
     * @return
     */
    public static Map<String, String> toMap(Object object) {
        return objectMapper.convertValue(object, Map.class);
    }

    /**
     * MAP转换为JAVA对象
     * @param map
     * @return
     */
    public static <T> T toObject(Map<String, String> map, Class<T> valueType) {
        return objectMapper.convertValue(map, valueType);
    }
}
