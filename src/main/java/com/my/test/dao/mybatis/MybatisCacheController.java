package com.my.test.dao.mybatis;

import com.my.test.IMyService;
import com.my.test.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Chengfei.Sun on 17/03/29.
 */
@Controller("mybatisCacheController")
@RequestMapping("mybatisCache")
public class MybatisCacheController {
    @Autowired
    private IMyService myServiceImpl;

    @RequestMapping(value = "selectbyid", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo select(@RequestParam("id") Long id) {
        return myServiceImpl.selectUser(id);
    }

    @RequestMapping(value = "selectbyaccount", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo select(@RequestParam("account") String account) {
        return myServiceImpl.selectUser(account);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(UserInfo userInfo) {
        myServiceImpl.updateUser(userInfo);
        return "{\"msg\":\"success\"}";
    }
}