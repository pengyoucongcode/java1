package 反射;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:反射
//@user:彭友聪
//@date:2019/6/28
//@time:19:17
//@project:IDEA_JAVA
//@file:GetConstructorTest.java
//Author:御承扬
//email:2923616405@qq.com


import org.jetbrains.annotations.Contract;

public class GetConstructorTest {
    String s; // 定义一个字符串变量
    int i, i2, i3; // 定义 3 个 int 变量

    /**
     * 默认构造方法
     */
    @Contract(pure = true)
    private GetConstructorTest() {  // 无参构造函数

    }

    protected GetConstructorTest(String s, int i) { // 有参构造函数，用来为字符串变量和 int 变量初始化值
        this.s = s;
        this.i = i;
    }

    public GetConstructorTest(String... strings) throws NumberFormatException {
        if (strings.length > 0)
            i = Integer.valueOf( strings[0] );
        if (strings.length > 1)
            i2 = Integer.valueOf( strings[1] );
        if (strings.length > 2)
            i3 = Integer.valueOf( strings[2] );
    }

    public void print() {
        System.out.println( "s="+s );
        System.out.println( "i="+i );
        System.out.println( "i2="+i2 );
        System.out.println( "i3="+i3 );
    }
}
