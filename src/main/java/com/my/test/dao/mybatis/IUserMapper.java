package com.my.test.dao.mybatis;

import com.my.test.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Chengfei.Sun on 2015/7/19.
 */
public interface IUserMapper {
    @Insert("insert into user (age, tel, name, sex, sign, createTime, account, password, salt) " +
            "values(#{age}, #{tel}, #{name}, #{sex}, #{sign}, #{createTime}, #{account}, #{password}, #{salt})")
    Integer insert(UserInfo userInfo);

    @Select("select * from user where id = #{id}")
    UserInfo selectUserById(Long id);

    @Select("select * from user where id = #{id} for update")
    UserInfo selectUserByIdForUpdate(Long id);

    @Select("select * from user where account = #{account}")
    UserInfo selectUserByAccount(String account);

    @Update("udpate user set account = #{account} where id = #{id}")
    Integer updateUser(UserInfo userInfo);
}
