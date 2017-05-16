package com.my.test.springaop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by Chengfei.Sun on 17/05/05.
 */
@Component
public class SimpleStaticPointcut extends DynamicMethodMatcherPointcut {
    private int count = 3;

    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        count--;
        if (count > 0) {
            return true;
        }
        return false;
    }

    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class cls) {
                return true;
            }
        };
    }
}
