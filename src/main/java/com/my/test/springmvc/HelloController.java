package com.my.test.springmvc;

import com.my.test.UserInfo;
import com.my.test.common.constants.ServiceResponse;
import com.my.test.common.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * @author Chengfei.Sun on 2015/9/8.
 */
@Controller("helloController")
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private IMyHelloService myHelloServiceImpl;

    @RequestMapping(value = "hello", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse hello(UserInfo userInfo) {
        ServiceResponse response = new ServiceResponse();
        try {
            //业务处理...
            System.out.println(1 / 0);
        } catch (Exception e) {
            response.setCode("9999");
            response.setMessage("服务器异常");
        }
        return response;
    }

    @RequestMapping(value = "helloEx", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse helloEx(UserInfo userInfo) {
        ServiceResponse response = new ServiceResponse();
        //业务处理...
        myHelloServiceImpl.sayHi();
        return response;
    }

    @RequestMapping(value = "normal", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo normal(UserInfo userInfo) {
        System.out.println("spring mvc controller处理：--------------------------------");
        try {
            Thread.sleep(1000 * 60 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userInfo;
    }
}
