package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/9
//@time:11:36
//@project:IDEA_JAVA
//@file:RedBag.java
//Author:御承扬
//email:2923616405@qq.com

import java.util.Random;
import java.util.Scanner;


public class RedBag {
    public static void main(String[] args) {
        System.out.println("-------------模拟微信抢红包-----------------\n");
        Scanner sc = new Scanner(System.in); //控制台输入
        System.out.println("请输入要装入红包的总金额(元）：");
        double total = sc.nextDouble(); //输入红包总金额
        System.out.println("请输入红包个数（个）：");
        int bagsum = sc.nextInt(); //输入红包个数
        double min = 0.01; //初始化“红包的最小金额

        Random random = new Random();  //创建随机数对象
        for(int i=1;i<bagsum;i++)
        {
            /*
            通过本公式模拟数学中的离散模型计算一个红包可以放入的最大金额
            本次红包可用最大金额 = 可分配金额 - （红包总数-已发出的红包数）*红包的最小金额
             */
            double max = total -(bagsum-i)*min;

            double bound = max - min; //设置随机金额的取值范围
            /*
                *据随机金额的取值范围，随机生成红包金额
                * 由于 nextInt(int bound)只能用整形做参数，所以先将bound乘100
                * 获取到一个整数后，将这个整数除100并转换成与金额相同的浮点类型
             */
            double safe = (double)random.nextInt((int)(bound*100))/100;
            double money = safe + min;  //最后加上红包的最小金额，以防safe出现零值

            total -= money; //更新total值

            System.out.println("第"+i+"个红包："+String.format("%.2f",money)+"元");
        }
        System.out.println("第"+bagsum+"个红包:"+String.format("%.2f", total)+"元");
    }
}
