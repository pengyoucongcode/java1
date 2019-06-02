package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/2
//@time:20:04
//@project:IDEA_JAVA
//@file:ExponentFunction.java
//Author:御承扬
//email:2923616405@qq.com
public class ExponentFunction {
    public static void main(String[] args) {
        //取e的2次方
        System.out.println("e的平方值："+Math.exp(2));
        //取e为底2的对数
        System.out.println("e为底2的对数值:"+Math.log(2));
        //取以10为底的2的对数
        System.out.println("以10为底的2的对数值："+Math.log10(2));
        //取4的平方根
        System.out.println("4的平方根："+Math.sqrt(4));
        //取8的立方根
        System.out.println("8的立方根："+Math.cbrt(8));
        //2的2次方
        System.out.println("2的2次方："+Math.pow(2,2));
    }
}
