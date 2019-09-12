package com.sun.dev.springcache;

import com.sun.dev.service.UserInfo;
import com.sun.dev.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chengfei.Sun on 17/03/29.
 */
@Controller("springCacheController")
@RequestMapping("springcache")
public class SpringCacheController {
    @Autowired
    private IUserService myServiceImpl;

    @RequestMapping(value = "select", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo select() {
        UserInfo userInfo = myServiceImpl.selectUser("jack");
        return myServiceImpl.selectBySpringCache("jack");
    }

    @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(UserInfo userInfo) {
        myServiceImpl.updateUser(userInfo);
        return "{\"msg\":\"success\"}";
    }
}
