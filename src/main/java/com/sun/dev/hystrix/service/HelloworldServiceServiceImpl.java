package com.sun.dev.hystrix.service;

import com.sun.dev.service.UserInfo;
import com.sun.dev.hystrix.IHelloworldService;
import org.springframework.stereotype.Service;

/**
 * Created by sunchengfei on 2018/3/28.
 */
@Service
public class HelloworldServiceServiceImpl implements IHelloworldService {
    @Override
    public UserInfo updateUser(UserInfo userInfo) {
        System.out.println(Thread.currentThread().getName() + "进入updateUser");
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return userInfo;
    }

    @Override
    public UserInfo selectUser(UserInfo userInfo) {
        return this.updateUser(userInfo);
    }

    public UserInfo fallBack(UserInfo userInfo) {
        System.out.println(Thread.currentThread().getName() + "调用fallback");
        return null;
    }
}