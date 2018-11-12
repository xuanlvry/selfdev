package com.my.test.json;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by sunchengfei on 2018/9/29.
 */
public class JsonTest {
    public static void main(String[] args) {
        TestObject1 object1 = new TestObject1();
        object1.setAddress("上海市");
        object1.setAge(20);
        object1.setName("tom");

        String json = JSON.toJSONString(object1);
        System.out.println(json);

        TestObject2 object2 = JSON.parseObject(json, TestObject2.class);
        System.out.println(object2);
    }
}
