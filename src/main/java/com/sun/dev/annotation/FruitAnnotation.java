package com.sun.dev.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Chengfei.Sun on 17/01/11.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FruitAnnotation {
    String value() default "默认value";

    String fruitName() default "默认fruitName";

    boolean isOk() default true;
}
