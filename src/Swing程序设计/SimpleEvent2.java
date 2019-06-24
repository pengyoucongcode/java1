package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/24
//@time:16:39
//@project:IDEA_JAVA
//@file:SimpleEvent2.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleEvent2 extends JFrame implements ActionListener {
    private JButton btn = new JButton("我是按钮，单击我");

    private SimpleEvent2() {
        setLayout(null);
        setBounds(100, 20, 200, 150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        cp.add(btn);
        btn.setBounds(10, 10, 150, 30);
        btn.addActionListener(this);
    }

    // 重写 actionPerformed() 方法
    public void actionPerformed(ActionEvent arg0) {
        btn.setText("我被单击了！");
    }

    public static void main(String[] args) {
        new SimpleEvent2();
    }
}
