package com.sun.dev.service;

import com.sun.dev.dao.mybatis.IUserMapper;
import com.sun.dev.redis.UserRedisDAO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
//@Service
//@Lazy(value = true)
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

    @Cacheable(value = "accountCache")
    @Override
    public UserInfo selectUser(String account) {
        System.out.println("accountCache: real querying db..." + account);
        userRedisDAO.query(account);
        goodsInfoService.queryById(0);
        return userMapper.selectUserByAccount(account);
    }

    @CacheEvict(value = "accountCache", key = "#p0.account", allEntries = false)
    @Override
    public void updateUser(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
    }

    @Cacheable(value = "default")
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
