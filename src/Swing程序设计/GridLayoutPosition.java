package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/18
//@time:10:06
//@project:IDEA_JAVA
//@file:GridLayoutPosition.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class GridLayoutPosition extends JFrame {
    public GridLayoutPosition() {
        Container c = getContentPane();
        /*
         * 设置容器使用网格布局管理器，设置7行3列的网格
         * 组件间水平间距为5像素，垂直间距为5像素
         */
        setLayout(new GridLayout(7, 3, 5, 5));
        for (int i = 0; i < 20; i++) {
            c.add(new JButton("按钮" + i));
        }
        setSize(300,300);
        setTitle("网格布局");
        setVisible(true);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GridLayoutPosition();
    }
}
