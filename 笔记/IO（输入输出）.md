# I/O（输入/输出）

---

## 一、流概述

* 程序开发中，将不同输入/输出设备之间的数据传输抽象为流。
* 根据流中传输的数据类型，可以将流分为字节流（以 **Stream** 结尾的流）和字符流（以 **Reader 和 Writer** 结尾的流）
* 根据流的操作方式分为输入流和输出流
* 输入流，是指打开一个从某数据源到程序的流，并从这个流中读取数据；输出流是为了将程序中的数据传输到某个目的地，并在传输过程中将数据写入流中。

## 二、输入/输出流

* Java 中负责输入和输出的类都放在 java.io 这个包中；其中，所有的输入流类都是 **InputStream 或 Reader** 这两个抽象类的子类；而所有的输出流都是 **OutputStream 或 Writer **这两个抽象类的子类。

### 1、输入流

* 输入流分为字节输入流和字符输入流。

#### 1.1、InputStream 类

* InputStream 类是所有字节输入流的父类，其具体的层次结构如下图：

  ![](D:\编程笔记\java\InputStream.jpg)

* InputStream 类的常用方法如下表：

  | 方法                | 返回值  | 说明                                                         |
  | ------------------- | ------- | ------------------------------------------------------------ |
  | read()              | int     | 从输入流中读取数据的下一个字节。返回0~255范围内的 int 字节值。如果因为已经到达流末尾而没有可用的字节，则返回-1 |
  | read(byte[] b)      | int     | 从输入流中读入一定长度的字节，并以整数的形式返回字节数       |
  | mark(int readlimit) | void    | 在输入流的当前位置放置一个标记，readlimit 参数告知此输入流在标记位置失效之前允许读取的字节数 |
  | reset()             | void    | 将输入指针返回到当前所做的标记处                             |
  | skip(long n)        | long    | 跳过输入流上的 n 个字节并返回实际跳过的字节数                |
  | markSupported()     | boolean | 如果当前流支持 mark()/reset() 操作就返回 True                |
  | close()             | void    | 关闭此输入流并释放与该流关联的所有系统资源。                 |


#### 1.2、reader 类

* Reader 类是 Java 为字符文本专门设计的一个类，是所有字符输入流的父类，其具体的层次结构见下图

  ![](D:\编程笔记\java\Reader.jpg)

* Reader 类中的方法与 InputStream 类中的相似，不同的体现在下面两个点：

  1）Reader 类中的 read() 方法的参数为 char 类型的数组。

  2）Reader 类提供了一个 ready() 方法，用于判断是否准备读取流，返回值是 boolean 类型

### 2、输出流

* 输出流同样分为字节输出流和字符输出流。

#### 2.1、OutputStream 类

* OutputStream 是所有字节输出流类的父类，其具体层次结构见下图：

  ![](D:\编程笔记\java\OutputStream.jpg)

* OutputStream 类的常用方法见下表：

  | 方法                              | 说明                                                         |
  | --------------------------------- | ------------------------------------------------------------ |
  | write(int b)                      | 将指定的字节写入此输出流                                     |
  | write(byte[] b)                   | 将 b 个字节从指定的 byte 数组写入此输出流                    |
  | write(byte[] b, int off, int len) | 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流 |
  | flush()                           | 彻底完成输出并清空缓冲区                                     |
  | close()                           | 关闭输出流                                                   |

#### 2.2、Writer 类

* Writer 类是所有字符输出流的父类，其具体层次结构如下图：

  ![](D:\编程笔记\java\Writer.jpg)

* Writer 类的常用方法如下表：

  | 方法                                         | 说明                                       |
  | -------------------------------------------- | ------------------------------------------ |
  | append(char c)                               | 将指定字符添加到此字符输出流               |
  | append(CharSequence csq)                     | 将指定字符序列添加到此字符输出流           |
  | append(CharSequence csq, int start, int end) | 将指定字符序列的子序列添加到到此字符输出流 |
  | close()                                      | 关闭此流，但要先刷新它                     |
  | flush()                                      | 刷新该流的缓冲                             |
  | write(char[] buf)                            | 写入字符数组                               |
  | write(char[] buf, int off, int len)          | 写入字符数组的某一个部分                   |
  | write(int c)                                 | 写入单个字符                               |
  | write(String str)                            | 写入字符串                                 |
  | write(String str, int off, int len)          | 写入字符串的某一部分                       |

## 三、File 类

* File 类是 java.io 包中唯一代表磁盘文件的对象。File 类定义了一些与平台无关的方法来操作文件，通过调用 File 类中的方法，实现创建、删除、重命名文件等操作。
* File 类的对象主要主要用来获取文件本身的一些信息，如文件所在的目录、文件的长度、文件的读写权限等。

### 1、创建 File 对象

* 创建 File 对象，有以下几种方法：

#### 1.1、File(String pathname)

* 该构造方法，通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。例子：

  ```java
  File file = new File("D:/1.txt");
  ```

#### 1.2、File(String parent, String child)

* 该构造方法根据定义的父路径和子路径字符串创建一个新的 File 实例。
* parent：父路径字符串，如：D:/ 或 D:/doc/
* child：子路径字符串，如：letter.txt

### 2、文件操作

* 常见的文件操作主要有判断文件是否存在、创建文件、重命名文件、删除文件以及获取文件信息（文件名称、大小、修改时间、是否隐藏等）

* File 中常见的文件操作方法如下表：

  | 方法                                                         | 返回值  | 说明                                                         |
  | ------------------------------------------------------------ | ------- | ------------------------------------------------------------ |
  | canRead()                                                    | boolean | 判断文件是否可读                                             |
  | canWrite()                                                   | boolean | 判断文件是否可写                                             |
  | createNewFile()                                              | boolean | 当且仅当不存在具体指定名称的文件时，创建一个新的空文件       |
  | createTempFile(String prefix, String suffix)                 | File    | 在默认临时文件夹中创建一个新的空文件，使用给定前缀和后缀字符串生成其名称 |
  | createTempFile(String prefix, String suffix, File directory) | File    | 在制定文件夹中新建一个新的空文件，使用给定的前缀和后缀字符串生成其名称 |
  | delete()                                                     | boolean | 删除指定的文件或文件夹                                       |
  | exists()                                                     | boolean | 测试指定文件或文件夹是否存在                                 |
  | getAbsoluteFile()                                            | File    | 返回抽象路径名的绝对路径名形式                               |
  | getAbsolutePath()                                            | String  | 获取文件的绝对路径                                           |
  | getName()                                                    | String  | 获取文件或文件夹的名称                                       |
  | getParent()                                                  | String  | 获取文件的父路径                                             |
  | getPath()                                                    | String  | 获取路径名字符串‘                                            |
  | getFreeSpace()                                               | long    | 返回此抽象路径名指定的分区中未分配的字节数                   |
  | getTotalSpace()                                              | long    | 返回此抽象路径名指定的分区的大小                             |
  | length()                                                     | long    | 获取文件长度（以字节为单位）                                 |
  | isFile()                                                     | boolean | 判断是不是文件                                               |
  | isHidden()                                                   | boolean | 判断是否是隐藏文件                                           |
  | lastModified()                                               | long    | 获取文件的最后修改时间                                       |
  | renameTo(File dest)                                          | boolean | 重命名文件                                                   |
  | setLastModified(long time)                                   | boolean | 设置文件或文件夹的最后一次修改时间                           |
  | setReadOnly()                                                | boolean | 将文件或文件夹设置为只读                                     |
  | toURI()                                                      | URI     | 构造一个表示此抽象路径名的 file：URI                         |

* 实例：

  ```java
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
  // 第一次运行的结果：
  /*
  未在制定目录下找到文件名为”test“的文本文件！正在创建。。。
  文件创建成功！
  */
  // 第二次运行的结果：
  /*
  找到文件名为”test“的文本文件！
  文件可读！正在读取文件信息....
  文件名：test.txt
  文件的绝对路径：D:\users\lenovo\IDEA_JAVA\src\I输入输出流\test.txt
  文件是否被隐藏：false
  文件中的字节数：0
  文件最后的修改时间：2019/06/25 21:57:48
  文件test.txt已经被删除！
  */
  ```

### 3、文件夹操作

* 同操作文件一样，对文件夹的操作也有判断是否存在、创建文件夹、删除文件夹、获取文件夹中包含的子文件夹及文件等

* 常见的文件夹操作方法如下表：

  | 方法                             | 返回值   | 说明                                                         |
  | -------------------------------- | -------- | ------------------------------------------------------------ |
  | isDirectory()                    | boolean  | 判断是不是文件夹                                             |
  | list()                           | String[] | 返回字符串数组，这些字符串指定此抽象路径名表示的目录中的文件和目录 |
  | list(FilenameFilter filter)      | String[] | 返回字符串数组，这些字符串指定此抽象路径名表示的目录中满足指定过滤器的文件和目录 |
  | listFiles()                      | File[]   | 返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中的文件 |
  | listFiles(FileFilter filter)     | File[]   | 返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录 |
  | listFiles(FilenameFilter filter) | File[]   | 返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录 |
  | mkdir()                          | boolean  | 创建此抽象路径名指定的目录                                   |
  | mkdirs()                         | boolean  | 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录     |

* 实例：

  ```java
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
              if(!folder.exists()){
                 result.set(folder.mkdirs()); // 创建新文件夹
              }
          }
          if(result.get()){
              System.out.println("文件夹创建成功，请打开D:\\users\\lenovo\\IDEA_JAVA\\src\\测试代码专用查看");
          }
          File file = new File("D:\\users\\lenovo\\IDEA_JAVA\\src\\");
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
  /*
  文件夹创建成功，请打开D:\users\lenovo\IDEA_JAVA\src\测试代码专用查看
  I输入输出流文件夹
  Java常用类文件夹
  Swing程序设计文件夹
  测试代码专用文件夹
  高级事件处理文件夹
  */
  ```

* 文件资源浏览器中的相应目录下的情况：

  ![](D:\编程笔记\java\文件夹操作.jpg)

* 对上述代码进行适当修改，删除文件夹：

  ```java
  for (int i = 1; i <= 10; i++) {  // 循环 i 值，并以 i 命名新的文件夹
              File folder = new File(path + "\\" + i);
              if(folder.exists()){
                  result.set(folder.delete()); // 删除文件夹
              }
              /*if(!folder.exists()){
                 result.set(folder.mkdirs()); // 创建新文件夹
              }*/
          }
  ```

* 运行后：

  ![](D:\编程笔记\java\删除文件夹.jpg)

## 四、文件输入/输出流

* 用于将数据永久保存到磁盘文件中，或者从磁盘文件中读取数据。

### 1、FileInputStream 和 FileOutputStream

* 这两个类都是用来操作磁盘文件的，分别是 InputStream 和 OutputStream 的子类，因此其常用方法与其父类相类似。

* FileInputStream 类的构造方法如下：

  1）FileInputStream(String name)：使用给定的文件名 name 创建一个 FileInputStream 对象。

  2）FileInputStream(File file)：使用 File 对象创建 FileInputStream 对象，该方法允许在把文件连接到输入流之前对文件做进一步分析。

* FileOutputStream 的构造方法如下：

  1）FileOutputStream(File file)：创建一个向指定 File 对象表示的文件中写入数据的文件输出流。

  2）FileOutputStream(File file, boolean append)：创建一个向指定 File 对象表示的文件中写入数据的文件输出流；如果第二个参数为 true， 则将字节写入文件末尾，而不是文件开始处。

  3）FileOutputStream(String name)：创建一个向具有指定名称的文件中写入数据的文件输出流。

  4）FileOutputStream(String name, boolean append)：创建一个向具有指定名称的文件中写入数据的文件输出流；如果第二个参数为 true， 则将字节写入文件末尾，而不是文件开始处。

* 实例：

  ```java
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
  /*
  文件中的内容是：昨夜西风凋碧树，独上高楼，望尽天涯路。欲寄彩笺兼尺素，山长水阔知何处。
  */
  ```

* 对应文件中的内容如下图：

  ![](D:\编程笔记\java\word.jpg)

  ![](D:\编程笔记\java\word中的内容.jpg)

### 2、FileReader 类与 FileWriter 类

* 由于 FileInputStream 和 FileOutStream 这两个类只提供了对字节或字节数组的读取方法，对于汉子这种双字节的文字操作不方便，读取不当时还会出现乱码，因此 Java 设计了字符流 FileReader 和 FileWriter。

* FileReader 和 FileWriter 分别对应 FileInputStream 和 FileInputStream，它们之间的构造方法类似。

* FileWriter 实例：

  ```java
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
                                  int hasread = -1;
                                  while ((hasread=fr.read(buf))!=-1){
                                      System.out.println("文件“word.txt”中的内容：\n"+new String(buf,0,hasread));
                                  }
                              } catch (IOException e) {
                                  e.printStackTrace();
                              } finally {
                                  Objects.requireNonNull(fr).close();
                              }
                          }
                          break;
                      case 3:
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
  /*
  请输入要执行的操作序号：（1,写入文件；2、读取文件;3、退出）
  1
  请输入要写入文件的内容：
  天生我材必有用，千金散尽还复来。
  上述内容已经写入到文件中！
  请输入要执行的操作序号：（1,写入文件；2、读取文件;3、退出）
  2
  文件“word.txt”中的内容：
  昨夜西风凋碧树，独上高楼，望尽天涯路。欲寄彩笺兼尺素，山长水阔知何处。天生我材必有用，千金散尽还复来。
  
  请输入要执行的操作序号：（1,写入文件；2、读取文件;3、退出）
  1
  请输入要写入文件的内容：
  水无恒形而化万形
  上述内容已经写入到文件中！
  请输入要执行的操作序号：（1,写入文件；2、读取文件;3、退出）
  2
  文件“word.txt”中的内容：
  昨夜西风凋碧树，独上高楼，望尽天涯路。欲寄彩笺兼尺素，山长水阔知何处。天生我材必有用，千金散尽还复来。
  水无恒形而化万形
  
  请输入要执行的操作序号：（1,写入文件；2、读取文件;3、退出）
  3
  
  Process finished with exit code 0
  */
  ```

  

## 五、带缓冲的输入/输出流

* 缓冲时 I/O 的一种性能优化；缓冲流为 I/O 流增加了内存缓冲区。
* 有了缓冲区，使得流上执行 skip()、mark() 和 reset() 方法都成为可能。

### 1、BufferedInputStream 类和 BufferedOutputStream 类

* BufferedInputStream 类可以对所有 InputStream 类进行带缓冲区的包装以达到性能的优化。

* BufferedInputStream 类有以下两个构造方法。

  1）BufferedInputStream(InputStream in)：创建了一个带有 32 个字节的缓冲输入流。

  2）BufferedInputStream(InputStream in, int size)：按指定的大小来创建缓冲输入流。

* BufferedOutputStream 用一个 flush() 方法将缓冲区的数据强制输出完。

* BufferedOutputStream 有以下两个构造方法：

  1）BufferedOutputStream(OutputStream in)：创建一个有 32 个字节的缓冲输出流。

  2）BufferedOutputStream(OutputStream in, int size)：以指定的大小来创建缓冲输出流。

* 实例

  ```java
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
  /*
  写入成功！
  
  文件中的内容：你不喜欢我，我一点都不介意。因为我活下来，不是为了取悦任何一个人
  */
  ```

### 2、BufferedReader 类与 BufferedWriter 类

* BufferedReader 类与 BufferedWriter 类分别继承自 Reader 类与 Writer 类，同样具有内部缓冲机制，并可以以行为单位进行输入/输出。

* BufferedReader 类常用方法如下表：

  | 方法       | 返回值 | 说明                                                         |
  | ---------- | ------ | ------------------------------------------------------------ |
  | read()     | int    | 读取单个字符                                                 |
  | readLine() | String | 读取一个文本行，并将其返回为字符串。若无数据可读，则返回null |

* BufferedWriter 类常用方法如下表

  | 方法                              | 返回值 | 说明                 |
  | --------------------------------- | ------ | -------------------- |
  | write(String s, int off, int len) | void   | 写入字符串的某一部分 |
  | flush()                           | void   | 刷新该流的缓冲       |
  | newLine()                         | void   | 写入一个行分隔符     |

* 实例：

  ```java
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
  /*
  第1行：你不喜欢我，
  第2行：我一点都不介意。
  第3行：因为我活下来，
  第4行：不是为了取悦任何一个人
  */
  ```

## 六、数据输入和输出流

* 数据输入/输出流（DataInputStream 类与 DataOutputStream 类）允许应用程序从输入流中读取 Java 基本数据类型。

* DataInputStream 类与 DataOutputStream 类的构造方法如下：

  1）DataInputStream(InputStream in)：使用指定基础的 InputStream 创建一个 DataInputStream。

  2）DataOutputStream(OutputStream out)：创建一个新的数据输出流，将数据写入指定基础的输出流。

* dataOutputstream 类常用方法如下表

  | 方法                              | 返回值 | 说明                                                         |
  | --------------------------------- | ------ | ------------------------------------------------------------ |
  | size()                            | int    | 返回计数器 written 的当前值，即到目前为止写入数据输出流的字节数。 |
  | write(byte[] b, int off, int len) | void   | 将指定的 byte  数组从偏移量 off 开始的 len 个字节写入基础输出流 |
  | write(int b)                      | void   | 将指定字节（参数 b 的八个低位）写入基础输出流中              |
  | writeBoolean(boolean v)           | void   | 将一个 boolean 值以 1-byte 值的形式写入基础输出流中          |
  | writeByte(int v)                  | void   | 将一个 byte 值以 1-byte 值的形式写入基础输出流中             |
  | writeBytes(String s)              | void   | 将字符串按字节顺序写出到基础输出流中                         |
  | writeChar(int v)                  | void   | 将一个 char 值以 2-byte 值的形式写入到基础输出流中，先写入高字节 |
  | writeChars(String s)              | void   | 将字符串按字符顺序写入到基础输出流中                         |
  | writeDouble(double v)             | void   | 使用 Double 类中的 doubleToLongBits 方法将 double 参数转换为一个 long 值，然后将该值以 8-byte 值形式写入到基础输出流中，先写入高字节 |
  | writeFloat(float v)               | void   | 使用 Float 类中的 floatToIntBits 方法将 float 参数转换成 int 值，然后将该值以 4-byte 值形式写入到基础输出流中，先写入高字节 |
  | writeInt(int v)                   | void   | 将一个 int 值以 4-byte 值形式写入到基础输出流中，先写入高字节 |
  | writeLong(long v)                 | void   | 将一个 long 值以 8-byte 值形式写入到基础输出流中，先写入高字节 |
  | writeShort(int v)                 | void   | 将一个 short 值以 2-byte 值形式写入到基础输出流中，先写入高字节 |
  | writeUTF(String str)              | void   | 使用 UTF-8 编码将一个字符串写入基础输出流中                  |


* 实例：

  ```java
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
  /*
  readUTF（）方法读取数据：使用 writeUTF() 方法写入数据
  readDouble() 方法读取数据：19.8
  readInt() 方法读取数据：298
  readBoolean() 方法读取数据：true
  */
  ```

  