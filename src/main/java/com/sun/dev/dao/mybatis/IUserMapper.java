package com.sun.dev.dao.mybatis;

import com.sun.dev.dao.mybatis.typehandler.ListStringTypeHandler;
import com.sun.dev.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * @author Chengfei.Sun on 2015/7/19.
 */
public interface IUserMapper {
    @Insert("insert into user (age, tel, name, sex, sign, createTime, account, password, salt) " +
            "values(#{age}, #{tels, typeHandler=com.sun.dev.dao.mybatis.typehandler.ListStringTypeHandler}, #{name}, #{sex}, #{sign}, #{createTime}, #{account}, #{password}, #{salt})")
    Integer insert(UserInfo userInfo);

    @Select("select * from user where id = #{id}")
    @Results({
            @Result(column = "tel", property = "tels", typeHandler = ListStringTypeHandler.class)
    })
    UserInfo selectUserById(Long id);

    @Select("select * from user where id = #{id} for update")
    @Results({
            @Result(column = "tel", property = "tels", typeHandler = ListStringTypeHandler.class)
    })
    UserInfo selectUserByIdForUpdate(Long id);

    @Select("select * from user where account = #{account}")
    @Results({
            @Result(column = "tel", property = "tels", jdbcType = JdbcType.VARCHAR, javaType = java.util.List.class)
    })
    UserInfo selectUserByAccount(String account);

    @Update("<script>" +
            "update user " +
            "<set> " +
                "<if test='name!=null'> name = #{name}, </if>" +
                "<if test='age!=null'> age = #{age}, </if>" +
                "<if test='password!=null'> password = #{password}, </if>" +
                "<if test='tels!=null'> tel = #{tels, typeHandler=com.sun.dev.dao.mybatis.typehandler.ListStringTypeHandler}, </if>" +
                "<if test='sex!=null'> sex = #{sex}, </if>" +
                "<if test='sign!=null'> sign = #{sign}, </if>" +
            "</set>" +
            "where id = #{id} " +
            "</script>")
    Integer updateUser(UserInfo userInfo);
}
