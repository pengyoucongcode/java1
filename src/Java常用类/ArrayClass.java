package Java常用类;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:Java常用类
//@user:彭友聪
//@date:2019/6/15
//@time:21:35
//@project:IDEA_JAVA
//@file:ArrayClass.java
//Author:御承扬
//email:2923616405@qq.com


public class ArrayClass<T> {
    private T[] array;  //定义泛型类数组

    public T[] getArray() {   //获取成员数组
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public static void main(String[] args) {
        ArrayClass<String> a = new ArrayClass<String>();
        String[] array = {"Hello", "World", "I", "am", "trying"};
        a.setArray(array);
        for(int i=0;i<a.getArray().length;i++){
            System.out.print(a.getArray()[i]+" ");
        }
        System.out.println();
    }
}
