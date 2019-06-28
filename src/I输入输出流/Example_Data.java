package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/27
//@time:15:46
//@project:IDEA_JAVA
//@file:Example_Data.java
//Author:御承扬
//email:2923616405@qq.com


import java.io.*;

public class Example_Data {
    private Example_Data(){

    }

    public static void main(String[] args) {
        try{
            // 创建 FileOutputStream 对象，指定向其中写入数据的文件
            FileOutputStream fs = new FileOutputStream( "D:\\users\\lenovo\\IDEA_JAVA\\src\\I输入输出流\\word.txt" );
            // 创建 DataOutputStream 对象，用来向文件写入数据
            DataOutputStream ds = new DataOutputStream( fs );
            ds.writeUTF( "使用 writeUTF() 方法写入数据" );  // 将字符串写入文件
            ds.writeDouble( 19.8 );
            ds.writeInt( 298 );
            ds.writeBoolean( true );
            ds.close();  // 关闭写入流
            fs.close();
            // 创建输入流
            FileInputStream fis = new FileInputStream( "D:\\users\\lenovo\\IDEA_JAVA\\src\\I输入输出流\\word.txt" );
            DataInputStream dis = new DataInputStream( fis );
            System.out.println( "readUTF（）方法读取数据："+dis.readUTF() );
            System.out.println( "readDouble() 方法读取数据："+dis.readDouble() );
            System.out.println( "readInt() 方法读取数据："+dis.readInt() );
            System.out.println( "readBoolean() 方法读取数据："+dis.readBoolean() );
            dis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
