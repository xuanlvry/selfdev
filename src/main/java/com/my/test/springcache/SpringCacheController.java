package com.my.test.springcache;

import com.my.test.UserInfo;
import com.my.test.IMyService;
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
    private IMyService myServiceImpl;

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
