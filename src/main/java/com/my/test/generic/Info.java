package com.my.test.generic;

/**
 * Created by sunchengfei on 2019/2/27.
 */
public interface Info<T> {
    T getVar();

    void setVar(T t);
}
