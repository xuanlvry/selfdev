package com.my.test.mybatis;

import com.my.test.UserInfo;
import org.springframework.data.repository.Repository;

/**
 * @author Chengfei.Sun on 2016/10/31.
 */
public interface UserInfoDBRepository extends Repository<UserInfo, Integer> {
    UserInfo save(UserInfo userInfo);
}
