package com.sun.dev.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("HelloWorld")
@RequestMapping("helloworld")
public class HelloWorld {
    @RequestMapping(value = "hello", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
    @ResponseBody
    public String hello() {
        return "hello";
    }
}
