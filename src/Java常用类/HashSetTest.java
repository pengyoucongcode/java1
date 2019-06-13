package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/13
//@time:21:45
//@project:IDEA_JAVA
//@file:HashSetTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;

public class HashSetTest {
    public static void main(String[] args) {
        Set set = new HashSet();  //创建Set 集合
        set.add("c");
        set.add("c");
        set.add("a");
        set.add("b");
        Iterator<String> it;  //创建迭代器
        it = set.iterator();
        while(it.hasNext()){    //遍历 HashSet 集合
            String str = (String)it.next();  //获取集合中的元素
            System.out.println(str);
        }
    }
}
