package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/15
//@time:11:17
//@project:IDEA_JAVA
//@file:EnumConTest.java
//Author:御承扬
//email:2923616405@qq.com


public class EnumConTest {
    enum Constants {
        Constants_A("我是枚举成员A"),
        Constants_B("我是枚举成员B"),
        Constants_C("我是枚举成员C"),
        Constants_D(3);
        private String description;
        private int i = 4;

        //定义String类型构造方法
        private Constants(String description) {
            this.description = description;
        }

        //定义int型构造方法
        private Constants(int i) {
            this.i = this.i + i;
        }

        //获取description
        public String getDescription() {
            return description;
        }

        //获取i值
        public int getI(){
            return i;
        }
    }

    public static void main(String[] args) {
        Constants array[] = Constants.values();  //获取枚举成员数组
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]+"调用getDescription()方法为:"+array[i].getDescription());
        }

        Constants c2 = Constants.valueOf("Constants_D");
        System.out.println(c2+"调用getI()方法为:"+c2.getI());
    }
}
