package com.my.test.shiro;

import com.my.test.UserInfo;
import com.my.test.common.constants.ServiceResponse;
import com.my.test.common.enums.CommonResponseCodes;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * @author Chengfei.Sun on 16/11/11.
 */
@Controller("userShiroController")
@RequestMapping("user")
public class UserController {
    @RequestMapping(value = "login", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse login(UserInfo userInfo) {
        ServiceResponse serviceResponse = new ServiceResponse();

        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getAccount(), userInfo.getPassword());
//        token.setRememberMe(true);
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();

        try {
            System.out.println("对用户[" + userInfo.getAccount() + "]进行登录验证..验证开始");
            currentUser.login(token);
            System.out.println("对用户[" + userInfo.getAccount() + "]进行登录验证..验证通过");
        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse.setResponse(CommonResponseCodes.Fail);
        }
        return serviceResponse;
    }

    @RequestMapping(value = "register", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse register(UserInfo userInfo) {
        String salt1 = userInfo.getAccount();
        String salt2 = new SecureRandomNumberGenerator().nextBytes().toHex();
        int hashIterations = 2;
        SimpleHash hash = new SimpleHash("md5", userInfo.getPassword(), salt1 + salt2, hashIterations);
        String encodedPassword = hash.toHex();

        System.out.println(encodedPassword);

        return new ServiceResponse();
    }

    @RequestMapping(value = "info", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse info(UserInfo userInfo) {
        return this.commonPerms(userInfo);
    }

    @RequestMapping(value = "perms1", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse perms1(UserInfo userInfo) {
        return this.commonPerms(userInfo);
    }

    @RequestMapping(value = "perms2", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse perms2(UserInfo userInfo) {
        return this.commonPerms(userInfo);
    }

    @RequestMapping(value = "perms3", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public ServiceResponse perms3(UserInfo userInfo) {
        return this.commonPerms(userInfo);
    }

    private ServiceResponse commonPerms(UserInfo userInfo) {
        ServiceResponse response = new ServiceResponse();

        String account = (String) SecurityUtils.getSubject().getPrincipal();
        response.setObject(account);

        Collection<Object> keys = SecurityUtils.getSubject().getSession().getAttributeKeys();
        for (Object key : keys) {
            System.out.println("current session key:" + key);
            System.out.println("current session value:" + SecurityUtils.getSubject().getSession().getAttribute(key));
        }

        return response;
    }
}
