package com.sun.dev.dao.mybatis;

import com.sun.dev.service.IUserService;
import com.sun.dev.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Chengfei.Sun on 17/03/29.
 */
@Controller("mybatisCacheController")
@RequestMapping("mybatisCache")
public class MybatisCacheController {
    @Resource
    private IUserService userServiceImpl;

    @RequestMapping(value = "selectbyid", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo select(@RequestParam("id") Long id) {
        return userServiceImpl.selectUser(id);
    }

    @RequestMapping(value = "selectbyaccount", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public UserInfo select(@RequestParam("account") String account) {
        return userServiceImpl.selectUserByAccount(account);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String update(UserInfo userInfo) {
        userServiceImpl.updateUser(userInfo);
        return "{\"msg\":\"success\"}";
    }
}
