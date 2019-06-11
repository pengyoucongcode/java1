package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/9
//@time:9:19
//@project:IDEA_JAVA
//@file:MathRandomChar.java
//Author:御承扬
//email:2923616405@qq.com

public class MathRandomChar {
    public static char GetRandomChar(char c1, char c2){
        return (char)(c1+Math.random()*(c2-c1+1));
    }

    public static void main(String[] args) {
        //获取a~z之间随机字符
        System.out.println("任意小写字符："+GetRandomChar('a','z'));
        //获取A~Z之间的随机字符
        System.out.println("任意大写字符："+GetRandomChar('A','Z'));
        //获取0~9之间的随机字符
        System.out.println("0~9的任意字符："+GetRandomChar('0','9'));
    }
}
