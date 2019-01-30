package com.my.test;

import com.my.test.dao.GoodsInfoService;
import com.my.test.dao.mybatis.IUserMapper;
import com.my.test.redis.UserRedisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
@Service
@Lazy(value = true)
public class MyServiceImpl implements IMyService {
    @Autowired
    private IUserMapper userMapper;

    @Resource
    private UserRedisDAO userRedisDAO;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Override
    public UserInfo selectUser(long id) {
        UserInfo userInfo = userMapper.selectUserById(id);
        return userInfo;
    }

    @Cacheable(value="accountCache")
    @Override
    public UserInfo selectUser(String account) {
        System.out.println("accountCache: real querying db..." + account);
        userRedisDAO.query(account);
        goodsInfoService.queryById(0);
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
