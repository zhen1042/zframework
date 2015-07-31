package com.zhen.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 表对象注解，定义表中文注释，导入导出使用
 * User: Administrator
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface TableAnnotation {

    String namespace() ;      //sqlmap namespace

    String comment()  ;       //表名注释(中文名称)

    String querySql() default "query";   //ibatis查询sql

    String createSql() default "create";  //ibatis插入记录sql

    String updateSql() default "update";  //ibatis更新记录sql

    String deleteSql() default "delete";  //ibatis删除记录sql

}
