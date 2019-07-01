package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/7/1
//@time:10:05
//@project:IDEA_JAVA
//@file:ThreadTest.java
//Author:御承扬
//email:2923616405@qq.com


public class ThreadTest extends Thread{
    private int count = 10;
    public void run() {
        do {
            System.out.print( count + " " );
            --count;
        } while (count != 0);
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.start(); // 启动线程
    }
}
