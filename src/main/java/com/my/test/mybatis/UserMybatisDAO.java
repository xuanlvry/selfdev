package com.my.test.mybatis;

import com.my.test.UserInfo;
import com.my.test.dataaccess.mybatis.AbstractMyBatisDAO;
import org.springframework.stereotype.Repository;

/**
 * @author Chengfei.Sun on 2015/5/12.
 */
@Repository
public class UserMybatisDAO extends AbstractMyBatisDAO<UserInfo, Long> {

}
