package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/15
//@time:21:51
//@project:IDEA_JAVA
//@file:MutiOverClass.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.HashMap;
import java.util.Map;

public class MutiOverClass<K, V> {
    public Map<K, V> m = new HashMap<K, V>();

    public void put(K k, V v) {
        m.put(k, v);
    }

    public V get(K k) {
        return m.get(k);
    }

    public static void main(String[] args) {
        MutiOverClass<Integer, String> mu = new MutiOverClass<>();
        for (int i = 0; i < 5; i++) {
            char temp = (char) ('A'+i);
            mu.put(i, "我是集合成员" + temp);
        }
        for (int i = 0; i < mu.m.size(); i++) {
            System.out.println(mu.get(i));
        }
    }
}
