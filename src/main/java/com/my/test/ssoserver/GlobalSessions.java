package com.my.test.ssoserver;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chengfei.Sun on 17/01/23.
 */
public class GlobalSessions {
    //存放所有全局会话
    private static Map<String, HttpSession> sessions = new HashMap<String, HttpSession>();

    public static void addSession(String sessionId, HttpSession session) {
        sessions.put(sessionId, session);
    }

    public static void delSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public static HttpSession getSession(String sessionId) {
        return sessions.get(sessionId);
    }
}
