package com.sun.dev.springbean;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by sunchengfei on 2019-11-21.
 */
@Component
public class ApplicationListenserImpl implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println();
        System.out.println("------------------ Spring容器初始化完成 -------------------");
        System.out.println();
    }
}
