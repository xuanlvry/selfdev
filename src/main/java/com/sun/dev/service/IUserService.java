package com.sun.dev.service;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
public interface IUserService {
    UserInfo selectUser(long id);

    UserInfo selectUser(String account);

    void updateUser(UserInfo userInfo);

    UserInfo selectBySpringCache(String account);
}
