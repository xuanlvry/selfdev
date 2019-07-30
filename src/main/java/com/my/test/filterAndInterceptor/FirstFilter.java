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
        filterChain.doFilter(requestWrapper, servletResponse);  //让目标资源执行，放行
        System.out.println("FirstFilter doFilter后");
    }

    @Override
    public void destroy() {
        System.out.println("----FirstFilter销毁----");
    }
}
