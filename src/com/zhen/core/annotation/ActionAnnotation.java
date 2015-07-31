package com.zhen.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 动作注解，配合权限拦截器使用，记录日志
 * User: Administrator
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ActionAnnotation {
    public enum Type {NO, LOGIN, LOGIN_GROUP}

    String name() default "";           //动作名称描述

    String group() default "";          //动作功能分组

    boolean log() default false;        //是否写日志

    Type check() default Type.LOGIN;       //验证权限的类型 NO: 不需要验证登录  LOGIN: 只验证登录 LOGIN_GROUP: 验证登录和请求动作

}
