package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/30
//@time:21:16
//@project:IDEA_JAVA
//@file:annotationTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.lang.reflect.Field;


public class annotationTest {
    private annotationTest(){

    }

    public static void main(String[] args) {
        Class<CellPhone> c = CellPhone.class; // 创建反射对象
        Field[] fields = c.getDeclaredFields(); // 获取所有类中的所有属性
        // 遍历属性数组
        for (Field field : fields) {
            // 判断 CellPhone 类中是否具有 PhoneAnnotation 类型的注解
            if (field.isAnnotationPresent( PhoneAnnotation.class )) {
                // 获取指定类型的注解
                PhoneAnnotation phoneAnnotation = field.getAnnotation( PhoneAnnotation.class );
                System.out.println( field.getName()+"属性注解：备注="+phoneAnnotation.remarks()+"，是否有效="+phoneAnnotation.enable() );
            }
        }
    }
}
