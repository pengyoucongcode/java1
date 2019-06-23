package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/23
//@time:19:52
//@project:IDEA_JAVA
//@file:JButtonTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class JButtonTest extends JFrame {
    private JButtonTest() {
        URL url = JButtonTest.class.getResource("按钮1.jpg");
        Icon icon = new ImageIcon(url);
        setLayout(new GridLayout(3, 2, 5, 5));  // 设置网格布局管理器
        Container c = getContentPane();
        JButton btn[] = new JButton[6]; // 创建按钮数组
        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton();
            c.add(btn[i]);
        }
        btn[0].setText("不可用");
        btn[0].setEnabled(false);
        btn[1].setText("有背景色");
        btn[1].setBackground(Color.YELLOW);
        btn[2].setText("无边框");
        btn[2].setBorderPainted(false);
        btn[3].setText("有边框");
        btn[3].setBorder(BorderFactory.createLineBorder(Color.RED));  // 添加红色边框
        btn[4].setIcon(icon);  // 设置按钮图标
        btn[4].setToolTipText("图片按钮");
        btn[5].setText("可点击");
        btn[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(JButtonTest.this, "点击按钮");
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("创建不同样式的按钮");
        setBounds(100,100,600,400);
    }

    public static void main(String[] args) {
        new JButtonTest();
    }
}
