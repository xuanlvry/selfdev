package com.my.test.databuild;

import com.my.test.UserInfo;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by sunchengfei on 2018/4/17.
 */
@Component
public class UserModule implements DataHandler {
    @Override
    public Object buiness(Map<String, Object> params) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("tom");
        userInfo.setAccount("tom@email");
        return userInfo;
    }
}
