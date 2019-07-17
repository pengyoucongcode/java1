# Swing 程序设计

---

## 一、Swing 概述

* Swing 主要用来开发 GUI 程序，GUI（Graphical User Interface）即图形用户界面。Java 中针对 GUI 设计提供了丰富的类库，这些类分别位于 java.awt 和 java.swing 中，简称 AWT 和 Swing ；其中，AWT（Abstract Window Toolkit）是抽象窗口工具包，是 Java 平台独立的窗口系统、图形和用户界面器件的工具包，其组件种类有限，无法实现目前 GUI 设计所需的所有功能。Swing 是 AWT 组件的增强组件，实现了 AWT 的所有功能的基础上，提供更加丰富的组件和功能，是目前开发 Java 图形界面程序的首选。

### 1、Swing 特点

* Swing 组件完全由 Java 语言编写，可以运行在任何平台上，因此将 Swing 组件称为“轻量级组件”；相反，依赖于本地平台的组件被称为“重量级组件”。

### 2、Swing 包

* Swing 包中比较重要的类是 Component 类（组件类）、Container 类（容器类）和 JComponent 类（Swing 组件父类）。
* 在 Swing 组件中，大多数 GUI 组件都是 Component 类的直接子类或间接子类，而 JComponent 类是 Swing 组件各种特性的存放位置，这些组件的特性包括设定组件边界、GUI 组件自动滚动等。

### 3、常用 Swing 组件概述

* 常用 Swing 组件如下表：

  | 组件名称       | 定义                                       |
  | -------------- | ------------------------------------------ |
  | JButton        | 代表 Swing 按钮，按钮可以带文字或图片      |
  | JCheckBox      | 代表 Swing 中的复选框控件                  |
  | JComBox        | 代表下拉列表框，可以在下拉区域显示多个选项 |
  | JFrame         | 代表 Swing 框架类                          |
  | JDialog        | 代表 Swing 版本的对话框                    |
  | JLabel         | 代表 Swing 中的标签组件                    |
  | JRadioButton   | 代表 Swing 的单选按钮                      |
  | JList          | 代表能够在用户界面显示一系列条目的组件     |
  | JTextField     | 代表文本框                                 |
  | JPasswordField | 代表密码框                                 |
  | JTextArea      | 代表 Swing 中的文本区域                    |
  | JOptionPane    | 代表 Swing 中的一些对话框                  |

## 二、常用窗体

* Swing 中常用的窗体包括 JFrame 和 JDialog

### 1、JFrame 窗体

* JFrame 窗体是一个容器，是 Swing 程序中各个组件的载体。在开发应用程序时可以通过继承 javax.swing.JFrame 类创建一个窗体，在这个窗体中添加组件。

* JFrame 类常用的构造方法包括以下两种方式：

  1）public Jframe()：创建一个初始不可见、没有标题的新窗体。

  2）public JFrame(String title)：创建一个不可见但具有标题的窗体。

* 示例：

  ```java
  JFrame jf = new JFrame(title);
  Container container = jf.getContaintPane();
  container.add(new JButton("按钮"));  //添加按钮控件
  container.remove(new JButton("按钮"));  //移除按钮控件
  ```

* 设置窗体属性的常用方法如下：

  1）setBounds(int x, int y, int width, int height)：设置组件左上角顶点的坐标为(x, y)，宽度为 width，高度为 height。

  2）setLocation(int x, int y)：设置组件左上角的坐标为(x, y)

  3）setSize(int width, int height)：设置组件的宽度和高度

  4）setVisible(boolean b)：设置组件是否可见，true为可见，反之则反

  5）setDefaultCloseOperation(int operation)：设置以什么方式关闭 Jframe 窗体，默认值为 DISPOSE_ON_CLOSE。

  * JFrame 窗体关闭的几种方式：

    | 窗体关闭方式        | 实现功能                                 |
    | ------------------- | ---------------------------------------- |
    | DO_NOTHING_ON_CLOSE | 表示单击“关闭”按钮时无任何操作           |
    | DISPOSE_ON_CLOSE    | 表示单击“关闭”按钮时隐藏丙释放窗口       |
    | HIDE_ON_CLOSE       | 示单击“关闭”按钮时将当前窗口隐藏         |
    | EXIT_ON_CLOSE       | 示单击“关闭”按钮时退出当前窗口并关闭程序 |

* 实例：

  ```java
  import java.awt.*;
  import javax.swing.*;
  
  public class JFrameTest extends JFrame{
      public void CreateJFrame(String title){
          JFrame jf = new JFrame(title);  //创建 JFrame 对象
          Container ct = jf.getContentPane();  //获取一个容器
          JLabel jl = new JLabel("这是一个 JFrame 窗体");  // 创建一个 JLabel 标签
          //使标签文字居中
          jl.setHorizontalAlignment(SwingConstants.CENTER);
          ct.add(jl);  //将标签添加到容器中
          ct.setBackground(Color.white);   //设置容器的背景颜色
          jf.setVisible(true);  //使窗体可见
          jf.setSize(800,600);
          //设置窗体关闭方式
          jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new JFrameTest().CreateJFrame("创建一个 JFrame 窗体");
      }
  }
  ```

* 运行结果：

  ![JFrame窗体](D:\编程笔记\java\JFrame 窗体测试.jpg)

### 2、JDialog 窗体

* JDialog 窗体是 Swing 组件中的对话框，继承了 AWT 组件中的 java.awt.Dialog 类。

* 在应用程序中创建 JDialog 窗体需要实例化 JDialog 类，通常使用以下几个构造方法：

  1）public JDialog()：创建一个没有标题和父窗体的对话框。

  2）public JDialog(Frame f)：创建一个指定父窗体的对话框，但对话框没有标题。

  3）public JDialog(Frame f, boolean model)：创建一个指定类型的对话框，并指定父窗体，但该窗体没有指定标题。如果 model 为 true ，则弹出对话框后，用户无法操作父窗体。

  4）public JDialog(Frame f, String title)：创建一个指定标题和父窗体的对话框

  5）public JDialog(Frame f, String title, boolean model)：创建一个指定标题、窗体和模式的对话框。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  class MyJDialog extends JDialog {
      public MyJDialog(MyFrame frame) {
          //实例化一个 Jdialog 类对象，指定对话框的父窗体、窗体标题和类型
          super(frame, "第一个JDialog窗体", true);
          Container ct = getContentPane(); //创建容器
          ct.add(new JLabel("这是一个对话框"));  //添加标签
          setBounds(120, 120, 300, 300);  //设置对话框窗体在桌面显示的坐标和大小
      }
  }
  
  public class MyFrame extends JFrame {
      public MyFrame(){
          Container ct = getContentPane();  //获得窗体容器
          ct.setLayout(null);  //容器使用null布局
          JButton b1 = new JButton("弹出对话框");  //定义一个按钮
          b1.setBounds(10,10,100,21);  //定义按钮在容器中的坐标和大小
          b1.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //创建对话框
                  MyJDialog Dlg = new MyJDialog(MyFrame.this);
                  Dlg.setVisible(true);  //使MyDialog窗体可见
              }
          });
          ct.add(b1);  //将按钮添加到容器中
          ct.setBackground(Color.WHITE);  //窗体背景设置为白色
          setSize(800,600);  //窗口大小
          //窗口关闭结束程序
          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
          setVisible(true);  //使窗口可见
      }
  
      public static void main(String[] args) {
          new MyFrame();  //实例化 MyFrame 类对象
      }
  }
  ```

* 运行结果：

  ![对话框](D:\编程笔记\java\JDialog.jpg)

## 三、常用布局管理器

* 在 Swing 中，每个组件在容器中都有一个具体的位置和大小，而容器中摆放组件时候很难判断其具体位置和大小；使用布局管理器较程序员直接在容器中控制 Swing 组件的位置和大小方便得多，可以有效地处理整个窗体的布局。Swing 提供的常用布局管理器有 FlowLayout 流布局管理器、BorderLayout 边界布局管理器和 GridLayout 网格布局管理器，这些布局管理器都位于 java.awt 包中。

### 1、绝对布局

* 绝对布局，就是硬性指定组件在容器中的位置和大小，可以使用绝对坐标的方式来指定组件的位置。

* 设置绝对布局的方法有两种，分别如下：

  1）使用 Container.setLayout(null) 方法取消布局管理器。

  2）使用 Container.setBounds() 方法设置每个组件的大小和位置。

* 例子：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class AbsolutePosition extends JFrame {
      public AbsolutePosition(){
          setTitle("本窗体使用绝对布局");
          setLayout(null); //使该窗体取消布局管理器
          /*
           * 定位窗体的坐标位置和宽高
           * 窗体在屏幕中的 x 坐标为 0，y 坐标为 0，窗体高400像素，宽600像素
           */
          setBounds(0,0,600,400);
          Container c = getContentPane();
          JButton b1 = new JButton("按钮1");
          JButton b2 = new JButton("按钮2");
  
          /*
           * 设置按钮的位置和大小
           * 按钮1的横坐标为10，纵坐标为30，宽80像素，高30像素
           * 按钮2的横坐标为60，纵坐标为70，宽100像素，高20像素
           */
          b1.setBounds(10,30,80,30);
          b2.setBounds(60,70,100,20);
          b2.setVisible(true);
          b1.setVisible(true);
          c.add(b1);
          c.add(b2);
          c.setBackground(Color.WHITE);  //窗体背景设置为白色
          setVisible(true);
  
          //设置窗体关闭方式
          setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new AbsolutePosition();
      }
  
  }
  ```

* 运行结果：

  ![绝对布局](D:\编程笔记\java\绝对布局.jpg)

### 2、流布局

* 流布局管理器是最基本的布局管理器，在整个容器中的布局像“流”一样，从左到右摆放组件，直到占据这一行的所有空间，再向下移动一行。

* FlowLayout 类具有以下常用的构造方法：

  1）public FlowLayout()方法

  2）public FlowLayout(int aligment)方法

  3）public FlowLayout(int aligment, int horizGap, int vertGap)方法。

  * 构造方法中的 alignment 参数表示使用流布局管理器后组件在每一行的具体摆放位置，取值如下表：

    | alignment 参数值  | 说明                                   |
    | ----------------- | -------------------------------------- |
    | FlowLayout.LEFT   | 每一行的组件将被指定为按照左对齐排列   |
    | FlowLayout.CENTER | 每一行的组件将被指定为按照居中对齐排列 |
    | FlowLayout.RIGHT  | 每一行的组件将被指定为按照右对齐排列   |

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class FlowLayoutPosition extends JFrame {
      public FlowLayoutPosition(){
          setTitle("本窗体使用流布局管理器");  //设置窗体标题
          Container c = getContentPane();
          // 设置窗体使用流布局管理器，使组件右对齐，组件之间水平间隔为10像素，垂直间隔为10像素
          setLayout(new FlowLayout(FlowLayout.RIGHT,10,10));
          for(int i=0;i<10;i++){
              c.add(new Button("button"+i));
          }  //添加十个按钮
          setSize(600,400);
          setVisible(true);
  
          //设置窗体关闭方式
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new FlowLayoutPosition();
      }
  
  }
  ```

  * 输出：

    ![流布局](流布局.jpg)

### 3、BorderLayout 边界布局管理器

* 创建完窗体后，在默认不指定窗体布局的情况下，Swing 组件的布局模式是边界布局，边界布局管理器将容器划分为东南西北中五个区域。

* 在调用 Container 类的 add() 方法时，设置此组件在容器中的区域，可由 BorderLayout 以下的成员变量来控制组件在容器中的区域。

  | 成员变量            | 含义                                                         |
  | ------------------- | ------------------------------------------------------------ |
  | BorderLayout.NORTH  | 在容器中添加组件时，组件置于北部                             |
  | BorderLayout.SOUTH  | 在容器中添加组件时，组件置于南部                             |
  | BorderLayout.EAST   | 在容器中添加组件时，组件置于东部‘                            |
  | BorderLayout.WEST   | 在容器中添加组件时，组件置于西部                             |
  | BorderLayout.CENTER | 在容器中添加组件时，组件于中间开始填充，直到与其他组件边界连接 |

* **如果使用了边界布局管理器，在向容器中添加组件时，如果不指定添加到哪个区域，則默认添加到 CENTER 区域；如果向一个区域中同时添加多个组件，后放入的组件会覆盖先放入的组件。**

* add() 方法的常用语法格式如下：

  ```java
  public void add(Component comp, Object constraints);
  comp：要添加的组件
  constraints：表示此组件的布局约束的对象
  //例子
  import javax.swing.*;
  import java.awt.*;
  
  public class BorderLayoutPosition extends JFrame {
      public BorderLayoutPosition() {
          setTitle("使用边界布局管理器");
          Container c = getContentPane();
          setLayout(new BorderLayout());  //设置边界布局管理器
          JButton centerBtn = new JButton("中"),
                  northBtn = new JButton("北"),
                  southBtn = new JButton("南"),
                  westBtn = new JButton("西"),
                  eastBtn = new JButton("东");
  
          //添加按钮到东南西北中五个区域
          c.add(centerBtn, BorderLayout.CENTER);
          c.add(northBtn, BorderLayout.NORTH);
          c.add(southBtn, BorderLayout.SOUTH);
          c.add(westBtn, BorderLayout.WEST);
          c.add(eastBtn, BorderLayout.EAST);
  
          setSize(600,400);
          setVisible(true);
          //设置窗体关闭方式
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new BorderLayoutPosition();
      }
  }
  ```

* 运行结果：

  ![边界布局](边界布局.jpg)

### 4、网格布局（GridLayout）管理器

* 网格布局管理器将容器划分为网格，所有组件按行和列进行排列；每个组件的大小相同，网格中的空格数由网格的行和列的数量决定。

* 网格布局管理器主要有以下两个常用的构造方法：

  1）public GridLayout(int rows, int columns)方法；

  2）public GridLayout(int rows,int columns,int horizGap, int vertGap)方法

* horizGap 和 vertGap 分别指水平间距和竖直间距

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class GridLayoutPosition extends JFrame {
      public GridLayoutPosition() {
          Container c = getContentPane();
          /*
           * 设置容器使用网格布局管理器，设置7行3列的网格
           * 组件间水平间距为5像素，垂直间距为5像素
           */
          setLayout(new GridLayout(7, 3, 5, 5));
          for (int i = 0; i < 20; i++) {
              c.add(new JButton("按钮" + i));
          }
          setSize(300,300);
          setTitle("网格布局");
          setVisible(true);
          //设置窗体关闭方式
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new GridLayoutPosition();
      }
  }
  ```

* 运行结果：

  ![网格布局](D:\编程笔记\java\1560824840745.png)

## 四、常用面板

* 面板也是一个 Swing 容器，可以作为容器容纳其他组件，但必须添加到其他容器中。Swing 中常用的面板包括 JPanel 面板以及 JScrollPane 面板。

### 1、JPanel 面板

* JPanel 面板，继承自 java.awt.Container 类；JPanel 面板可以聚集一些组件来布局，但必须依赖于 JFrame  窗体进行使用。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class JPanelTest extends JFrame {
      public JPanelTest() {
          Container c = getContentPane();
          // 将整个容器设置为两行一列的网格布局，组件水平间隔为10像素，垂直间隔为10像素
          c.setLayout(new GridLayout(2, 1, 10, 10));
          // 初始化一个面板，此面板使用一行三列的网格布局，组件水平间隔为10像素，垂直间隔为10像素
          JPanel p1 = new JPanel(new GridLayout(1,3,10,10));
          JPanel p2 = new JPanel(new BorderLayout());  // 使用边界布局
          JPanel p3 = new JPanel(new GridLayout(1,2,10,10));
          JPanel p4 = new JPanel(new GridLayout(2,1,10,10));
  
          // 给每个面板都添加框和标题，使用 BorderFactory 工厂类生成带标题的边框对象
          p1.setBorder(BorderFactory.createTitledBorder("面板1"));
          p2.setBorder(BorderFactory.createTitledBorder("面板2"));
          p3.setBorder(BorderFactory.createTitledBorder("面板3"));
          p4.setBorder(BorderFactory.createTitledBorder("面板4"));
  
          // 面板中添加按钮
          p1.add(new Button("b1"));
          p1.add(new Button("b2"));
          p1.add(new Button("b3"));
          p1.add(new Button("b4"));
  
          p2.add(new JButton("b5"), BorderLayout.WEST);
          p2.add(new JButton("b6"), BorderLayout.EAST);
          p2.add(new JButton("b7"), BorderLayout.NORTH);
          p2.add(new JButton("b8"), BorderLayout.SOUTH);
          p2.add(new JButton("b9"));
  
          p3.add(new JButton("a1"));
          p3.add(new JButton("a2"));
  
          p4.add(new JButton("a3"));
          p4.add(new JButton("a4"));
  
          c.add(p1);
          c.add(p2);
          c.add(p3);
          c.add(p4);
  
          setSize(500,300);
          setVisible(true);
          //设置窗体关闭方式
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new JPanelTest();
      }
  }
  ```

* 运行结果：

  ![JPanel面板](D:\编程笔记\java\1560840598825.png)

### 2、JScrollPane 滚动面板

* JScrollPane 面板是带滚动条的面板，也是一种容器，但只能放置一个组件，并且不可以使用布局管理器；如果需要在 JScrollPane 面板上放置多个组件，需要将多个组件先放置在 JPanel 上，然后再将 JPanel 作为一个整体添加到 JScrollPane 面板中。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class JScrollPaneTest extends JFrame {
      public JScrollPaneTest(){
          Container c = getContentPane();
          //创建文本区域组件，文本默认大小为20行、50列
          JTextArea ta = new JTextArea(20,50);
          //创建 JScroolPane 面板，并将文本域放置到面板中
          JScrollPane sp = new JScrollPane(ta);
          c.add(sp);
          setTitle("带滚动条的文字编辑器");
          setSize(600,400);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new JScrollPaneTest();
      }
  }
  ```

* 运行结果：

  ![滚动面板](D:\编程笔记\java\1561106474160.png)

## 五、标签组件与图标

* 在 Swing 中显示文本或提示信息的方法是使用标签（JLabel），它支持文本字符串和图标。

### 1、JLabel 标签组件

* 标签由 JLabel 类定义，其父类为 JComponent 类。

* 标签可以显示一行只读文本、一个图像或带图像的文本，不产生任何类型的事件，指示简单的显示文本或图像，但可以使用标签的特性指定标签上文本的对齐方式。

* JLabel 类常用的构造方法如下：

  1）public JLabel()：创建一个不带任何文本和图标的对象。

  2）public JLabel(Icon icon)：创建一个带图标的对象。

  3）public JLabel(Icon icon, int aligment)：创建一个带图标的对象，并设置图标水平对齐方式。

  4）public JLabel(String text, int aligment)：创建一个带文本的对象，并设置文本水平对齐方式。

  5）public JLabel(String text, Icon icon, int aligment)：创建一个带文本、图标的对象，并设置标签内容水平对齐方式。

* 例子：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class JLabelTest extends JFrame {
      JLabelTest() {
          Container c = getContentPane();
          JPanel p1 = new JPanel(new BorderLayout());
          JLabel labelContacts = new JLabel("联系人");  //创建标签并设置内容
          labelContacts.setForeground(new Color(0, 102, 153)); //标签字体颜色
          labelContacts.setFont(new Font("华文楷体", Font.BOLD, 30)); //标签字体、样式和大小
          labelContacts.setBounds(0, 0, 194, 28);  //标签位置及大小
          p1.add(labelContacts);
          c.add(p1);
          setTitle("标签测试");
          setSize(600, 400);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new JLabelTest();
      }
  }
  ```

* 运行结果：

  ![标签](D:\编程笔记\java\1561108277866.png)

### 2、图标的使用

* 图标可以用 Java 支持的图片文件来创建，也可以使用 java.awt.Graphics 类提供的功能方法来创建。

#### 2.1、创建图标

* 在 Swing 中通过 Icon 接口来创建图标，并在创建时设置图标大小、颜色等属性。

* 如果使用 Icon 接口，必须实现 Icon 接口中的三个方法：

  1）public int getIconHeight()：获取图标高度。

  2）public int getIconWidth()：获取图标长度。

  3）public void paintIcon(Component arg0, Graphics arg1, int arg2, int arg3)：在指定坐标位置上画图，其参数说明如下：、

  | 参数 |          说明          |
  | :--: | :--------------------: |
  | arg0 | 设置绘图属性，如背景色 |
  | arg1 |      指定绘图对象      |
  | arg2 |         X 坐标         |
  | arg3 |         Y 坐标         |

* 实例

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class DrawIcon implements Icon { //实现Icon 接口
      private int width;  // 宽
      private int height; // 高
      public DrawIcon(int width, int height){
          this.height=height;
          this.width=width;
      }
  
      @Override
      public int getIconHeight() {
          return this.height;
      }
  
      @Override
      public int getIconWidth() {
          return this.width;
      }
  
      @Override
      public void paintIcon(Component c, Graphics g, int x, int y) {
          g.fillOval(x, y, width, height);
      }
  
      public static void main(String[] args) {
          DrawIcon icon = new DrawIcon(15,15);
          //创建一个标签
          JLabel j = new JLabel("测试",icon,SwingConstants.CENTER);
          JFrame jf = new JFrame();
          Container c = jf.getContentPane();
          c.add(j);
          jf.setSize(300,150);
          jf.setVisible(true);
          jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  }
  ```

* 运行结果

  ![图标](图标.jpg)

**可以使用语句：DawIcon  icon  =  new  DrawIcon(15,15)；来创建图标。**

#### 2.2、使用图片创建图标

* Swing 可以利用 javax.swing.ImageIcon 类根据现有图片来创建图标。

* ImageIcon 类的常用构造方法如下：

  1）public IamgeIcon()：创建一个通用的 ImageIcon 对象，在真正需要设置图片时调用 setImage(Image image)方法来操作。

  2）public ImageIcon(Image image)：直接从图片源创建图标

  3）public ImageIcon(Image image, String description)：从图片源创建图标的同时添加描述，该描述不会显示在图标上，但可以用 getDescription() 方法获取。

  4）public ImageIcon(URL url)：使用位于计算机网络上的图像文件创建图标。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.net.URL;
  
  public class MyImageIcon extends JFrame {
      private MyImageIcon(){
          Container c = getContentPane();
          JLabel jl = new JLabel("这是一个JFrame窗体",JLabel.CENTER);
          //获取图片所在的 URL
          URL url = MyImageIcon.class.getResource("雅男1.jpg");
          Icon icon = new ImageIcon(url);
          jl.setIcon(icon);
          //设置文字放置在标签中间
          jl.setHorizontalAlignment(SwingConstants.CENTER);
          jl.setOpaque(true);  //设置标签不透明状态
          c.add(jl);
          setSize(600,400);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new MyImageIcon();
      }
  }
  ```

* 运行结果：

  ![图片图标](图片图标.jpg)

## 六、文本组件

### 1、JTextField 文本框组件

* 文本框（JTextField）用来显示或编辑一个单行文本，在 Swing 中通过 javax.swing.JTextField 类对象创建，该类继承了 javax.swing.text.JTextComponent 类。

* 文本框常用的构造方法如下：

  1）public JTextField()：构造一个没有任何初始值的文本框。

  2）public JTextField(String  text)：构造一个用指定文本(text)初始化的文本框。

  3）public JTextField(int fieldwidth)：构造一个具有指定列数的文本框。

  4）public JTextField(String text, int fieldwidth)：构建一个用指定文本和列数初始化的文本框。

  5）public JTextField(Document docModel, String text, int fieldWidth)：构造一个文本框，使用指定的存储模型和给定的列数。

* 如果使用第一种构造方法，可以使用 setText() 方法为其设置文本内容，语法：public void setText(String text)。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  public class JTextFieldTest extends JFrame {
      private JTextFieldTest(){
          Container c = getContentPane();
          c.setLayout(new FlowLayout());
          // 设置文本框初始值
          JTextField jt = new JTextField("若道天涯无回路，漫漫黄沙掩枯骨");
          jt.setColumns(20); //  设置文本框长度
          // 设置字体
          jt.setFont(new Font("华文楷体", Font.PLAIN, 20));
          JButton jb = new JButton("清除");
          jt.addActionListener(new ActionListener() {  // 为文本框添加回车事件
              @Override
              public void actionPerformed(ActionEvent e) {
                  jt.setText("天生我材必有用，千金散尽还复来。");  // 设置文本框中的值
              }
          });
          jb.addActionListener(new ActionListener() {  // 为按钮添加事件
              @Override
              public void actionPerformed(ActionEvent e) {
                  System.out.println(jt.getText()); // 输出当前文本的值
                  jt.setText("");  // 将文本置空
                  jt.requestFocus();  // 焦点回到文本框
              }
          });
          c.add(jt);  // 窗体容器添加文本框
          c.add(jb); // 窗体添加按钮
          setBounds(100,100,450,250);
          setVisible(true);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new JTextFieldTest();
      }
  }
  ```

* 运行结果：

  ![文本框初始化](文本框初始化.jpg)

  ![点击删除](点击删除.jpg)

  ![回车后](回车后.jpg)

### 2、JPasswordField 密码框组件

* 密码框对象是通过 javax.swing.JPasswordField 类创建，该类常用的构造方法如下：

  1）public JPasswordField()

  2）public JPasswordField(String text)

  3）public JPasswordField(int fieldwidth)

  4）public JPasswordField(String text, int fieldwidth)

  5）public JPasswordField(Document docModel, String text, int fieldwidth)

* JPasswordField 类提供了一个 setEchoChar() 方法，可以改变密码框的回显字符，语法如下：

  ```java
  public void setEchoChar(char c);
  // 参数 c 是要显示的回显字符
  // 在程序中定义密码框
  JPasswordField jp = new JPasswordField();
  jp.setEchoChar('#');
  // 想要获取密码狂中的字符，可以使用如下字符
  char ch[] = jp.getPassword();
  String pwd = new String(ch);
  ```

### 3、JTextArea 文本域组件

* Swing 中任何一个文本区域都是 JTextArea 类型的对象

* JTextArea 常用的构造方法如下：

  1）public JTextArea()：构造没有任何初始化文本的文本域

  2）public JTextArea(String text)：构造显示指定文本的文本域

  3）public JTextArea(int rows, int columns)：构造具有指定行列的空文本域

  4）public JTextArea(Document doc)：构造具有指定文档模型，其他参数为(null, 0 , 0)

  5）public JTextArea(Document doc, String text, int rows, int columns)：构造具有指定行列数和文档模型的文本域

* 使用 JTextArea 类的 append(String  str) 可以为文本域添加文本。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class JTextAreaTest extends JFrame {
      private JTextAreaTest(){
          setSize(200,100);
          setTitle("定义自动换行文本");
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          Container c = getContentPane();
          // 创建6行6列默认值为“若道天涯无回路，漫漫黄沙掩枯骨”的文本域组件
          JTextArea jt = new JTextArea("若道天涯无回路，漫漫黄沙掩枯骨",6,6);
          jt.setLineWrap(true);  // 可以自动换行
          c.add(jt);
          setVisible(true);
      }
      public static void main(String[] args) {
          new JTextAreaTest();
      }
  }
  ```


## 七、按钮组件

* Swing 中提供多种按钮组件，包括按钮、单选按钮、复选框等。

### 1、JButton 按钮组件

* Swing 中的按钮（JButton）由 JButton 对象表示，其构造方法主要有以下几种形式：

  1）public JButton()：创建不带文本或图标的按钮。

  2）public JButton(String text)：创建一个带文本的按钮。

  3）public JButton(Icon icon)：创建一个带图标的按钮。

  4）public JButton(String text, Icon icon)：创建一个带初始文本和图标的按钮。

* JButton 按钮创建完后，可以使用以下 JButton 类提供的方法对按钮的相关属性进行设置：

  | 方法                        | 说明                                                         |
  | --------------------------- | ------------------------------------------------------------ |
  | setIcon(Icon defaultIcon)   | 设置按钮的默认图标                                           |
  | setToolTipText(String text) | 为按钮设置提示文字                                           |
  | setBorderPainted(boolean b) | 设置 borderPainted 属性；如果该属性为 true 并且按钮有边框，则绘制该边框；其默认值为 true |
  | setEnabled(boolean b)       | 设置按钮是否可用，参数 true 表示可用，false 表示不可用       |

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  import java.net.URL;
  
  public class JButtonTest extends JFrame {
      private JButtonTest() {
          URL url = JButtonTest.class.getResource("按钮1.jpg");
          Icon icon = new ImageIcon(url);
          setLayout(new GridLayout(3, 2, 5, 5));  // 设置网格布局管理器
          Container c = getContentPane();
          JButton btn[] = new JButton[6]; // 创建按钮数组
          for (int i = 0; i < btn.length; i++) {
              btn[i] = new JButton();
              c.add(btn[i]);
          }
          btn[0].setText("不可用");
          btn[0].setEnabled(false);
          btn[1].setText("有背景色");
          btn[1].setBackground(Color.YELLOW);
          btn[2].setText("无边框");
          btn[2].setBorderPainted(false);
          btn[3].setText("有边框");
          btn[3].setBorder(BorderFactory.createLineBorder(Color.RED));  // 添加红色边框
          btn[4].setIcon(icon);  // 设置按钮图标
          btn[4].setToolTipText("图片按钮");
          btn[5].setText("可点击");
          btn[5].addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  JOptionPane.showMessageDialog(JButtonTest.this, "点击按钮");
              }
          });
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setVisible(true);
          setTitle("创建不同样式的按钮");
          setBounds(100,100,600,400);
      }
  
      public static void main(String[] args) {
          new JButtonTest();
      }
  }
  
  ```

* 运行结果：

  ![按钮](按钮.jpg)

  ![按钮2](按钮2.jpg)

### 2、JRadioButton 单选按钮组件

* 单选按钮是 Swing 组件中的 JRadioButton 类的对象，该类是 JToggleButton 的子类，而 JToggleButton 类又是 AbstractButton 类的子类，所以控制单选按钮的诸多方法都是 AbstractButton 类中的方法。

#### 2.1、单选按钮

* JRadioButton 类的常用构造方法如下：

  1）public JRadioButton()：创建一个初始化为未选择的单选按钮，其文本未设定。

  2）public JRadioButton(Icon icon)：创建一个初始化为未选择的单选按钮，其具有指定的图像但无文本。

  3）public JRadioButton(Icon icon, boolean selected)：创建一个具有指定图像和选择状态的单选按钮，但无文本。

  4）public JRadioButton(String text)：创建一个具有指定文本的状态为未选择的单选按钮。

  5）public JRadioButton(String text, Icon icon)：创建一个具有指定文本和图像并初始化未选择的单选按钮。

  6）public JRadioButton(String text, Icon icon, boolean selected)：创建一个具有指定文本和图像和选择状态的单选按钮。

#### 2.2、按钮组

* Swing 中存在一个 ButtonGroup 类，表示按钮组；按钮组里，只有一个按钮可以被选中，可以通过 add() 方法将单选按钮添加到按钮组里。

#### 2.2、按钮实例

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RadioButtonTest extends JFrame {
    private RadioButtonTest(){
        setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
        Container c = getContentPane();
        JRadioButton rbtnNormal = new JRadioButton("普通发送");
        rbtnNormal.setFont(new Font("楷体",Font.PLAIN,14));
        rbtnNormal.setBounds(20,30,75,22);
        rbtnNormal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbtnNormal.isSelected())
                    JOptionPane.showMessageDialog(null,"您选择的是："+rbtnNormal.getText(),
                            "提醒",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        JRadioButton rbtnPwd = new JRadioButton("加密发送");
        rbtnPwd.setFont(new Font("宋体",Font.PLAIN,14));
        rbtnPwd.setBounds(100,30,75,22);
        rbtnPwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbtnPwd.isSelected())
                    JOptionPane.showMessageDialog(null,"您选择的是："+rbtnPwd.getText(),
                            "提醒",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnNormal);
        group.add(rbtnPwd);
        c.add(rbtnNormal);
        c.add(rbtnPwd);
        setBounds(558,300,500,300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new RadioButtonTest();
    }
}

```

* 运行效果：

  ![选择1](选择1.jpg)

  ![选择2](选择2.jpg)

### 3、JCheckBox 组件

* 与单选按钮不一样的是，复选框可以多选，每个复选框都提供“选中”与“不选中”两种状态。

* JCheckBox 类继承自 AbstractButton 类，因此复选框的属性设置来源于 AbstractButton 类。

* JCheckBox 的常用构造方法如下：

  1）public JCheckBox()：创建一个没有文本、没有图标并且最初未被选定的复选框。

  2）public JCheckBox(Icon icon, boolean checked)：创建一个带图标的复选框，并且指定最初是否处于选定状态。

  3）public JCheckBox(String text, Icon icon, boolean checked)：创建一个带文本的复选框，并指定其最初是否处于选定状态。

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  public class CheckBoxTest extends JFrame {
      private CheckBoxTest() {
          Container c = getContentPane();
          c.setLayout(new FlowLayout());
          setBounds(100, 100, 133, 125);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setVisible(true);
          JCheckBox c1 = new JCheckBox("1");
          JCheckBox c2 = new JCheckBox("2");
          JCheckBox c3 = new JCheckBox("3");
          c.add(c1);
          c.add(c2);
          c.add(c3);
          JButton btn = new JButton("打印");
          btn.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  System.out.println(c1.getText()+"按钮选中状态："+c1.isSelected());
                  System.out.println(c2.getText()+"按钮选中状态："+c2.isSelected());
                  System.out.println(c3.getText()+"按钮选中状态："+c3.isSelected());
              }
          });
          c.add(btn);
      }
  
      public static void main(String[] args) {
          new CheckBoxTest();
      }
  }
  ```

* 运行效果：

  ![复选框](复选框.jpg)
  
* 打印结果：

  ```java
  1按钮选中状态：true
  2按钮选中状态：false
  3按钮选中状态：true
  ```

  

## 八、列表组件

* Swing 提供两种列表组件，分别是下拉列表框（JComboBox)与列表框（JList）；列表框较下拉列表框更为直观，将所有的项目罗列在列表框中；下拉列表更为便捷、美观，将所有的项目隐藏起来，当用户选用其中的项目时才显示出来。

### 1、JComboBox 下拉列表组件

* Swing 的下拉列表框与 Windows操作系统中的下拉列表不同的是，Swing 中的下拉列表框不仅可以供用户选择项目，也提供编辑项目中的内容。

* JComboBox 继承自 javax.swing.JComponent 类，其常用的构造方法如下：

  1）public JComboBox()：创建具有默认数据类型的列表框。

  2）public JComboBox(ComBoxModel dataModel)：创建一个使用 ComboBoxModel 中的数据的列表框，ComboBoxModel 是一个用于组合框的数据模型，具有选择项的概念。

  3）public JComboBox(Object[] arrayData)：创建包含指定数组元素的列表框。

  4）public JComboBox(Vector vector)：创建一个包含指定 Vector 中的元素的列表框，Vector 的大小可以根据需要增大或缩小，以适应创建 Vector 后进行添加或移除项的操作。

* JComboBox 类中常用的方法如下表：

  | 方法                        | 说明                                                         |
  | --------------------------- | ------------------------------------------------------------ |
  | addItem(Object anObject)    | 为列表框添加项                                               |
  | getItemCount()              | 返回列表框的项数                                             |
  | getSelectedItem()           | 返回当前的所选项                                             |
  | getSelectedIndex()          | 返回列表中与给定项匹配的第一个选项                           |
  | removeItem(Object anObject) | 为列表框移除选项                                             |
  | setEditable(boolean aFlag)  | 确定 JComboBox 中的字段是否可编辑，参数为 true 时表示可编辑，否则不能编辑。 |

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  
  public class JComboBoxTest extends JFrame {
      private JComboBoxTest(){
          Container c = getContentPane();
          setLayout(new FlowLayout());
          setSize(330,132);
          setVisible(true);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          JComboBox<String> comboBox = new JComboBox<>();  // 创建数据类型为字符串的下拉列表框
          comboBox.setBounds(110,11,80,21);
          comboBox.addItem("身份证");
          comboBox.addItem("军人证");
          comboBox.addItem("学生证");
          comboBox.addItem("工作证");
          c.add(comboBox);
           JLabel result = new JLabel("结果");
           result.setBounds(77,57,146,15);
           JButton bt = new JButton("确定");
           bt.setBounds(200,10,67,23);
           bt.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   // 获取下啦列表框中的选项
                   result.setText("您选择的是："+comboBox.getSelectedItem());
               }
           });
           c.add(bt);
           c.add(result);
      }
  
      public static void main(String[] args) {
          new JComboBoxTest();
      }
  
  }
  
  ```

* 运行效果：

  ![列表框](列表框.jpg)

### 2、JList 列表框组件

* JList 常用的构造方法如下：

  1）public  JList()：构造一个具有空的、只读模型的列表框。

  2）public  JList(Object[] listData)：构造一个列表框，使其指定显示数组中的元素。

  3）public JList(Vector listData)：构造一个列表框，使其显示指定 Vector 中的元素。

  4）public JList(ListModel dataModel)：根据指定的非 null 模型构造一个显示元素的列表框。

* 对于第一中构造方法，可以在构造对象后使用setListData() 方法进行设置。

* 使用数组作为参数初始化列表框：

  ```java
  String[] contents={"s1","s2","s3","s4"};
  JList jl = new JList(contents);
  ```

* 使用 Vector 为参数初始化列表框：

  ```java
  Vector contents = new Vector();
  JList jl = new JList(contents);
  contents.add("s1");
  contents.add("s2");
  contents.add("s3");
  contents.add("s4");
  ```

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  
  public class JListTest extends JFrame {
      private JListTest() {
          Container cp = getContentPane();
          cp.setLayout(null);  // 容器使用绝对布局
          // 创建字符串数组，保存列表中的数据
          String[] contents = {"列表1", "列表2", "列表3", "列表4", "列表5", "列表6"};
          JList<String> jl = new JList<>(contents);
          JScrollPane js = new JScrollPane(jl);
          js.setBounds(10,10,100,109);
          cp.add(js);
          // 创建文本域
          JTextArea area = new JTextArea();
          JScrollPane scrollPane = new JScrollPane(area);
          scrollPane.setBounds(118,10,73,80);
          cp.add(scrollPane);
          JButton btn = new JButton("确认");
          btn.setBounds(120,96,71,23);
          cp.add(btn);
          btn.addActionListener(e -> {
              // 获取列表中选中的元素，返回 java.util.List 类型
              java.util.List<String> values = jl.getSelectedValuesList();
              area.setText("");  // 清空文本域
              for(String value:values){
                  area.append(value+"\n");  // 在文本域循环追加 List 中的元素
              }
          });
          setTitle("列表框");
          setSize(217,167);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      }
  
      public static void main(String[] args) {
          new JListTest();
      }
  }
  ```

* 运行效果：

  ![JList](JList.jpg)

* 使用 DefaultModel：

  ```java
  final String[] contents = {"列表1", "列表2", "列表3", "列表4", "列表5", "列表6"};
  final DefaultListModel iItems = new DefaultListModel();
  final JList jl = new JList(iItems);
  for (int i = 0; i < 6; i++) {
              iItems.addElement(contents[i]);
          }
  ```

* 最终运行效果如同上图。

## 九、常用事件监听器

### 1、监听事件简介

* 在 Swing 事件模型中，由 3 个分离的对象完成对事件的处理，分别为事件源（组件）、事件以及监听器。
* 事件源触发一个事件，该事件被一个或多个“监听器”接收，监听器负责处理事件。
* 事件监听器，实质上是一个“实现特定类型监听器接口”的类对象。

### 2、动作事件监听器

* 动作事件（ActionEvent）监听器，是负责监听组件的动作的监听器。

* 下表描述了动作事件监听器的接口与事件源。

  | 事件名称    | 事件源                       | 监听接口       | 添加或删除相应类型监听器的方法              |
  | ----------- | ---------------------------- | -------------- | ------------------------------------------- |
  | ActionEvent | JButton、JList、JTextField等 | ActionListener | addActionListener()、removeActionListener() |

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  public class SimpleEvent extends JFrame {
      private JButton btn = new JButton("我是按钮，单击我");
  
      private SimpleEvent() {
          setLayout(null);
          setBounds(100, 20, 200, 150);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          Container cp = getContentPane();
          cp.add(btn);
          btn.setBounds(10, 10, 150, 30);
          btn.addActionListener(new btnAction());
      }
  
      class btnAction implements ActionListener {
          // 重写 actionPerformed() 方法
          public void actionPerformed(ActionEvent arg0) {
              btn.setText("我被单击了！");
          }
      }
  
      public static void main(String[] args) {
          new SimpleEvent();
      }
  }
  ```

* 运行结果：

  ![按钮单击前](按钮单击前.jpg)

  ​																![按钮单击后](按钮单击后.jpg)

* 不使用内部类实现事件监听：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  public class SimpleEvent2 extends JFrame implements ActionListener {
      private JButton btn = new JButton("我是按钮，单击我");
  
      private SimpleEvent2() {
          setLayout(null);
          setBounds(100, 20, 200, 150);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          Container cp = getContentPane();
          cp.add(btn);
          btn.setBounds(10, 10, 150, 30);
          btn.addActionListener(this);
      }
  
      // 重写 actionPerformed() 方法
      public void actionPerformed(ActionEvent arg0) {
          btn.setText("我被单击了！");
      }
  
      public static void main(String[] args) {
          new SimpleEvent2();
      }
  }
  ```

* 运行效果同上。
* **一般情况下，为事件源做监听事件应使用匿名内部类形式。**

### 3、焦点事件监听器

* 焦点事件监听器的相关内容如下表：

  | 事件名称   | 事件源               | 监听接口      | 添加或删除相应类型监听器的方法            |
  | ---------- | -------------------- | ------------- | ----------------------------------------- |
  | FocusEvent | Component 以及派生类 | FocusListener | addFocusListener()、removeFocusListener() |

* 实例：

  ```java
  import javax.swing.*;
  import java.awt.*;
  import java.awt.event.FocusEvent;
  import java.awt.event.FocusListener;
  
  public class FocusEventTest extends JFrame {
      private FocusEventTest(){
          setLayout(null);
          setBounds(100, 20, 500, 150);
          setVisible(true);
          setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
          Container cp = getContentPane();
          JTextField jt1 = new JTextField("请单击其他文本框",10);
          JTextField jt2 = new JTextField("请单击我！",10);
          jt1.setBounds(10,10,200,30);
          jt2.setBounds(10,50,200,30);
          jt1.setVisible(true);
          jt2.setVisible(true);
          cp.add(jt1);
          cp.add(jt2);
          jt1.addFocusListener(new FocusListener() {
              @Override
              public void focusGained(FocusEvent e) {
                  jt2.setText("另外一个文本框获得了焦点");
              }
  
              @Override
              public void focusLost(FocusEvent e) {
                  jt2.setText("另外一个文本框失去了焦点");
                  JOptionPane.showMessageDialog(null,"文本框失去焦点");
              }
          });
      }
  
      public static void main(String[] args) {
          new FocusEventTest();
      }
  }
  ```

* 运行效果：

  ![](D:\编程笔记\java\焦点事件1.jpg)

  ![](D:\编程笔记\java\焦点事件2.jpg)

  ![](D:\编程笔记\java\焦点事件3.jpg)

