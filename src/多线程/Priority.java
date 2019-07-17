package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/07/17
//@time:下午 7:56
//@project:IDEA_JAVA
//@file:Priority.java
//Author:御承扬
//email:2923616405@qq.com


public class Priority extends Thread {
    private String threadName; // 线程的名字
    private String output;

    // 以线程名、控制台输出的信息为参数的构造方法，利用构造方法初始化变量
    Priority(String threadName, String output) {
        this.threadName = threadName;
        this.output = output;
    }

    @Override
    public void run() {  // 线程要执行的任务
        System.out.print( threadName + ":" + output + " " );
    }
}

