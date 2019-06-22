package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/22
//@time:11:46
//@project:IDEA_JAVA
//@file:MyImageIcon.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class MyImageIcon extends JFrame {
    private MyImageIcon(){
        Container c = getContentPane();
        JLabel jl = new JLabel("这是一个JFrame窗体",JLabel.CENTER);
        //获取图片所在的 URL
        URL url = MyImageIcon.class.getResource("雅男1.jpg");
        Icon icon = new ImageIcon(url);
        jl.setIcon(icon);
        //设置文字放置在标签中间
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setOpaque(true);  //设置标签不透明状态
        c.add(jl);
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyImageIcon();
    }
}
