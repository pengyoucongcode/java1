package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/16
//@time:17:21
//@project:IDEA_JAVA
//@file:JFrameTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.awt.*;
import javax.swing.*;

public class JFrameTest extends JFrame{
    public void CreateJFrame(String title){
        JFrame jf = new JFrame(title);  //创建 JFrame 对象
        Container ct = jf.getContentPane();  //获取一个容器
        JLabel jl = new JLabel("这是一个 JFrame 窗体");  // 创建一个 JLabel 标签
        //使标签文字居中
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        ct.add(jl);  //将标签添加到容器中
        ct.setBackground(Color.white);   //设置容器的背景颜色
        jf.setVisible(true);  //使窗体可见
        jf.setSize(800,600);
        //设置窗体关闭方式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JFrameTest().CreateJFrame("创建一个 JFrame 窗体");
    }
}
