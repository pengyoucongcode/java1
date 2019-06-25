package 高级事件处理;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:高级事件处理
//@user:彭友聪
//@date:2019/6/25
//@time:15:01
//@project:IDEA_JAVA
//@file:WindowListener_Example.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListener_Example extends JFrame {
    private class MyWindowListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("窗口被打开！");
        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("窗口将要被关闭！");
        }

        @Override
        public void windowClosed(WindowEvent e) {
            System.out.println("窗口已经被关闭！");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("窗口被最小化！");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println("窗口恢复正常大小！");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("窗口被激活！");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("窗口失去激活！");
        }
    }
    private WindowListener_Example(){
        super();
        addWindowListener(new MyWindowListener());
        setTitle("捕获其他窗体事件");
        setBounds(100,100,500,375);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        WindowListener_Example frame = new WindowListener_Example();
        frame.setVisible(true);
    }
}
