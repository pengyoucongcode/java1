package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/23
//@time:20:53
//@project:IDEA_JAVA
//@file:RadioButtonTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonTest extends JFrame {
    private RadioButtonTest(){
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        Container c = getContentPane();
        JRadioButton rbtnNormal = new JRadioButton("普通发送");
        rbtnNormal.setFont(new Font("楷体",Font.PLAIN,14));
        rbtnNormal.setBounds(20,30,75,22);
        rbtnNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbtnNormal.isSelected())
                    JOptionPane.showMessageDialog(null,"您选择的是："+rbtnNormal.getText(),
                            "提醒",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JRadioButton rbtnPwd = new JRadioButton("加密发送");
        rbtnPwd.setFont(new Font("宋体",Font.PLAIN,14));
        rbtnPwd.setBounds(100,30,75,22);
        rbtnPwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbtnPwd.isSelected())
                    JOptionPane.showMessageDialog(null,"您选择的是："+rbtnPwd.getText(),
                            "提醒",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnNormal);
        group.add(rbtnPwd);
        c.add(rbtnNormal);
        c.add(rbtnPwd);
        setBounds(558,300,500,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new RadioButtonTest();
    }
}
