package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/16
//@time:20:15
//@project:IDEA_JAVA
//@file:MyFrame.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyJDialog extends JDialog {
    public MyJDialog(MyFrame frame) {
        //实例化一个 Jdialog 类对象，指定对话框的父窗体、窗体标题和类型
        super(frame, "第一个JDialog窗体", true);
        Container ct = getContentPane(); //创建容器
        ct.add(new JLabel("这是一个对话框"));  //添加标签
        setBounds(120, 120, 300, 300);  //设置对话框窗体在桌面显示的坐标和大小
    }
}

public class MyFrame extends JFrame {
    public MyFrame(){
        Container ct = getContentPane();  //获得窗体容器
        ct.setLayout(null);  //容器使用null布局
        JButton b1 = new JButton("弹出对话框");  //定义一个按钮
        b1.setBounds(10,10,100,21);  //定义按钮在容器中的坐标和大小
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建对话框
                MyJDialog Dlg = new MyJDialog(MyFrame.this);
                Dlg.setVisible(true);  //使MyDialog窗体可见
            }
        });
        ct.add(b1);  //将按钮添加到容器中
        ct.setBackground(Color.WHITE);  //窗体背景设置为白色
        setSize(800,600);  //窗口大小
        //窗口关闭结束程序
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);  //使窗口可见
    }

    public static void main(String[] args) {
        new MyFrame();  //实例化 MyFrame 类对象
    }
}
