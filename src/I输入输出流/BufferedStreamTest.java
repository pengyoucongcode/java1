package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/26
//@time:15:26
//@project:IDEA_JAVA
//@file:BufferedStreamTest.java
//Author:御承扬
//email:2923616405@qq.com


import java.io.*;
import java.util.Objects;

public class BufferedStreamTest {
    private BufferedStreamTest() {

    }

    public static void main(String[] args) {
        // 定义字符串数组
        String[] content = {"你不喜欢我，", "我一点都不介意。", "因为我活下来，", "不是为了取悦任何一个人"};
        File file = new File("D:\\users\\lenovo\\IDEA_JAVA\\src\\I输入输出流\\word.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            byte[] bContent;
            int len = content.length;
            int k;
            for (k = 0; k < len; k++) {
                bContent = content[k].getBytes(); // 将遍历到的数组内容转换为字节数组
                bos.write(bContent);
            }
            System.out.println("写入成功！\n");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                Objects.requireNonNull(bos).close(); // 将 BufferedOutputStream 流关闭
                fos.close(); // 将 FileOutputStream 流关闭
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try{
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bContent = new byte[1024];
            int len = bis.read(bContent);
            System.out.println("文件中的内容："+new String(bContent,0,len));  // 输出文件内容
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                Objects.requireNonNull( bis).close();
                fis.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
