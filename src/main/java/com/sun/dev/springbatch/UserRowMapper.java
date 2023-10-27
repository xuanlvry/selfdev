package com.sun.dev.springbatch;

import com.sun.dev.entity.UserInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Chengfei.Sun on 17/03/23.
 */
public class UserRowMapper implements RowMapper<UserInfo> {
    public UserInfo mapRow(ResultSet resultSet, int i) throws SQLException {
        UserInfo userInfo = new UserInfo();

//        userInfo.setId(resultSet.getInt("id"));
//        userInfo.setAccount(resultSet.getString("account"));
//        userInfo.setPassword(resultSet.getString("password"));
//        userInfo.setName(resultSet.getString("name"));
//        userInfo.setAge(resultSet.getString("age"));
//        userInfo.setTel(resultSet.getString("tel"));
//        userInfo.setSex(resultSet.getString("sex"));
//        userInfo.setAddress(resultSet.getString("address"));
//        userInfo.setSalt(resultSet.getString("salt"));
//        userInfo.setUpdateTime(resultSet.getDate("updateTime"));
//        userInfo.setCreateTime(resultSet.getDate("createTime"));

        return userInfo;
    }
}
