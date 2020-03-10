package com.sun.dev.springcache;

import com.sun.dev.service.IUserService;
import com.sun.dev.service.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Chengfei.Sun on 17/03/29.
 */
@Controller("springCacheController")
@RequestMapping("springcache")
public class SpringCacheController {
    @Resource
    private IUserService myServiceImpl;

    @RequestMapping(value = "select", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo select() {
        UserInfo userInfo = myServiceImpl.selectUserByAccount("jack");
        return myServiceImpl.selectBySpringCache("jack");
    }

    @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(UserInfo userInfo) {
        myServiceImpl.updateUser(userInfo);
        return "{\"msg\":\"success\"}";
    }
}