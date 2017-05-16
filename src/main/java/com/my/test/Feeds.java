package com.my.test;

import com.my.test.dataaccess.BaseEntity;

/**
 * @author Chengfei.Sun
 */
public class Feeds extends BaseEntity {
    private Long uid;

    private UserInfo userInfo;

    private String content;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
