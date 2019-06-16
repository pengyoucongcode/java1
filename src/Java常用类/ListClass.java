package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/16
//@time:9:57
//@project:IDEA_JAVA
//@file:ListClass.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;

public class ListClass {
    public static void main(String[] args) {
        //定义List容器，设置容器内的值类型为 Integer
        List<Integer> a = new ArrayList<Integer>();
        a.add(520);  //为容器添加新值
        for (int i = 0; i < a.size(); i++) {
            System.out.println("获取ArrayList容器内的值：" + a.get(i));
        }

        //定义Map容器，设置容器内的键名和键值为Integer和String
        Map<Integer, String> m = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            m.put(i, "成员" + i);  //为容器添加键值对
        }
        for (int i = 0; i < m.size(); i++) {
            System.out.println("获取Map容器的值：" + m.get(i));
        }

        //定义Set容器，设置值类型为Charcter
        Set<Character> set = new HashSet<>();
        set.add('一');
        set.add('二');
        //使用 foreach循环，将Set中的元素按照Character类型进行循环遍历
        for(Character c : set){
            System.out.println("获取Set容器的值："+c);
        }

    }
}
