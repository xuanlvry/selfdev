package com.my.test;

/**
 * Created by Chengfei.Sun on 17/03/28.
 */
public interface IMyService {
    UserInfo selectUser(long id);

    UserInfo selectUser(String account);

    void updateUser(UserInfo userInfo);

    UserInfo selectBySpringCache(String account);
}
