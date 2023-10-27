package com.sun.dev.springmvc;

import com.sun.dev.common.constants.ServiceResponse;
import com.sun.dev.service.IUserService;
import com.sun.dev.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 * @author Chengfei.Sun on 2015/9/8.
 */
@Controller("userController")
@RequestMapping("user")
public class UserController {
    @Resource
    private IUserService userServiceImpl;

    @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse update(UserInfo userInfo) {
        ServiceResponse response = new ServiceResponse();
        try {
            userServiceImpl.updateUser(userInfo);
        } catch (Exception e) {
            response.setCode("9999");
            response.setMessage("服务器异常");
        }
        return response;
    }

    @RequestMapping(value = "queryByAccount", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse queryByAccount(String account) {
        ServiceResponse response = new ServiceResponse();
        try {
            //UserInfo userInfo = userServiceImpl.selectUserByAccount("f28L3M1re5");
            WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
            IUserService userService = (IUserService) webApplicationContext.getBean("userServiceImpl");
            UserInfo userInfo = userService.selectUserByAccount(account);
            response.setObject(userInfo);
        } catch (Exception e) {
            response.setCode("9999");
            response.setMessage("服务器异常");
        }
        return response;
    }
}
