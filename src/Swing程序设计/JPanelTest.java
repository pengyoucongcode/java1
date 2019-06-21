package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/18
//@time:14:29
//@project:IDEA_JAVA
//@file:JPanelTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class JPanelTest extends JFrame {
    public JPanelTest() {
        Container c = getContentPane();
        // 将整个容器设置为两行一列的网格布局，组件水平间隔为10像素，垂直间隔为10像素
        c.setLayout(new GridLayout(2, 1, 10, 10));
        // 初始化一个面板，此面板使用一行三列的网格布局，组件水平间隔为10像素，垂直间隔为10像素
        JPanel p1 = new JPanel(new GridLayout(1,3,10,10));
        JPanel p2 = new JPanel(new BorderLayout());  // 使用边界布局
        JPanel p3 = new JPanel(new GridLayout(1,2,10,10));
        JPanel p4 = new JPanel(new GridLayout(2,1,10,10));

        // 给每个面板都添加框和标题，使用 BorderFactory 工厂类生成带标题的边框对象
        p1.setBorder(BorderFactory.createTitledBorder("面板1"));
        p2.setBorder(BorderFactory.createTitledBorder("面板2"));
        p3.setBorder(BorderFactory.createTitledBorder("面板3"));
        p4.setBorder(BorderFactory.createTitledBorder("面板4"));

        // 面板中添加按钮
        p1.add(new Button("b1"));
        p1.add(new Button("b2"));
        p1.add(new Button("b3"));
        p1.add(new Button("b4"));

        p2.add(new JButton("b5"), BorderLayout.WEST);
        p2.add(new JButton("b6"), BorderLayout.EAST);
        p2.add(new JButton("b7"), BorderLayout.NORTH);
        p2.add(new JButton("b8"), BorderLayout.SOUTH);
        p2.add(new JButton("b9"));

        p3.add(new JButton("a1"));
        p3.add(new JButton("a2"));

        p4.add(new JButton("a3"));
        p4.add(new JButton("a4"));

        c.add(p1);
        c.add(p2);
        c.add(p3);
        c.add(p4);

        setSize(500,300);
        setVisible(true);
        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {

        new JPanelTest();
    }
}
