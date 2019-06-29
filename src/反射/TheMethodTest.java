package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/29
//@time:9:48
//@project:IDEA_JAVA
//@file:TheMethodTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.lang.reflect.Method;


public class TheMethodTest {
    private TheMethodTest(){

    }

    public static void main(String[] args) {
        TheMethod example = new TheMethod();
        Class exampleC = example.getClass();
        // 获得所有方法
        Method[] declaredMethods = exampleC.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.print( "方法名称："+method.getName() );
            System.out.println( "，是否允许带有可变数量参数："+method.isVarArgs() );
            System.out.print( "入口参数类型依次为：" );
            // 获得所有参数类型
            Class[] parameterTypes = method.getParameterTypes();
            for (Class type : parameterTypes) {
                System.out.print( " "+type );
            }
            System.out.println(  );
            // 获得返回值类型
            System.out.print( "返回值类型为："+method.getReturnType() );
            System.out.print( "，可能抛出的异常类型有：" );
            Class[] exceptionTypes = method.getExceptionTypes();
            for (Class exception : exceptionTypes) {
                System.out.print( " "+exception );
            }
            System.out.println(  );
            boolean isTurn = true;
            while (isTurn) {
                // 如果该方法的访问权限为 private， 则抛出异常，即不允许访问
                try {
                    isTurn = false;
                    if ("staticMethod".equals( method.getName() ))
                        method.invoke( example );
                    else if ("publicMethod".equals( method.getName() ))
                        System.out.println( "返回值为："+method.invoke( example,168 ) );
                    else if ("protectedMethod".equals( method.getName() ))
                        System.out.println( "返回值为："+method.invoke( example,"7",5 ) );
                    else if ("privateMethod".equals( method.getName() )) {
                        Object[] parameters = new Object[] { new String[] {
                                "M", "W", "Q"
                        }};
                        System.out.println( "返回值为："+method.invoke( example, parameters ) );
                    }
                } catch (Exception e) {
                    System.out.println( "在执行方法时出现异常，"
                    + "下面执行 setAccessible 方法！");
                    method.setAccessible( true );
                    isTurn = true;
                }
            }
            System.out.println(  );
        }
    }
}
