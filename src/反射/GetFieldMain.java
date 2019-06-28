package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/28
//@time:22:05
//@project:IDEA_JAVA
//@file:GetFieldMain.java
//Author:御承扬
//email:2923616405@qq.com

import java.lang.reflect.*;


public class GetFieldMain {
    private GetFieldMain() {

    }

    public static void main(String[] args) {
        GetFieldTest example = new GetFieldTest();
        Class exampleC = example.getClass();
        // 获得所有成员变量
        Field[] declaredFields = exampleC.getDeclaredFields();
        for (Field field : declaredFields) {
            // 获得成员变量名称
            System.out.print( "名称为：" + field.getName() );
            // 获得成员变量类型
            Class fieldType = field.getType();
            System.out.println( "，类型为：" + fieldType );
            boolean isTurn = true;
            while (isTurn) {
                // 如果该变量的访问权限为 private， 则抛出异常，即不允许访问
                try {
                    isTurn = false;
                    // 获得成员变量
                    System.out.println( "修改前的值为：" + field.get( example ) );
                    if (fieldType.equals( int.class )) {
                        System.out.print( "利用 setInt 方法修改后的值：" );
                        field.setInt( example, 168 );
                    } else if (fieldType.equals( float.class )) {
                        System.out.print( "使用 setFloat 方法修改后的值：" );
                        field.setFloat( example, 99.9F );
                    } else if (fieldType.equals( boolean.class )) {
                        System.out.print( "使用 setBoolean 方法修改后的值：" );
                        field.setBoolean( example, true );
                    } else {
                        System.out.print( "使用 set 方法修改后的值：" );
                        field.set( example, "MWQ" );
                    }
                    // 获得成员变量的值
                    System.out.println( field.get( example ) );
                } catch (Exception e) {
                    System.out.println( "在设置成员变量值时抛出异常，"
                            + "下面执行 setAccessible 方法" );
                    field.setAccessible( true );
                    isTurn = true;
                }
            }
            System.out.println();
        }
    }
}
