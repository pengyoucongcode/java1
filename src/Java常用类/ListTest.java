package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/12
//@time:21:35
//@project:IDEA_JAVA
//@file:ListTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(); //创建集合对象
        //向集合中添加元素
        list.add("A");
        list.add("B");
        list.add("C");
        int i = (int)(Math.random()*list.size());  //获得0~2之间的随机数
        System.out.println("随机获取数组中的元素："+list.get(i));
        list.remove(2);  //移除集合中指定索引位置的元素
        System.out.println("将索引2的元素移除后，数组中的元素是：");
        for(int j=0;j<list.size();j++){
            System.out.println(list.get(j));
        }
    }
}
