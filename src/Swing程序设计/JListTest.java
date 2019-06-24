package Swing程序设计;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/24
//@time:15:32
//@project:IDEA_JAVA
//@file:JListTest.java
//Author:御承扬
//email:2923616405@qq.com


import javax.swing.*;
import java.awt.*;

public class JListTest extends JFrame {
    private JListTest() {
        Container cp = getContentPane();
        cp.setLayout(null);  // 容器使用绝对布局
        // 创建字符串数组，保存列表中的数据
       /* final String[] contents = {"列表1", "列表2", "列表3", "列表4", "列表5", "列表6"};
        final DefaultListModel iItems = new DefaultListModel();
        final JList jl = new JList(iItems);
        for (int i = 0; i < 6; i++) {
            iItems.addElement(contents[i]);
        }*/
        String[] contents = {"列表1", "列表2", "列表3", "列表4", "列表5", "列表6"};
        JList<String> jl = new JList<>(contents);
        JScrollPane js = new JScrollPane(jl);
        js.setBounds(10, 10, 100, 109);
        cp.add(js);
        // 创建文本域
        JTextArea area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(118, 10, 73, 80);
        cp.add(scrollPane);
        JButton btn = new JButton("确认");
        btn.setBounds(120, 96, 71, 23);
        cp.add(btn);
        btn.addActionListener(e -> {
            // 获取列表中选中的元素，返回 java.util.List 类型
            java.util.List<String> values = jl.getSelectedValuesList();
            area.setText("");  // 清空文本域
            for (String value : values) {
                area.append(value + "\n");  // 在文本域循环追加 List 中的元素
            }
        });
        setTitle("列表框");
        setSize(217, 167);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new JListTest();
    }
}
