package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/24
//@time:10:19
//@project:IDEA_JAVA
//@file:JComboBoxTest.java
//Author:御承扬
//email:2923616405@qq.com

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JComboBoxTest extends JFrame {
    private JComboBoxTest(){
        Container c = getContentPane();
        setLayout(new FlowLayout());
        setSize(330,132);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JComboBox<String> comboBox = new JComboBox<>();  // 创建数据类型为字符串的下拉列表框
        comboBox.setBounds(110,11,80,21);
        comboBox.addItem("身份证");
        comboBox.addItem("军人证");
        comboBox.addItem("学生证");
        comboBox.addItem("工作证");
        c.add(comboBox);
         JLabel result = new JLabel("结果");
         result.setBounds(77,57,146,15);
         JButton bt = new JButton("确定");
         bt.setBounds(200,10,67,23);
         bt.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 // 获取下啦列表框中的选项
                 result.setText("您选择的是："+comboBox.getSelectedItem());
             }
         });
         c.add(bt);
         c.add(result);
    }

    public static void main(String[] args) {
        new JComboBoxTest();
    }

}
