package com.sun.dev.shiro;

import com.sun.dev.service.UserInfo;
import com.sun.dev.dao.mybatis.IUserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Chengfei.Sun on 16/11/11.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    IUserMapper userMapper;

    /**
     * 验证当前登录的Subject
     * 本例中该方法的调用时机为执行Subject.login()时
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName = token.getUsername();

//        Collection<Session> sessions = sessionDAO.getActiveSessions();
//        for(Session session:sessions){
//            String loginUsername = String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY));
//
//            if(userName.equals(loginUsername)){  //这里的username也就是当前登录的username
//                session.setTimeout(0);  //这里就把session清除，
//                sessionDAO.delete(session);
//            }
//        }

        /**
        //实现方式2
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager) securityManager.getSessionManager();
        SessionDAO sessionDAO = sessionManager.getSessionDAO();
        Collection<Session> sessions = sessionDAO.getActiveSessions();//获取当前已登录的用户session列表
        for (Session session : sessions) {
            //获得session中已经登录用户的名字
            String loginedUserName = (String) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            //清除该用户以前登录时保存的session
            if (userName.equals(loginedUserName)) {
                sessionDAO.delete(session); //或者 session.setTimeout(0);
            }
        }
         */

        UserInfo userInfo = userMapper.selectUserByAccount(userName);

        if (userInfo != null) {
            SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo(userInfo.getAccount(), userInfo.getPassword(), this.getName());
            authcInfo.setCredentialsSalt(ByteSource.Util.bytes(userInfo.getAccount() + userInfo.getSalt())); //盐是用户名+随机数

            return authcInfo;
        }

        return null;
    }

    /**
     * 为当前登录的Subject授予角色和权限
     * 本例中该方法的调用时机为需授权资源被访问时
     *
     * @param principals
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        if (username.equals("tom")) {
            authorizationInfo.addRole("admin");
        } else {
            authorizationInfo.addRole("user");
        }
        authorizationInfo.addStringPermission("hh");

        return authorizationInfo;
    }

    /**
     * 将一些数据放到ShiroSession中,以便于其它地方使用
     *
     * @see比如Controller，使用时直接用HttpSession.getAttribute(key)就可以取到
     */
    private void setSession(Object key, Object value) {
        Subject subject = SecurityUtils.getSubject();
        if (null != subject) {
            Session session = subject.getSession();
            System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }
}
