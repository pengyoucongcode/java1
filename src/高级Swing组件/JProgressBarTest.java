package 高级Swing组件;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级Swing组件
//@user:彭友聪
//@date:2019/08/08
//@time:上午 10:25
//@project:IDEA_JAVA
//@file:JProgressBarTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JProgressBarTest extends JFrame {
    class Progress extends Thread {
        private final int[] progressValue = {6, 18, 27, 39, 51, 66, 81, 100};
        private JProgressBar progressBar;   // 进度条对象
        private JButton button;    // 完成按钮对象

        public Progress(JProgressBar progressBar, JButton button) {
            this.progressBar = progressBar;
            this.button = button;
        }

        public final void run() {
            try {
                Thread.sleep( 3000 );
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            progressBar.setIndeterminate( false );  // 采用确定进度进度条
            // 通过循环更新任务完成百分比
            for (int value : progressValue) {
                progressBar.setValue( value );
                try {
                    Thread.sleep( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            progressBar.setString( "升级完成！" );
            button.setEnabled( true );  // 设置按钮可用
        }
    }
    private JProgressBarTest() {
        super();
        setTitle( "进度条示例" );
        setBounds(100,100,500,375);
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        getContentPane().setLayout( null );

        final JLabel label = new JLabel( "欢迎使用在线升级功能！" );
        label.setBounds( 3,11,187,23 );
        label.setForeground( new Color(255,0,0) );
        label.setFont( new Font( "",Font.BOLD,16 ) );
        getContentPane().add(label);

        final JProgressBar progressBar = new JProgressBar(  );
        progressBar.setBounds( 23,39,146,16 );
        progressBar.setStringPainted( true );   // 设置显示提示信息
        progressBar.setIndeterminate( true );   // 设置不确定进度进度条
        progressBar.setString( "升级进行中....." );
        getContentPane().add( progressBar );

        final JButton button = new JButton( "完成" );
        button.setBounds( 177,61,63,23 );
        button.setEnabled( false );
        button.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit( 0 );
            }
        } );
        getContentPane().add( button );
        new Progress( progressBar,button ).start(); // 利用线程模拟一个升级任务
    }

    public static void main(String[] args) {
        JProgressBarTest frame = new JProgressBarTest();
        frame.setVisible( true );
    }
}
