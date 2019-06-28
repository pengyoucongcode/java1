package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/28
//@time:19:35
//@project:IDEA_JAVA
//@file:GetConstuctorMain.java
//Author:御承扬
//email:2923616405@qq.com

import java.lang.reflect.Constructor;


public class GetConstructorMain {
    private GetConstructorMain() {

    }

    public static void main(String[] args) {
        GetConstructorTest example = new GetConstructorTest( "10", "20", "30" );
        Class<? extends GetConstructorTest> exampleC = example.getClass();
        // 获得所有构造方法
        Constructor[] declaredConstructors = exampleC.getDeclaredConstructors();
        int len = declaredConstructors.length;
        for (int i = 0; i < len; i++) {
            Constructor<?> constructor = declaredConstructors[i];
            System.out.println( "查看是否允许带有可变数量的参数：" + constructor.isVarArgs() );
            System.out.println( "该构造方法的入口参数类型依次为：" );
            // 获得所有参数类型
            Class[] parameterTypes = constructor.getParameterTypes();
            for (Class parameterType : parameterTypes) {
                System.out.println( " " + parameterType );
            }
            System.out.println( "该构造方法可能抛出的异常类型：" );
            //  获得所有可能抛出的异常信息类型
            Class[] exceptionTypes = constructor.getExceptionTypes();
            for (Class exceptionType : exceptionTypes) {
                System.out.println( " " + exceptionType );
            }
            GetConstructorTest example2 = null;
            while (example2 == null) {
                try {
                    if (i == 2)
                        example2 = (GetConstructorTest) constructor.newInstance();
                    else if (i == 1)
                        example2 = (GetConstructorTest) constructor.newInstance( "7", 5 );
                    else {
                        Object[] parameters = new Object[]{new String[]{"100", "200", "300"}};
                        example2 = (GetConstructorTest) constructor.newInstance( parameters );
                    }
                } catch (Exception e) {
                    System.out.println( "在创建对象时抛出异常，下面执行 setAccessible()" );
                    // 设置允许访问
                    constructor.setAccessible( true );
                }
            }
            example2.print();
            System.out.println();
        }
    }
}
