package com.my.test.ssoserver;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Date;

/**
 * @author Chengfei.Sun on 17/01/23.
 */
public class GlobalSessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("SessionListener：监听到session创建事件，" + new Date());
        GlobalSessions.addSession(httpSessionEvent.getSession().getId(), httpSessionEvent.getSession());
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("SessionListener：监听到session销毁事件，" + new Date());
        GlobalSessions.delSession(httpSessionEvent.getSession().getId());
    }
}
