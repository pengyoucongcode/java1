package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/8
//@time:21:45
//@project:IDEA_JAVA
//@file:NumGame.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.Scanner;

public class NumGame {
    public static void main(String[] args) {
        System.out.println("------------猜数字游戏------------\n");
        int iNum;
        int iGuess;
        Scanner in = new Scanner(System.in);  //创建扫描对象，用于输入
        iNum = (int)(Math.random()*100);
        System.out.println("请输入你猜的数字：");
        iGuess = in.nextInt(); //输入首次猜测的数字
        while((iGuess != -1) &&(iGuess != iNum) ) //判断输入的数字不是-1或者基准数
        {
            if(iGuess < iNum)
            {
                System.out.println("太小，请重新输入：");
                iGuess = in.nextInt();
            }
            else
            {
                System.out.println("太大，请重新输入：");
                iGuess = in.nextInt();
            }
        }
        if(iGuess == -1)
        {
            System.out.println("退出游戏！");
        }
        else
        {
            System.out.println("恭喜你，你赢了，猜中的数字是："+iNum);
        }
        System.out.println("\n------------游戏结束-----------------");
    }
}
