package com.my.test.dao;

import com.my.test.UserInfo;
import com.my.test.dao.mybatis.IUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        UserInfo userInfo = userMapper.selectUserById(100052L);
        System.out.println();
        System.out.println(userInfo);
        System.out.println();
    }
}
