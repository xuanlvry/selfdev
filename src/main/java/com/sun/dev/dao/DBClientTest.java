package com.sun.dev.dao;

import com.alibaba.fastjson.JSONObject;
import com.sun.dev.dao.mybatis.GoodsInfoDAO;
import com.sun.dev.dao.mybatis.IUserMapper;
import com.sun.dev.service.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * Created by sunchengfei on 2019/08/05.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class DBClientTest {
    @Autowired
    private GoodsInfoDAO goodsInfoDAO;

    @Autowired
    private IUserMapper userMapper;

    @Test
    public void insertTest() {
        int foreach = 1;
        Random random = new Random();
        String[] names = new String[]{"非", "想", "红", "帝", "德", "看", "梅", "插", "兔"};
        for (int i = 0; i < foreach; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(random.nextInt(100));
            userInfo.setAccount(UUID.randomUUID().toString().substring(0, 8));
            userInfo.setPassword(UUID.randomUUID().toString().substring(0, 8));
            userInfo.setTels(Arrays.asList("13412345678", "13412345678", "13412345678"));
            userInfo.setName(names[random.nextInt(9)] + names[random.nextInt(9)] + i);
            userInfo.setSex(random.nextInt(2));
            userInfo.setSign(names[random.nextInt(9)] + names[random.nextInt(9)] + UUID.randomUUID().toString());
            userInfo.setCreateTime(new Date());

            userMapper.insert(userInfo);
        }
    }

    @Test
    public void daoTest() {
        UserInfo userInfo = userMapper.selectUserByAccount("111");
        System.out.println(JSONObject.toJSONString(userInfo));
    }

}
