package com.my.test.dao;

import com.my.test.UserInfo;
import com.my.test.common.utils.GenericUtil;
import com.my.test.dao.mybatis.IUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunchengfei on 2018/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class DAOTest {
    @Autowired
    private IUserMapper userMapper;

    @Test
    public void daoTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setCreateTime(new Date());
        userInfo.setSex(1);
        userInfo.setName("测试typehandler" + new Date());
        userInfo.setTels(Arrays.asList("13456785678","13590909090"));

//        userMapper.insert(userInfo);

        userInfo = userMapper.selectUserById(2255267L);
        System.out.println("---------------" + userInfo + "-------------------");
    }

    @Test
    public void insertTest() {
        ExecutorService executor = Executors.newFixedThreadPool(200);

        for (int i = 0; i < 2000000; i++) {
            executor.submit(new Worker(userMapper));
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("输入:");
        String instr = sc.nextLine();
        System.out.println("输入:" + instr);
        System.out.println("主程序结束");
    }

    private class Worker implements Runnable {
        private IUserMapper userMapper;

        public Worker(IUserMapper userMapper) {
            this.userMapper = userMapper;
        }

        @Override
        public void run() {
            Random random = new Random();

            UserInfo userInfo = new UserInfo();
            userInfo.setAccount(GenericUtil.getRandomNumAndChacters(10));
            userInfo.setPassword(GenericUtil.getRandomNumAndChacters(8));
            userInfo.setSex(random.nextInt(2));
            userInfo.setName(GenericUtil.getChineseName(userInfo.getSex()));
            userInfo.setAge(random.nextInt(100));
            userInfo.setTels(Arrays.asList(GenericUtil.getTel()));
            userInfo.setCreateTime(new Date());

            userMapper.insert(userInfo);
        }
    }
}
