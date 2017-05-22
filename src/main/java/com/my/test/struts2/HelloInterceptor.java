package com.my.test.struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by sunchengfei on 2017/5/22.
 */
public class HelloInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("");
        return null;
    }
}
