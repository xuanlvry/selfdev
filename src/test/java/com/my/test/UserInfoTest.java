package com.my.test;

import com.my.test.mybatis.IUserGroupMapper;
import com.my.test.mybatis.IUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

/**
 * Created by sunchengfei on 2017/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/application-context.xml", "classpath*:META-INF/application-dao-context.xml"})
public class UserInfoTest {
    @Resource
    private IUserMapper userMapper;

    @Resource
    private IUserGroupMapper groupMapper;

    @Test
    public void insertTest() {
        int foreach = 100000;
        Random random = new Random();
        String[] names = new String[]{"非", "想", "红", "帝", "德", "看", "梅", "插", "兔"};
        for (int i = 0; i < foreach; i++) {
            UserInfo userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setTel(UUID.randomUUID().toString());
            userInfo.setName(names[random.nextInt(9)] + names[random.nextInt(9)] + i);
            userInfo.setSex(random.nextInt(2));
            userInfo.setSign(names[random.nextInt(9)] + names[random.nextInt(9)] + UUID.randomUUID().toString());

            userMapper.insert(userInfo);

            UserGroupInfo groupInfo = new UserGroupInfo();
            groupInfo.setUserid((Long) userInfo.getId());
            groupInfo.setGroupid(random.nextInt(100));
            groupMapper.insert(groupInfo);
        }
    }
}
