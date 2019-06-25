package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/25
//@time:21:21
//@project:IDEA_JAVA
//@file:FileTest.java
//Author:御承扬
//email:2923616405@qq.com


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
    public FileTest() {
    }

    public static void main(String[] args) {
        File file = new File("D:/users/lenovo/IDEA_JAVA/src/I输入输出流/test.txt");
        if(!file.exists()){
            System.out.println("未在制定目录下找到文件名为”test“的文本文件！正在创建。。。");
            try{
                boolean result = file.createNewFile(); // 创建文件
                if(result){
                    System.out.println("文件创建成功！");
                } else {
                    System.out.println("文件未能创建，原因未知！");
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        } else {
            System.out.println("找到文件名为”test“的文本文件！");
            if(file.isFile() && file.canRead()){
                System.out.println("文件可读！正在读取文件信息....");
                String filename = file.getName(); // 获取文件名
                String filePath = file.getPath(); // 获取文件路径
                boolean hidden = file.isHidden(); // 获得该文件是否被隐藏
                long len = file.length(); // 获取该文件中的字节数
                long tempTime = file.lastModified(); // 获取文件的最后修改时间
                // 创建 SimpleDataFormat 对象，指定目标格式
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date(tempTime); // 使用”文件最后修改时间“创建 Date 对象

                String time = sdf.format(date); // 格式化”文件最后修改时间“
                System.out.println("文件名："+filename); // 输出文件名
                System.out.println("文件的绝对路径："+filePath);
                System.out.println("文件是否被隐藏："+hidden);
                System.out.println("文件中的字节数："+len);
                System.out.println("文件最后的修改时间："+time);

                boolean del = file.delete();
                if(del){
                    System.out.println("文件"+filename+"已经被删除！");
                } else {
                    System.out.println("文件"+filename+"未能被删除，原因未知");
                }
            } else {
                System.out.println("文件不可读！！！");
            }
        }
    }
}
