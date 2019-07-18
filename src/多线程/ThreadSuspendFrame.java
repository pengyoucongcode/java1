package 多线程;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:多线程
//@user:彭友聪
//@date:2019/07/18
//@time:上午 10:54
//@project:IDEA_JAVA
//@file:ThreadSuspendFrame.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ThreadSuspendFrame extends JFrame {
    private JLabel label; //显示数字的标签
    private ThreadSuspend t; // 自定义线程类

    /*
     *   在主类中创建内部类，自定义线程类
     */
    class ThreadSuspend extends Thread {
        /*
         *   线程挂起状态，若 suspend 为 false，线程正常运行；反之，线程会处于挂起状态
         */
        private boolean suspend = false;

        // 线程安全地暂停的方法
        final synchronized void toSuspend() {
            suspend = true;
        }
        // 线程安全地恢复运行的方法，将 suspend 变为 false 的同时调用超级父类的 notify() 方法
        final synchronized void toRun() {
            suspend = false;
            notify();
        }
        @Override
        public void run() {
            // 定义中奖号码池
            String[] phoneNums = {"13610780204", "13847928544", "18457839454", "18423098757", "17947928544", "19867534533"};
            while (true) {
                synchronized ( this ) {
                    while(suspend) {
                        //判断线程是否要暂停
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                // 获取一个 phoneNums 数据的随机索引
                int randomIndex = new Random(  ).nextInt( phoneNums.length );
                String phoneNum = phoneNums[randomIndex];
                label.setText( phoneNum );
            }
        }
    }
    private ThreadSuspendFrame() {
        setTitle( "手机号码抽奖" );  // 窗口标题
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setBounds( 200,200,300,150 );
        // 初始化标签
        label = new JLabel( "0" );
        label.setHorizontalAlignment( SwingConstants.CENTER );
        label.setFont( new Font( "楷体",Font.PLAIN,42 ) );
        getContentPane().add(label,BorderLayout.CENTER);
        JButton btn = new JButton( "暂停" );
        getContentPane().add(btn,BorderLayout.SOUTH);
        t = new ThreadSuspend();
        t.start();
        btn.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String btnText = btn.getText();
                if(btnText.equals( "暂停" )) {
                    t.toSuspend();
                    btn.setText( "继续" );
                }
                else {
                    t.toRun();
                    btn.setText( "暂停" );
                }
            }
        } );
        setVisible( true );
    }

    public static void main(String[] args) {
        new ThreadSuspendFrame();
    }
}
