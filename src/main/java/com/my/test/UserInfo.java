package com.my.test;

import com.my.test.dataaccess.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author Chengfei.Sun
 */
@Data
public class UserInfo extends BaseEntity {
    private String account;

    private String password;

    private String salt;

    private String name;

    private int age;

    private String tel;

    private int sex;

    private String sign;

    private Date createTime;
}
