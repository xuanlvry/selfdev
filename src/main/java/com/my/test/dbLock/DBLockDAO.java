package com.my.test.dbLock;

import com.my.test.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Chengfei.Sun on 17/05/03.
 */
public interface DBLockDAO {
    int updateAmount(UserInfo userInfo);

    UserInfo selectByIdForUpdate(@Param("id")int id);

    UserInfo selectById(@Param("id")int id);

    void begin();

    void commit();
}
