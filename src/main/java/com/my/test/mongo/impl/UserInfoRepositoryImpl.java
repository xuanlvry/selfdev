package com.my.test.mongo.impl;

import com.my.test.UserInfo;
import com.my.test.mongo.UserInfoDAO;

/**
 * @author Chengfei.Sun on 2016/11/2.
 */
public class UserInfoRepositoryImpl implements UserInfoDAO {
    @Override
    public UserInfo myMethod(String str) {
        System.out.println("执行我自定义的DAO方法:" + str);
        return null;
    }
}
