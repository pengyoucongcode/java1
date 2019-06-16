package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/16
//@time:11:04
//@project:IDEA_JAVA
//@file:LimitClass.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.*;

public class LimitClass<T extends List> {
    public static void main(String[] args) {
        //可以实例化已经实现的 List 接口类
        LimitClass<ArrayList> l1 = new LimitClass<>();
        LimitClass<LinkedList> l2 = new LimitClass<>();
        //下面这句是错误的
//        LimitClass<HashMap> l3 = new LimitClass<HashMap>();
    }
}
