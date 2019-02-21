package com.my.test.hystrix;

import com.my.test.UserInfo;

/**
 * Created by sunchengfei on 2018/3/28.
 */
public interface IHelloworldService {
    UserInfo updateUser(UserInfo userInfo);

    UserInfo selectUser(UserInfo userInfo);
}