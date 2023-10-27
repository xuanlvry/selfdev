package com.sun.dev.service;

import com.sun.dev.dao.mybatis.IUserMapper;
import com.sun.dev.entity.UserInfo;
import com.sun.dev.redis.UserRedisDAO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Resource
    private UserRedisDAO userRedisDAO;

    @Autowired
    private GoodsInfoService goodsInfoService;

    @Value("${default.name}")
    private String defaultName;

    @Setter
    private String name;

    private Long id;

    public UserServiceImpl() {
        System.out.println("UserServiceImpl");
    }

    static {
        System.out.println("UserServiceImpl static method");
    }

    public void init2() {
        System.out.println("UserServiceImpl init2 method");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("UserServiceImpl postConstruct method");
    }

    @Override
    public UserInfo selectUser(long id) {
        UserInfo userInfo = userMapper.selectUserById(id);
        return userInfo;
    }

    @Override
    public UserInfo selectUserByAccount(String account) {
        System.out.println("accountCache: real querying db..." + account);
        return userMapper.selectUserByAccount(account);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
    }

    @Override
    public UserInfo selectBySpringCache(String account) {
        System.out.println("default: real querying db..." + account);
        return userMapper.selectUserByAccount(account);
    }

    public void closeTest() {
        System.out.println("UserServiceImpl destroy-method");
    }

    @PreDestroy
    public void closeTest2() {
        System.out.println("UserServiceImpl preDestroy");
    }
}
