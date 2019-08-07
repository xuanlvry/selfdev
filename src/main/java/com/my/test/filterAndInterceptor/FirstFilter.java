package com.my.test.filterAndInterceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by sunchengfei on 2018/1/24.
 */
public class FirstFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----FirstFilter初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("FirstFilter doFilter前");

        UserInfoRequestWrapper requestWrapper = new UserInfoRequestWrapper((HttpServletRequest) servletRequest);
        //doFilter()方法：激活调用chain中的下一个filter。如果当前filter为最后一个filter，则继续调用request resource
        filterChain.doFilter(requestWrapper, servletResponse);

        //doFilter()整个链路调用完成后，执行线程还会回到该位置，继续执行
        System.out.println("FirstFilter doFilter后");
    }

    @Override
    public void destroy() {
        System.out.println("----FirstFilter销毁----");
    }
}
