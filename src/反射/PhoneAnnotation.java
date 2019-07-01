package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/30
//@time:20:56
//@project:IDEA_JAVA
//@file:PhoneAnnotation.java
//Author:御承扬
//email:2923616405@qq.com

import java.lang.annotation.*;
@Target( ElementType.FIELD )  // 注解用于成员属性
@Retention( RetentionPolicy.RUNTIME )  // 在运行时保留

public @interface PhoneAnnotation { // 创建一个名为 “手机信息” 的注解
    public String remarks() default " "; // 备注，默认值为空白字符串
    public boolean enable() default true; // 是否启用，默认值为 true。

}
