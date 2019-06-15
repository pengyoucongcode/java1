package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/15
//@time:17:33
//@project:IDEA_JAVA
//@file:OverClass.java
//Author:御承扬
//email:2923616405@qq.com


public class OverClass<T> {
    private T over;  //定义泛型成员变量

    public T getOver() {
        return over;
    }

    public void setOver(T over) {
        this.over = over;
    }

    public static void main(String[] args) {
        OverClass<Boolean> over1 = new OverClass<Boolean>();  //实例化Boolean型对象
        OverClass<Float> over2 = new OverClass<Float>();  //实例化Float型对象

        over1.setOver(true);  //不需要进行向上转型
        over2.setOver(12.45f);

        Boolean b = over1.getOver();  //不需要进行向下转型
        Float f = over2.getOver();

        System.out.println("Boolean over1:"+b);
        System.out.println("Float over2:"+f);
    }
}
