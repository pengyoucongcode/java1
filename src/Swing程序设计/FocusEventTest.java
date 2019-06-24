package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/24
//@time:17:21
//@project:IDEA_JAVA
//@file:FocusEventTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusEventTest extends JFrame {
    private FocusEventTest(){
        setLayout(null);
        setBounds(100, 20, 500, 150);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container cp = getContentPane();
        JTextField jt1 = new JTextField("请单击其他文本框",10);
        JTextField jt2 = new JTextField("请单击我！",10);
        jt1.setBounds(10,10,200,30);
        jt2.setBounds(10,50,200,30);
        jt1.setVisible(true);
        jt2.setVisible(true);
        cp.add(jt1);
        cp.add(jt2);
        jt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                jt2.setText("另外一个文本框获得了焦点");
            }

            @Override
            public void focusLost(FocusEvent e) {
                jt2.setText("另外一个文本框失去了焦点");
                JOptionPane.showMessageDialog(null,"文本框失去焦点");
            }
        });
    }

    public static void main(String[] args) {
        new FocusEventTest();
    }
}
