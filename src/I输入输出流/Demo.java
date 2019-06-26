package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/26
//@time:16:16
//@project:IDEA_JAVA
//@file:Demo.java
//Author:御承扬
//email:2923616405@qq.com


import java.io.*;

public class Demo {
    private Demo() {

    }

    public static void main(String[] args) {
        // 定义字符串数组
        String[] content = {"你不喜欢我，", "我一点都不介意。", "因为我活下来，", "不是为了取悦任何一个人"};
        File file = new File( "D:\\users\\lenovo\\IDEA_JAVA\\src\\I输入输出流\\word.txt" );
        try {
            FileWriter fw = new FileWriter( file );
            // 创建 BufferedWriter 类对象
            BufferedWriter biff = new BufferedWriter( fw );
            for (String s : content) {
                biff.write( s );
                biff.newLine();
            }
            biff.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader( file );
            // 创建 BufferedReader 类对象
            BufferedReader buff = new BufferedReader( fr );
            int i = 0;
            // 如果文件的文本行数不是 null，则进入循环
            while (true) {
                String line = buff.readLine();
                if (line == null) break;
                i++;
                System.out.printf( "第%d行：%s%n", i, line );
            }
            buff.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
