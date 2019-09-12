package com.sun.dev.springlistener;

import org.springframework.context.ApplicationEvent;

/**
 * Created by sunchengfei on 2019/2/20.
 */
public class MyEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public MyEvent(Object source) {
        super(source);
    }
}
