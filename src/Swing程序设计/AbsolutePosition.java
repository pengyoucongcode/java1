package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/16
//@time:22:05
//@project:IDEA_JAVA
//@file:AbsolutePosition.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class AbsolutePosition extends JFrame {
    public AbsolutePosition(){
        setTitle("本窗体使用绝对布局");
        setLayout(null); //使该窗体取消布局管理器
        /*
         * 定位窗体的坐标位置和宽高
         * 窗体在屏幕中的 x 坐标为 0，y 坐标为 0，窗体高400像素，宽600像素
         */
        setBounds(0,0,600,400);
        Container c = getContentPane();
        JButton b1 = new JButton("按钮1");
        JButton b2 = new JButton("按钮2");

        /*
         * 设置按钮的位置和大小
         * 按钮1的横坐标为10，纵坐标为30，宽80像素，高30像素
         * 按钮2的横坐标为60，纵坐标为70，宽100像素，高20像素
         */
        b1.setBounds(10,30,80,30);
        b2.setBounds(60,70,100,20);
        b2.setVisible(true);
        b1.setVisible(true);
        c.add(b1);
        c.add(b2);
        c.setBackground(Color.WHITE);  //窗体背景设置为白色
        setVisible(true);

        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new AbsolutePosition();
    }

}
