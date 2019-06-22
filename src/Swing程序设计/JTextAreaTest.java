package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/22
//@time:22:14
//@project:IDEA_JAVA
//@file:JTextAreaTest.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;

public class JTextAreaTest extends JFrame {
    private JTextAreaTest(){
        setSize(200,100);
        setTitle("定义自动换行文本");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Container c = getContentPane();
        // 创建6行6列默认值为“若道天涯无回路，漫漫黄沙掩枯骨”的文本域组件
        JTextArea jt = new JTextArea("若道天涯无回路，漫漫黄沙掩枯骨",6,6);
        jt.setLineWrap(true);  // 可以自动换行
        c.add(jt);
        setVisible(true);
    }
    public static void main(String[] args) {
        new JTextAreaTest();
    }
}
