package com.zhiyaya.zhiyayaweb.annotation;

import com.zhiyaya.zhiyayaweb.constants.Role;

import java.lang.annotation.*;

/**
 * Created by qianhao.zhou on 8/9/16.
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Authentication {
    Role[] value() default {Role.User, Role.Admin};
}
