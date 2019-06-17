package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/17
//@time:22:19
//@project:IDEA_JAVA
//@file:BorderLayoutPosition.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class BorderLayoutPosition extends JFrame {
    public BorderLayoutPosition() {
        setTitle("使用边界布局管理器");
        Container c = getContentPane();
        setLayout(new BorderLayout());  //设置边界布局管理器
        JButton centerBtn = new JButton("中"),
                northBtn = new JButton("北"),
                southBtn = new JButton("南"),
                westBtn = new JButton("西"),
                eastBtn = new JButton("东");

        //添加按钮到东南西北中五个区域
        c.add(centerBtn, BorderLayout.CENTER);
        c.add(northBtn, BorderLayout.NORTH);
        c.add(southBtn, BorderLayout.SOUTH);
        c.add(westBtn, BorderLayout.WEST);
        c.add(eastBtn, BorderLayout.EAST);

        setSize(600,400);
        setVisible(true);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutPosition();
    }
}
