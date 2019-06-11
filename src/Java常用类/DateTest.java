package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/10
//@time:15:52
//@project:IDEA_JAVA
//@file:DateTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.Date;
public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        long value = date.getTime();
        System.out.println("日期："+date);
        System.out.println("到现在所经历的毫秒数为："+value);
    }
}
