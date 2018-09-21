package com.my.test;

import com.my.test.dao.mybatis.IUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
@Service
public class MyServiceImpl implements IMyService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserInfo selectUser(long id) {
        UserInfo userInfo = userMapper.selectUserById(id);
        return userInfo;
    }

    @Cacheable(value="accountCache")
    @Override
    public UserInfo selectUser(String account) {
        System.out.println("accountCache: real querying db..." + account);
        return userMapper.selectUserByAccount(account);
    }

    @CacheEvict(value="accountCache", key="#p0.account", allEntries = false)
    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
    }

    @Cacheable(value="default")
    @Override
    public UserInfo selectBySpringCache(String account) {
        System.out.println("default: real querying db..." + account);
        return userMapper.selectUserByAccount(account);
    }
}
