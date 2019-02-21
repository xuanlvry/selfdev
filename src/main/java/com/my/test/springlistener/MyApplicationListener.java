package com.my.test.springlistener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by sunchengfei on 2019/2/20.
 */
@Component
public class MyApplicationListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {
            System.out.println("AAAAAAAAAAAAAA：ContextRefreshedEvent触发调用MyApplicationListener");
        }
        if (event instanceof ContextStartedEvent) {
            System.out.println("AAAAAAAAAAAAAA：ContextStartedEvent触发调用MyApplicationListener");
        }
        if (event instanceof ContextClosedEvent) {
            System.out.println("AAAAAAAAAAAAAA：ContextClosedEvent触发调用MyApplicationListener");
        }
        if (event instanceof ContextStoppedEvent) {
            System.out.println("AAAAAAAAAAAAAA：ContextStoppedEvent触发调用MyApplicationListener");
        }
        if (event instanceof MyEvent) {
            System.out.println("AAAAAAAAAAAAAA：MyEvent触发调用MyApplicationListener");
        }
    }
}
