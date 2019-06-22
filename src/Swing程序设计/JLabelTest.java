package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/21
//@time:16:58
//@project:IDEA_JAVA
//@file:JLabelTest.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;

public class JLabelTest extends JFrame {
    private JLabelTest() {
        Container c = getContentPane();
        JPanel p1 = new JPanel(new BorderLayout());
        JLabel labelContacts = new JLabel("联系人");  //创建标签并设置内容
        labelContacts.setForeground(new Color(0, 102, 153)); //标签字体颜色
        labelContacts.setFont(new Font("华文楷体", Font.BOLD, 30)); //标签字体、样式和大小
        labelContacts.setBounds(0, 0, 194, 28);  //标签位置及大小
        p1.add(labelContacts);
        c.add(p1);
        setTitle("标签测试");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {

        new JLabelTest();
    }
}
