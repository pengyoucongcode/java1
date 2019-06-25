package 高级事件处理;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级事件处理
//@user:彭友聪
//@date:2019/6/25
//@time:12:59
//@project:IDEA_JAVA
//@file:WindowStateListener_Example.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

public class WindowStateListener_Example extends JFrame {
    public static void main(String[] args) {
        WindowStateListener_Example frame = new WindowStateListener_Example();
        frame.setVisible(true);
    }

    private WindowStateListener_Example() {
        super();
        addWindowStateListener(new myWindowStateListener());
        setTitle("捕获窗体状态事件");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private class myWindowStateListener implements WindowStateListener {

        @Override
        public void windowStateChanged(WindowEvent e) {
            int oldState = e.getOldState();
            int newState = e.getNewState();
            String from;
            String to;
            from = getString(oldState);
            to = getString(newState);
            System.out.println(from+"->"+to);
        }

        private String getString(int newState) {
            String to;
            switch (newState) {
                case Frame.NORMAL:
                    to = "正常化";
                    break;
                case Frame.MAXIMIZED_BOTH:
                    to = "最大化";
                    break;
                default:
                    to = "最小化";
            }
            return to;
        }
    }
}
