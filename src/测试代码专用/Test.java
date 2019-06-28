package 测试代码专用;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:测试代码专用
//@user:彭友聪
//@date:2019/6/28
//@time:12:36
//@project:IDEA_JAVA
//@file:Test.java
//Author:御承扬
//email:2923616405@qq.com

class Demo {
    public Demo() {
        System.out.println( "I am trying!" );
    }

}

public class Test {
    private Test() {

    }

    public static void main(String[] args) {
        Class a = Demo.class; // 使用类的 class 属性创建对象
        System.out.println( "第一个反射对象的哈希码：" + a.hashCode() );
        try {
            Class b = Class.forName("测试代码专用.Demo"); // 使用 Class 类的 forName 方法创建对象
            System.out.println( "第 2 个反射对象的哈希码："+b.hashCode() ); // 输出对象的哈希码
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Demo demo = new Demo(); //  创建 Demo 对象
        Class c = demo.getClass(); // 使用 Object 对象
        System.out.println( "第3 个反射对象的哈希码："+c.hashCode() );
    }
}
