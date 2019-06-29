package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/29
//@time:16:19
//@project:IDEA_JAVA
//@file:TabooMarket.java
//Author:御承扬
//email:2923616405@qq.com

abstract class Market {
    String name; // 客户名称
    String goods; // 商品名称

    Market() {
    }

    public abstract void shop(); // 抽象方法，用来输出信息
}

@SuppressWarnings("AssignmentToSuperclassField")

public class TabooMarket extends Market {
    private TabooMarket () {

    }

    private TabooMarket(String s1, String s2) {
        this.name = s1;
        this.goods = s2;
    }

    @Override
    public void shop() {
        System.out.print( name + "网购" + goods );
    }

    public static void main(String[] args) {
        TabooMarket test = new TabooMarket( "御承扬","海力士 DDR4 8G 内存条" );
       test.shop();
    }
}
