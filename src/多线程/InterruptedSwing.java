package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/07/17
//@time:下午 4:30
//@project:IDEA_JAVA
//@file:InterruptedSwing.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;

public class InterruptedSwing extends JFrame {

    private InterruptedSwing(){
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setSize(100,100);
        setVisible( true );
        final JProgressBar progressBar = new JProgressBar(  ); // 创建进度条
        // 将进度条放置到合适的位置
        getContentPane().add(progressBar, BorderLayout.NORTH );
        progressBar.setStringPainted( true ); // 设置进度条上显示数字
        // 执行线程停止方法
        Thread thread = new Thread() {
            int count = 0;

            public void run() {
                while (true) {
                    ++count;
                    progressBar.setValue( count );
                    try {
                        if (count == 30) {
                            interrupt(); // 执行线程停止方法
                        }
                        Thread.sleep( 100 );
                    } catch (InterruptedException e) {
                        System.out.println( "当前线程被中断" );
                        break;
                    }
                }
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        new InterruptedSwing();
    }
}
