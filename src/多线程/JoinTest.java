package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/07/10
//@time:下午 7:13
//@project:IDEA_JAVA
//@file:JoinTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class JoinTest extends JFrame {
    private Thread threadB;

    private JoinTest() {
        super();
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setSize( 100, 100 );
        setVisible( true );
        // 将进度条设置在窗体最北面
        // 定义两个进度条组件
        JProgressBar progressBar = new JProgressBar();
        getContentPane().add( progressBar, BorderLayout.NORTH );
        // 将另一条进度条放置在窗体最南面
        JProgressBar progressBar2 = new JProgressBar();
        getContentPane().add( progressBar2, BorderLayout.SOUTH );
        // 设置进度条显示数字
        progressBar.setStringPainted( true );
        progressBar2.setStringPainted( true );
        //使用匿名内部类初始化 Thread 实例
        // 定义两个线程
        Thread threadA = new Thread( new Runnable() {
            int count = 0;

            @Override
            public void run() {
                while (true) {
                    ++count;
                    progressBar.setValue( count );
                    try {
                        Thread.sleep( 100 );
                        if (count == 20) {
                            threadB.join();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } );
        threadA.start();
        threadB = new Thread( new Runnable() {
            int count = 0;

            @Override
            public void run() {
                do {
                    ++count;
                    progressBar2.setValue( count );
                    try {
                        Thread.sleep( 100 );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } while (count != 100);
            }
        } );
        threadB.start();
    }

    public static void main(String[] args) {
        new JoinTest();
    }

    @Override
    public final String toString() {
        return "JoinTest{" +
                "threadB=" + threadB +
                '}';
    }
}
