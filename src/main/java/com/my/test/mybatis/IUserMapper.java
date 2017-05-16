package com.my.test.mybatis;

import com.my.test.UserInfo;

/**
 * Mybatis接口编程，没有实现类
 * @author Chengfei.Sun on 2015/7/19.
 */
public interface IUserMapper {
    Integer insert(UserInfo userInfo);

    UserInfo selectUserById(Long id);

    UserInfo selectUserByAccount(String account);

    Integer updateUser(UserInfo userInfo);
}
