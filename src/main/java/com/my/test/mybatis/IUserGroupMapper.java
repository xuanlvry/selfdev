package com.my.test.mybatis;

import com.my.test.UserGroupInfo;

/**
 * Mybatis接口编程，没有实现类
 * @author Chengfei.Sun on 2015/7/19.
 */
public interface IUserGroupMapper {
    Integer insert(UserGroupInfo groupInfo);
}
