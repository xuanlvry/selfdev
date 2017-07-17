package com.my.test;

import com.my.test.mybatis.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
@Service
public class MyServiceImpl implements IMyService {
    @Autowired
    private IUserMapper userMapper;

    public UserInfo selectUser(long id) {
        UserInfo userInfo = userMapper.selectUserById(id);
        return userInfo;
    }

    public UserInfo selectUser(String account) {
        return userMapper.selectUserByAccount(account);
    }

    public void updateUser(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
    }

    @Cacheable(value = "userInfoCache")
    public UserInfo selectBySpringCache(String account) {
        System.out.println("real querying db..." + account);
        return new UserInfo();
    }
}
