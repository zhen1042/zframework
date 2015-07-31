package com.zhen.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 字段对象注解，配合导入、导出，记录系统日志
 * User: Administrator
 * To change this template use File | Settings | File Templates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface FieldAnnotation {

    String comment();                   //字段注释(中文名称)

    boolean empty() default true;       //允许为空

    int len() default 0;                //长度(字符串)  整数位数(数字)

    int scale() default 0;              //精度(小数位)

    boolean exp() default true;         //是否导出

    boolean imp() default true;         //是否导入(下载模板，上传数据)

    boolean pk() default false;         //是否主键

    Class relation() default Object.class;       //外键关联表对象

    String fk() default "";              //外键对应列

    String show() default "";            //外键显示列

    String sheet() default "";           //工作薄名称

    String defaultValue() default "";    //默认值

}
