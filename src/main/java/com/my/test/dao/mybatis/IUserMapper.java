package com.my.test.dao.mybatis;

import com.my.test.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Chengfei.Sun on 2015/7/19.
 */
public interface IUserMapper {
    @Insert("insert into user (age, tel, name, sex, sign, createTime, account, password, salt) " +
            "values(#{age}, #{tels,typeHandler=com.my.test.dao.mybatis.typehandler.ListStringTypeHandler}, #{name}, #{sex}, #{sign}, #{createTime}, #{account}, #{password}, #{salt})")
    Integer insert(UserInfo userInfo);

    @Select("select * from user where id = #{id}")
    @Results({
        @Result(column="tel", property="tels", jdbcType=JdbcType.VARCHAR)
    })
    UserInfo selectUserById(Long id);

    @Select("select * from user where id = #{id} for update")
    UserInfo selectUserByIdForUpdate(Long id);

    @Select("select * from user where account = #{account}")
    UserInfo selectUserByAccount(String account);

    @Update("update user set account = #{account}, tel = #{tel} where id = #{id}")
    Integer updateUser(UserInfo userInfo);
}
