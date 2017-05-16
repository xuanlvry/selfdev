package com.my.test.sso.cas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Chengfei.Sun on 17/01/23.
 */
@Controller("ResourceController")
@RequestMapping("resource")
public class ResourceController {

    @RequestMapping(value = "index", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    public String pageLogin(HttpServletRequest request) {
        return "index";
    }
}
