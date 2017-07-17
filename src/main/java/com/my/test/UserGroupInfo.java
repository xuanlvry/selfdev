package com.my.test;

import com.my.test.dataaccess.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * Created by sunchengfei on 2017/7/17.
 */
@Data
public class UserGroupInfo extends BaseEntity {
    private long userid;
    private int groupid;
    private Date createTime;
}
