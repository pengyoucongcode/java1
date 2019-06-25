package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/25
//@time:22:24
//@project:IDEA_JAVA
//@file:FolderTest.java
//Author:御承扬
//email:2923616405@qq.com

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public class FolderTest {
    private FolderTest() {

    }

    public static void main(String[] args) {
        String path = "D:\\users\\lenovo\\IDEA_JAVA\\src\\测试代码专用";
        AtomicBoolean result = new AtomicBoolean(false);
        for (int i = 1; i <= 10; i++) {  // 循环 i 值，并以 i 命名新的文件夹
            File folder = new File(path + "\\" + i);
            if(folder.exists()){
                result.set(folder.delete()); // 删除文件夹
            }
            /*if(!folder.exists()){
               result.set(folder.mkdirs()); // 创建新文件夹
            }*/
        }
        if(result.get()){
            System.out.println("文件夹删除成功，请打开D:\\users\\lenovo\\IDEA_JAVA\\src\\测试代码专用查看");
        }
        File file = new File("D:\\users\\lenovo\\IDEA_JAVA\\src\\Swing程序设计\\");
        File[] files = file.listFiles(); /*获得 指定目录下的文件夹和文件*/
        if (files != null) {
            for (File f : files){
                if (f.isFile()){
                    System.out.println(f.getName()+"文件");
                }
                else if( f.isDirectory()){
                    System.out.println(f.getName()+"文件夹");
                }
            }
        }
    }
}
