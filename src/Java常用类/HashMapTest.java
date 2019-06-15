package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/13
//@time:22:33
//@project:IDEA_JAVA
//@file:HashMapTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();  //创建Map对象
        map.put("ISBN-978654", "Java从入门到精通");  //添加对象
        map.put("ISBN-978361", "Android 从入门到精通");
        map.put("ISBN-978893", "21天学Andorid");
        map.put("ISBN-978756", "21天学Java");

        Set<String> set = map.keySet();  //构建键集合
        Collection<String> coll = map.values(); //构建值集合
        Iterator<String> it1, it2;  //创建键值迭代器
        it1 = set.iterator();
        it2 = coll.iterator();
        System.out.println("key值\tvalue值");
        while (it1.hasNext() && it2.hasNext()) {
            System.out.println(it1.next() + "\t" + it2.next());  //遍历对像
        }


        System.out.println("===================================\n\tTreeMap traver:");
        TreeMap<String, String> treemap = new TreeMap<>();  // 创建TreeMap 对象
        treemap.putAll(map);  // 向集合添加元素
        Iterator<String> iter = treemap.keySet().iterator();
        while (iter.hasNext()) {
            String str = (String) iter.next();
            String name = (String) treemap.get(str);
            System.out.println(str + ":" + name);
        }
    }
}
