package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/23
//@time:21:54
//@project:IDEA_JAVA
//@file:CheckBoxTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckBoxTest extends JFrame {
    private CheckBoxTest() {
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        setBounds(100, 100, 133, 125);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        JCheckBox c1 = new JCheckBox("1");
        JCheckBox c2 = new JCheckBox("2");
        JCheckBox c3 = new JCheckBox("3");
        c.add(c1);
        c.add(c2);
        c.add(c3);
        JButton btn = new JButton("打印");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(c1.getText()+"按钮选中状态："+c1.isSelected());
                System.out.println(c2.getText()+"按钮选中状态："+c2.isSelected());
                System.out.println(c3.getText()+"按钮选中状态："+c3.isSelected());
            }
        });
        c.add(btn);
    }

    public static void main(String[] args) {
        new CheckBoxTest();
    }
}
