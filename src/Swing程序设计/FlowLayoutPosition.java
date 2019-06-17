package Swing程序设计;

// !/usr/bin/env jdk12.0
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Swing程序设计
//@user:彭友聪
//@date:2019/6/17
//@time:12:21
//@project:IDEA_JAVA
//@file:FlowLayoutPosition.java
//Author:御承扬
//email:2923616405@qq.com




import javax.swing.*;
import java.awt.*;

public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition(){
        setTitle("本窗体使用流布局管理器");  //设置窗体标题
        Container c = getContentPane();
        // 设置窗体使用流布局管理器，使组件右对齐，组件之间水平间隔为10像素，垂直间隔为10像素
        setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
        for(int i=0;i<10;i++){
            c.add(new Button("button"+i));
        }  //添加十个按钮
        setSize(600,400);
        setVisible(true);

        //设置窗体关闭方式
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new FlowLayoutPosition();
    }

}
