package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/21
//@time:16:19
//@project:IDEA_JAVA
//@file:JScrollPaneTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class JScrollPaneTest extends JFrame {
    public JScrollPaneTest(){
        Container c = getContentPane();
        //创建文本区域组件，文本默认大小为20行、50列
        JTextArea ta = new JTextArea(20,50);
        //创建 JScroolPane 面板，并将文本域放置到面板中
        JScrollPane sp = new JScrollPane(ta);
        c.add(sp);
        setTitle("带滚动条的文字编辑器");
        setSize(600,400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JScrollPaneTest();
    }
}
