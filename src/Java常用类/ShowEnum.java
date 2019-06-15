package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/15
//@time:10:31
//@project:IDEA_JAVA
//@file:ShowEnum.java
//Author:御承扬
//email:2923616405@qq.com


public class ShowEnum {
    enum Constants {
        Constants_A, Constants_B, Constants_C, Constants_D
    }

    public static void main(String[] args) {
        for(int i=0;i<Constants.values().length;i++){
            System.out.println(Constants.values()[i]+"在枚举类型中的位置索引值"+Constants.values()[i].ordinal());
        }
    }

//    public static void compare(Constants c) {
//        Constants arrays[] = Constants.values();
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.println(c + "与" + arrays[i] + "的比较结果为：" + c.compareTo(arrays[i]));
//        }
//    }

//    public static void main(String[] args) {
//        compare(Constants.valueOf("Constants_B"));
//    }
//    public static void main(String[] args){
//        Constants enumArray[] = Constants.values();  //values() 方法返回枚举数组
//        for(int i=0;i<enumArray.length;i++){
//            //将枚举成员打印
//            System.out.println("枚举类型成员变量："+enumArray[i]);
//        }
//    }
}
