package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/14
//@time:16:28
//@project:IDEA_JAVA
//@file:ContantsTest.java
//Author:御承扬
//email:2923616405@qq.com

//将常量放置在接口中
interface Constants {
    public static final int Constants_A = 1;
    public static final int Constants_B = 12;
}

public class ContantsTest {
    //将常量放置在枚举类型中
    enum Constants2 {
        Constants_A, Constants_B
    }

    //使用接口定义常量
    //定义一个方法，参数为 int 型，根据常量的值得不同做不同操作
    public static void doit(int c) {
        switch (c) {
            case Constants.Constants_A:
                System.out.println("doit() Constants_A");
                break;
            case Constants.Constants_B:
                 System.out.println("doit() Constants_B");
                 break;
        }
    }

    //定义一个参数对象是枚举类型的方法，根据枚举类型对象的不同做不同操作
    public static void doit2(Constants2 c){
        switch(c){
            case Constants_A:
                System.out.println("doit2() Constants_A");
                break;
            case Constants_B:
                System.out.println("doit2() Constants_B");
                break;
        }
    }

    public static void main(String[] args) {
        ContantsTest.doit(Constants.Constants_A);  //使用接口中定义的常量
        ContantsTest.doit2(Constants2.Constants_A);  //使用枚举类型中的常量
        ContantsTest.doit2(Constants2.Constants_B);  //使用枚举类型中的常量
        ContantsTest.doit(3);
    }
}
