package com.my.test.mongo;

import com.my.test.UserInfo;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * @author Chengfei.Sun on 2016/10/31.
 */
@RepositoryDefinition(domainClass = UserInfo.class, idClass = Integer.class)
public interface UserInfoRepository extends UserInfoDAO {
    UserInfo save(UserInfo userInfo);

    //框架根据命名规则，自动解析查询语句
    List<UserInfo> findByAddressAndName(String address, String name);
}
