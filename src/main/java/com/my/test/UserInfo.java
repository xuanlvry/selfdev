package com.my.test;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Chengfei.Sun
 */
@Data
@Entity
@Table(name = "user")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String account;

    private String password;

    private String salt;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String tel;

    @Column
    private int sex;

    @Column
    private String sign;

    @Column
    private Date createTime;

    public UserInfo() {

    }

    public UserInfo(String account, String name) {
        this.account = account;
        this.name = name;
    }
}
