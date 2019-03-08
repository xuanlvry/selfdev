package com.my.test.generic;

/**
 * Created by sunchengfei on 2019/2/27.
 */
public class Test<T> {
    public T getVar() {
        return null;
    }

    public T getVar(T t) {
        return t;
    }
    /** 泛型方法 */
    public <E> E geneMethod1(E t) {
        return t;
    }

    /** 泛型方法 */
    public <F> void geneMethod2(F t) {

    }
}
