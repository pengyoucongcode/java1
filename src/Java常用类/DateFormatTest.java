package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/10
//@time:17:40
//@project:IDEA_JAVA
//@file:DateFormatTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
public class DateFormatTest {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df1 = DateFormat.getInstance();
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE");
        DateFormat df3 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE",Locale.CHINA);
        DateFormat df4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE",Locale.US);
        DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df6 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println("--------------将日期时间按照不同格式输出----------------");
        System.out.println("按照java默认日期格式："+df1.format(date));
        System.out.println("按照yyyy-MM-dd hh:mm:ss,系统默认区域："+df2.format(date));
        System.out.println("按照yyyy年MM月dd日 hh时mm分ss秒,区域中国："+df3.format(date));
        System.out.println("按照yyyy-MM-dd hh:mm:ss,区域美国："+df4.format(date));
        System.out.println("按照yyyy-MM-dd格式："+df5.format(date));
        System.out.println("按照yyyy年MM月dd日格式："+df6.format(date));

    }
}
