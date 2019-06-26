package I输入输出流;

// !/usr/bin/env jdk1.8
// encoding:utf-8
//@software:IntelliJ IDEA
//@pack:I输入输出流
//@user:彭友聪
//@date:2019/6/26
//@time:10:49
//@project:IDEA_JAVA
//@file:ReaderAndWriter.java
//Author:御承扬
//email:2923616405@qq.com


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public class ReaderAndWriter {
    private ReaderAndWriter() {

    }

    public static void main(String[] args) {
        while (true) {
            try {
                File file = new File("D:\\users\\lenovo\\IDEA_JAVA\\src\\I输入输出流\\word.txt");
                if (!file.exists()) {
                    boolean result = file.createNewFile();
                    if (result) {
                        System.out.println("文件创建成功！");
                    } else {
                        System.out.println("文件未能创建，原因未知！");
                    }
                }
                System.out.println("请输入要执行的操作序号：（1,写入文件；2、读取文件;3、退出）");
                Scanner sc = new Scanner(System.in); // 控制台输入
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("请输入要写入文件的内容：");
                        String tmpStr = sc.next();
                        FileWriter fw = null; // 声明字符输出流
                        try {
                            fw = new FileWriter(file, true);
                            fw.write(tmpStr+"\r\n");
                        } catch (IOException e){
                            e.printStackTrace();
                        } finally {
                            Objects.requireNonNull(fw).close(); // 关闭字符输出流
                        }
                        System.out.println("上述内容已经写入到文件中！");
                        break;
                    case 2:
                        FileReader fr = null;
                        if(file.length() == 0){
                            System.out.println("文本中的字符数为0！！！");
                        } else {
                            try{
                                fr = new FileReader(file);
                                char[] buf = new char[1024];
                                int key =-1;
                                while (true){
                                    int i = fr.read(buf);
                                    if (i == key) break;
                                    System.out.println("文件“word.txt”中的内容：\n"+new String(buf,0,i));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            } finally {
                                Objects.requireNonNull(fr).close();
                            }
                        }
                        break;
                    case 3:
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("请输入符合要求的有效数字！！！");
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println("输入的文本格式不正确！请重新输入....");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
