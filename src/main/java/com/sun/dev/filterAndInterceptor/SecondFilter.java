package com.sun.dev.filterAndInterceptor;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sunchengfei on 2018/1/24.
 */
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----SecondFilter初始化----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SecondFilter doFilter前");
        filterChain.doFilter(servletRequest, servletResponse);  //让目标资源执行，放行
        System.out.println("SecondFilter doFilter后");
    }

    @Override
    public void destroy() {
        System.out.println("----SecondFilter销毁----");
    }
}
