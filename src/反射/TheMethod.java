package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/29
//@time:9:37
//@project:IDEA_JAVA
//@file:TheMethod.java
//Author:御承扬
//email:2923616405@qq.com


public class TheMethod {
    static void staticMethod() {
        System.out.println( "执行 staticMethod 方法" );
    }
    public int publicMethod(int i) {
        System.out.println( "执行 publicMethod 方法" );
        return i*100;
    }
    protected int protectedMethod (String s, int i) throws NumberFormatException {
        System.out.println( "执行 protectedMethod 方法" );
        return Integer.valueOf( s ) + i;
    }
    private String privateMethod (String ... strings) {
        System.out.println( "执行 privateMethod 方法" );
        StringBuilder stringBuffer = new StringBuilder(  );
        int len = strings.length;
        for (int i=0;i < len; i++) {
            stringBuffer.append( strings[i] );
        }
        return stringBuffer.toString();
    }
}
