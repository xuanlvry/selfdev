package com.sun.dev.transaction;

import com.sun.dev.dao.mybatis.IUserMapper;
import com.sun.dev.service.IUserService;
import com.sun.dev.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sunchengfei on 2019-09-23.
 */
@Service
public class UserServiceTransactionImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public UserInfo selectUser(long id) {
        return null;
    }

    @Override
    public UserInfo selectUserByAccount(String account) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, timeout = 30)
    public void updateUser(UserInfo userInfo) {
        userMapper.updateUser(userInfo);
        System.out.println(1 / (userInfo.getId() % 10));
    }

    @Override
    public UserInfo selectBySpringCache(String account) {
        return null;
    }
}
