package com.my.test.springdatajpa;

import com.my.test.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by sunchengfei on 2018/4/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class RepositoryTest {
    @Autowired
    private UserInfoRepository userInfoRepositoryImpl;

    @Test
    public void test(){
        List<UserInfo> userInfo = userInfoRepositoryImpl.findByAge(12);
        System.out.println(userInfo);
    }
}