package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/07/18
//@time:上午 9:10
//@project:IDEA_JAVA
//@file:ThreadSafeTest.java
//Author:御承扬
//email:2923616405@qq.com


public class ThreadSafeTest implements Runnable {
    private int num = 10; // 设置当前票总数

    public final void run() {
        while (true) {
            if (num > 0) {
                try {
                    Thread.sleep( 100 );
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.printf( "%s票数%d\n", Thread.currentThread().getName(), num );
                num--;
            }
        }
    }

    public static void main(String[] args) {
        ThreadSafeTest t = new ThreadSafeTest();
        Thread t1 = new Thread( t,"线程一" );
        Thread t2 = new Thread( t,"线程二" );
        Thread t3 = new Thread( t,"线程三" );
        Thread t4 = new Thread( t,"线程四" );
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
