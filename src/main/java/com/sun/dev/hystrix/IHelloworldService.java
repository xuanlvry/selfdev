package com.sun.dev.hystrix;

import com.sun.dev.entity.UserInfo;

/**
 * Created by sunchengfei on 2018/3/28.
 */
public interface IHelloworldService {
    UserInfo updateUser(UserInfo userInfo);

    UserInfo selectUser(UserInfo userInfo);
}