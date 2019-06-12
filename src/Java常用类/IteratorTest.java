package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/12
//@time:22:45
//@project:IDEA_JAVA
//@file:IteratorTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;
public class IteratorTest {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String str = (String)it.next();
            System.out.println(str);
        }
    }
}
