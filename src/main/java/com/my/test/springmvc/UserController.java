package com.my.test.springmvc;

import com.my.test.IMyService;
import com.my.test.UserInfo;
import com.my.test.common.constants.ServiceResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Chengfei.Sun on 2015/9/8.
 */
@CrossOrigin(origins = {"xx","xx"}, methods = {RequestMethod.GET}, maxAge = 3600)
@Controller("userController")
@RequestMapping("user")
public class UserController {
    @Resource
    private IMyService myServiceImpl;

    @RequestMapping(value = "update", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse update(UserInfo userInfo) {
        ServiceResponse response = new ServiceResponse();
        try {
            myServiceImpl.updateUser(userInfo);
        } catch (Exception e) {
            response.setCode("9999");
            response.setMessage("服务器异常");
        }
        return response;
    }
}
