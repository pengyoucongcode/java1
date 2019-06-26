package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/26
//@time:9:59
//@project:IDEA_JAVA
//@file:FileStreamTest.java
//Author:御承扬
//email:2923616405@qq.com


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest {
    private FileStreamTest(){

    }

    public static void main(String[] args) {
        File file = new File("D:\\users\\lenovo\\IDEA_JAVA\\src\\I输入输出流\\word.txt"); // 创建文件对象
        try{
            // 创建 FileOutputStream 对象，用来向文件中写入数据
            //noinspection resource,IOResourceOpenedButNotSafelyClosed
            FileOutputStream out = new FileOutputStream(file);
            String content = "昨夜西风凋碧树，独上高楼，望尽天涯路。欲寄彩笺兼尺素，山长水阔知何处。";
            // 创建 byte 型数组，将要写入文件的内容转为字节数组
            byte[] buy = content.getBytes();
            out.write(buy);  // 向文件中写入数据
            out.close();  // 关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            // 创建 FileInputStream 对象，用来读取文件内容
            //noinspection IOResourceOpenedButNotSafelyClosed,resource
            FileInputStream in = new FileInputStream(file);
            byte[] byt = new byte[1024]; // 创建 byte 数组，用来存储读取的文件内容
            int len = in.read(byt); // 从文件中读取信息，并存入字节数组中
            System.out.println("文件中的内容是："+new String(byt,0,len));
            in.close(); // 关闭流
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
