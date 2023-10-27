package com.sun.dev.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

    @Column
    private String account;

    @Column
    private String password;

    @Column
    private String salt;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private List<String> tels;

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
