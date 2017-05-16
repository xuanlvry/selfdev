package com.my.test.ssoserver;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author Chengfei.Sun on 17/01/23.
 */
@Controller("GlobalUserLogin")
@RequestMapping("global")
public class GlobalUserLogin {
    @Autowired
    private TokenUtil tokenUtil;

    @RequestMapping(value = "page/login", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String pageLogin(HttpServletRequest request) {
        String returnURL = request.getParameter("returnURL");
        System.out.println("");

        HttpSession session = GlobalSessions.getSession("");
        if (session == null) {
            System.out.println("用户中心不存在该用户session，进入登录页面");
            return "login";
        } else {
            System.out.println("用户中心存在该用户session，生成临时token");
            TokenInfo tokenInfo = new TokenInfo();
            tokenInfo.setUserId("001");
            tokenInfo.setUsername("tom");
            tokenInfo.setGlobalId(session.getId());
            //2.3.保存临时token，时效一分钟。且只能使用一次，用完即作废。
            String tokenId = UUID.randomUUID().toString();
            tokenUtil.setToken(tokenId, tokenInfo);

            return "redirect:" + returnURL + "?token=" + tokenId;
        }
    }

    @RequestMapping(value = "auth/login", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String authLogin(HttpServletRequest request) {
        String returnURL = request.getParameter("returnURL");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        //验证用户登录名及密码，这里简单示例
        if (userName.equals("tom") && password.equals("123456")) {
            //登录成功
            //1.生成全局session
            HttpSession session = request.getSession();
            session.setAttribute("user", userName);

            //2.返回
            //2.1.没有returnURL参数说明用户是直接从认证中心发起的登录请求
            if (StringUtils.isEmpty(returnURL)) {
                return "loginsuccess";
            }
            //2.2.有returnURL参数，产生临时认证令牌token
            TokenInfo tokenInfo = new TokenInfo();
            tokenInfo.setUserId("001");
            tokenInfo.setUsername("tom");
            tokenInfo.setGlobalId(session.getId());
            //2.3.保存临时token，时效一分钟。且只能使用一次，用完即作废。
            String tokenId = UUID.randomUUID().toString();
            tokenUtil.setToken(tokenId, tokenInfo);

            return "redirect:" + returnURL + "?token=" + tokenId;
        } else {
            //失败
            return "loginfail";
        }
    }

    @RequestMapping(value = "auth/verify", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public VerifyBean verify(HttpServletRequest request) {
        String token = request.getParameter("token");
        String localId = request.getParameter("localId");

        VerifyBean verifyBean = new VerifyBean();

        TokenInfo tokenInfo = tokenUtil.getToken(token);
        if (tokenInfo == null) {
            verifyBean.setRet("1");
        } else {
            verifyBean.setRet("0");
            verifyBean.setUserId(tokenInfo.getUserId());
            verifyBean.setUserName(tokenInfo.getUsername());
            verifyBean.setGlobalId(tokenInfo.getGlobalId());
        }
        return verifyBean;
    }

    @RequestMapping(value = "index", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        if (StringUtils.isEmpty(userName)) {
            return "login";
        }
        return "index";
    }
}
