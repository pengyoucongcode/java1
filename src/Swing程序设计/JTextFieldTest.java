package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/22
//@time:20:22
//@project:IDEA_JAVA
//@file:JTextFieldTest.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldTest extends JFrame {
    private JTextFieldTest(){
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        // 设置文本框初始值
        JTextField jt = new JTextField("若道天涯无回路，漫漫黄沙掩枯骨");
        jt.setColumns(20); //  设置文本框长度
        // 设置字体
        jt.setFont(new Font("华文楷体", Font.PLAIN, 20));
        JButton jb = new JButton("清除");
        jt.addActionListener(new ActionListener() {  // 为文本框添加回车事件
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.setText("天生我材必有用，千金散尽还复来。");  // 设置文本框中的值
            }
        });
        jb.addActionListener(new ActionListener() {  // 为按钮添加事件
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jt.getText()); // 输出当前文本的值
                jt.setText("");  // 将文本置空
                jt.requestFocus();  // 焦点回到文本框
            }
        });
        // 创建密码框
        JPasswordField jp = new JPasswordField("请输入密码");
        jp.setFont(new Font("华文宋体",Font.PLAIN,20));
        jp.setEchoChar('·');
//        char ch[] = jp.getPassword();
//        String pwd = new String(ch);
        // 窗体容器添加文本框
        c.add(jt);
        // 窗体添加按钮
        c.add(jb);
        // 添加密码框
        c.add(jp);
        setBounds(100,100,450,250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JTextFieldTest();
    }
}
