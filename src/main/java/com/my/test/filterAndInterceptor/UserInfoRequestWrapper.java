package com.my.test.filterAndInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

/**
 * Created by sunchengfei on 2018/1/25.
 */
public class UserInfoRequestWrapper extends HttpServletRequestWrapper {
    public UserInfoRequestWrapper(HttpServletRequest request) {
        super(request);
    }

//    @Override
//    public Map getParameterMap() {
//        return null;
//    }
//
//    @Override
//    public String getParameter(String name) {
//        return "sadfasf";
//    }
//
//    @Override
//    public Enumeration getParameterNames() {
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("account", "adf");
//        map.put("name", "221");
//
//        Set<String> nameSet = new HashSet<String>();
//        nameSet.add("account");
//        nameSet.add("name");
//        nameSet.add("tel");
//        nameSet.add("address");
//
//        return Collections.enumeration(nameSet);
//    }
//
//    @Override
//    public String[] getParameterValues(String name) {
//        return new String[]{"111", "222"};
//    }

}
