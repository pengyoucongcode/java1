package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/22
//@time:11:02
//@project:IDEA_JAVA
//@file:DrawIcon.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;

public class DrawIcon implements Icon { //实现Icon 接口
    private int width;  // 宽
    private int height; // 高
    public DrawIcon(int width, int height){
        this.height=height;
        this.width=width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    public static void main(String[] args) {
        DrawIcon icon = new DrawIcon(15,15);
        //创建一个标签
        JLabel j = new JLabel("测试",icon,SwingConstants.CENTER);
        JFrame jf = new JFrame();
        Container c = jf.getContentPane();
        c.add(j);
        jf.setSize(300,150);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
