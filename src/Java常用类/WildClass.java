package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/16
//@time:11:39
//@project:IDEA_JAVA
//@file:WildClass.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;

public class WildClass {
    public static void main(String[] args) {
        List<String> l1 = new ArrayList<>();  //创建一个ArrayList对象
        l1.add("成员");
        List<?> l2 = l1; //使用通配符
        List<?> l3 = new  LinkedList<Integer>();
        System.out.println("l1:"+l1.get(0));  // 获取l1集合的第一个值
        System.out.println("l2:"+l2.get(0));  //获取l2集合的第一个值
        l1.set(0,"成员改变");
//        l2.add("添加");  //使用通配符的对象不能使用 add 方法
//        l2.set(0,"成员改变");  //使用通配符的对象不能使用 set 方法
//        l3.add(1);
//        l3.set(0,1);
        System.out.println("l1:"+l1.get(0));
    }
}
