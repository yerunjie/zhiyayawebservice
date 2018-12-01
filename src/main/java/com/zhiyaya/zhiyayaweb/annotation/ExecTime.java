package com.zhiyaya.zhiyayaweb.annotation;

import java.lang.annotation.*;

/**
 * Created by zhouqianhao on 11/03/2017.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExecTime {
    String value() default "";
}