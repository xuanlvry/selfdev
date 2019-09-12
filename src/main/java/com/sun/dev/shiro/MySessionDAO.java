package com.sun.dev.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chengfei.Sun on 16/11/16.
 */
public class MySessionDAO extends AbstractSessionDAO {
    private Map<Serializable, Session> map = new HashMap<Serializable, Session>();

    protected Serializable doCreate(Session session) {
        System.out.println("now doCreate session");
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        map.put(sessionId, session);

        return sessionId;
    }

    protected Session doReadSession(Serializable sessionId) {
        System.out.println("now doReadSession session");
        return map.get(sessionId);
    }

    public void update(Session session) throws UnknownSessionException {
        System.out.println("now update session");
        map.put(session.getId(), session);
    }

    public void delete(Session session) {
        System.out.println("now delete session");
        map.remove(session.getId());
    }

    public Collection<Session> getActiveSessions() {
        System.out.println("now getActiveSessions session");
        return map.values();
    }
}
