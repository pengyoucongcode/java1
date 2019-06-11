package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/11
//@time:22:06
//@project:IDEA_JAVA
//@file:OlympicWinterGames.java
//Author:御承扬
//email:2923616405@qq.com

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
public class OlympicWinterGames {
    public static void main(String[] args) {
        System.out.println("冬奥会倒计时");
        Date date = new Date();
        SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
        String today = formate.format(date);
        System.out.println("今天是："+today);
        long time1 = date.getTime();
        Calendar cal = Calendar.getInstance();
        cal.set(2022,2-1,4);
        long time2 = cal.getTimeInMillis();
        long day = (time2 - time1)/(1000*60*60*24);
        System.out.println("距离2022年“北京-张家口”冬奥会还有"+day+"天");
    }
}
