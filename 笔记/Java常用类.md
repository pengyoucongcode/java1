# Java 常用类

---

## 一、包装类

* Java 是一种面向对象的于洋，但在 Java 中不能定义基本数据类型的对象，为了能将基本数据类型视为对象进行处理，Java 提出了包装类的概念，将常用基本数据类型封装在这些包装类中。

* Java 中的包装类及其对应的基本数据类型

  | 包装类    | 对应基本数据类型 | 包装类  | 对应基本数据类型 |
  | --------- | ---------------- | ------- | ---------------- |
  | Byte      | byte             | Short   | short            |
  | Integer   | int              | Long    | long             |
  | Float     | float            | Double  | double           |
  | Character | char             | Boolean | boolean          |

### 1、Integer 类

* 对应 int 型数据，并且提供了多个方法，实现 int 类型和 String 之间的相互转换。

#### 1.1、构造方法

* Integer 类有以下两种构造方法。

* 1）Integer(int number)

* 2）Integer(String str)

  ```java
  //方法一是讲一个 int 型变量作为参数来构造对象
  //方法二使用 String 型变量(必须为124这些数字字符）作为参数来构造对象
  //例子：
  Integer number1 = new Integer(7);
  Integer number2 = new Integer("45");
  ```

#### 1.2、常用方法

| 方法                              | 返回值  | 功能描述                                                     |
| --------------------------------- | ------- | ------------------------------------------------------------ |
| valueOf(String str)               | Integer | 返回指定的 String 值的 Integer 对象                          |
| parseInt(String str)              | int     | 返回包含在由 str 指定的字符串中的数字的等价整数值            |
| toString()                        | String  | 返回一个表示该 Integer 值的 String 对象（可以指定进制基数）  |
| toBinnaryString(int i)            | String  | 以二进制无符号整数形式返回一个整数参数的字符串表示形式       |
| toHexString(int i)                | String  | 以八进制无符号整数形式返回一个整数参数的字符串表示形式       |
| toOctalString(int i)              | String  | 以十六进制无符号整数形式返回一个整数参数的字符串表示形式     |
| equals(Object IntegerObj)         | boolean | 比较此对象与指定对象是否相等                                 |
| intValue()                        | int     | 以 int 型返回此 Integer 对象                                 |
| shortValue()                      | short   | i以 short 型返回此 Integer 对象                              |
| byteValue()\                      | byte    | 以 byte 型返回此 Integer 对象                                |
| compareTo(Integeranother Integer) | int     | 在数字上比较两个 Integer 对象。如果这两个值相等，返回0；如果调用对象的数值小于 anotherInteger 的数值，则返回负值；否则返回正值。 |

例子：

```java
public class Demo {
    public static void main(String[] args)
    {
        int num = Integer.parseInt("456");  //将字符串转为int 型
        Integer iNum = Integer.valueOf("456");  //通过构造函数创建一个Integer 对象
        System.out.println("int 数据与 Integer 对象进行比较："+iNum.equals(num));
        String str2 = Integer.toBinaryString(num); //获取数字的二进制表示
        String str3 = Integer.toOctalString(num); //获取数字的八进制表示
        String str4 = Integer.toHexString(num); //获取数字的十六进制表示
        String str5 = Integer.toString(num,15); //获取数字的十五进制表示
        System.out.println("456的二进制表示："+str2);
        System.out.println("456的八进制表示："+str3);
        System.out.println("456的十六进制表示："+str4);
        System.out.println("456的十五进制表示："+str5);
    }
}
```

#### 1.3、常量

* Integer 类提供了以下四个常量

  1）MAX_VALUE：表示 int 类型可取的最大值，即(2e31)-1

  2）MIN_VALUE：表示 int 类型可取的最小值，即（-2e31)

  3)SIZE：用来以二进制补码形式表示 int 值的位数。

  4）TYPE：表示基本类型 int 的 Class 实例。 

* 示例：

  ```java
  public class GetCon {
      public static void main(String[] args) {
          int maxint = Integer.MAX_VALUE;   //获取 Integer 类型的常量值
          int minint = Integer.MIN_VALUE;
          int intsize = Integer.SIZE;
          System.out.println("int 类型可取的最大值："+maxint);
          System.out.println("int 类型可取的最小值为："+minint);
          System.out.println("int 类型的二进制位数为："+intsize);
      }
  }
  ```

### 2、Double 类和 Float 类

* Doble 类是对基本数据类 double 的封装，Float 类是对基本数类型 float 的封装。两者的构造和使用是相似的，所以这里只记 Double 的使用。
* Double 类在对象中包装一个基本类型为 double 的值，每个 Double 类的对象都包含一个 double类型的字段。

#### 2.1构造方法
* Double 类提供了两种构造方法：
  1）Double（double value）
  2）Double（String str）
* 一个以 double 类型变量作为参数创建 Double 对象；一个以 String 型变量作为参数创建 Double 对象。
  示例：

```Java
public class GetCon {
    public static void main(String[] args) {
        Double num1 = new Double(3.14869);
        Double num2 = new Double("5.69015");
        Float num3 = new Float(7.54);
        Float num4 = new Float("8.147");
        System.out.println("num1:"+num1+'\n'+"num2:"+num2+'\n'+"num3:"+num3+'\n'+"num4:"+num4);
    }
}
//运行结果：
/*
num1:3.14869
num2:5.69015
num3:7.54
num4:8.147
 */
```

#### 2.2、常用方法

* Double 类的常用方法如下：

| 方法                  | 返回值  | 功能描述                                                     |
| :-------------------- | :-----: | :----------------------------------------------------------- |
| valueOf(String s)     | Double  | 返回保存用参数字符串 str 表示的 double 值的 Double 对象      |
| parseDouble(String s) | double  | 返回一个心得 double 值，该值被初始化为用指定的 String 表示的值，与 valueOf 相似。 |
| doubleValue()         | double  | 以 double 形式返回此 Double 对象                             |
| isNaN()               | boolean | 如果此 double 值是非数字（NaN）值，返回 True；否则返回 False |
| intValue()            |   int   | 以 int 形式返回 double 值                                    |
| byteValue()           |  byte   | 以 byte 形式返回 Double 对象值（通过强制转换）               |
| longValue()           |  long   | 以 long 形式返回此 double 的值（通过强制转换为 long 类型）   |
| compareTo(Double d)   |   int   | 对两个 Double 对象进行数值比较，如果相等则返回0，如果调用对象的值比 d 小，则返回负值，否则返回正值。 |
| equals(Object obj)    | boolean | 将此对象与指定对象进行比较                                   |
| toString()            | String  | 返回此 Double 对象的字符串表示形式                           |
| toHexString(double d) | String  | 返回 Double 参数的十六进制字符串表现形式                     |

* 例子

  ```java
  public class useDouble {
      public static void main(String[] args) {
          Double dNum = Double.valueOf("3.14159");  //通过构造函数创建一个 Double 对象
          System.out.println("3.14159 是否为非数值："+Double.isNaN(dNum.doubleValue())); //判断是否为非数值
          System.out.println("3.14159 的int值为"+dNum.intValue()); //转换为 int 类型数据
          System.out.println("值为3.14 与 4.51的比较结果："+dNum.equals(4.51));
          System.out.println("3.14159 的十六进制表示为："+Double.toHexString(dNum)); //转为十六进制
      }
  }
  
  //运行结果：
  /*
  3.14159 是否为非数值：false
  3.14159 的int值为3
  值为3.14 与 4.51的比较结果：false
  3.14159 的十六进制表示为：0x1.921f9f01b866ep1
  */
  ```


#### 2.3、常量

* Double 类提供了以下常量：

  1）MAX_EXPONENT：返回 int 值，表示标准化 double 变量可能具有的最大指数。

  2）MIN_EXPONENT：返回 int 值，表示标准化 double 变量可能具有的最小指数。

  3）NEGATIVE_INFINITY：返回 double 值，表示保存 double 类型的负无穷大值的常量。

  4）POSITIVE_INFINITY：返回 double 值，表示保存 double 类型的正无穷大值的常量。

### 3、Boolean 类

#### 3.1、构造方法

* Boolean 类型的对象同样有两种构造方法：Boolean(boolean  value) 和 Boolean(String s)

#### 3.2、常用方法

* Boolean 类常用方法如下

  | 方法                   | 返回值  | 功能描述                                                     |
  | ---------------------- | ------- | ------------------------------------------------------------ |
  | booleanValue()         | boolean | 将 Boolean 对象的值以对应的 boolean 值返回                   |
  | equals(Object obj)     | boolean | 判断调用该方法的对象与 obj 是否相等，当且仅当参数不是 null，而且与调用该方法的对象一样都表示同一个boolean 值的 Boolean 对象时，才返回 Ture |
  | parseBoolean(String s) | boolean | 将字符串参数解析为 boolean 值                                |
  | toString()             | String  | 返回表示该 boolean 值的 String 对象                          |
  | valueOf(String s)      | boolean | 返回一个用指定字符串表示值的 boolean 值。                    |


* 示例：

  ```java
  public class GetBoolean {
      public static void main(String[] args) {
          Boolean b1 = new Boolean(true);  //创建Boolean 对象
          Boolean b2 = new Boolean("ok"); //创建 Boolean 对象
          System.out.println("b1:"+b1.booleanValue());
          System.out.println("b2:"+b2.booleanValue());
      }
  }
  ```

#### 3.3、常量

* Boolean 提供了以下三个常量

  1）TRUE：对应基值 true 的 Boolean 对象

  2）FALSE：对应基值 false 的 Boolean 对象

  3）TYPE：基本类型 boolean 的 Class 对象。

### 4、Character 类

#### 4.1、构造方法

* Character 类的构造方法只有一种：Character(char value)

#### 4.2、常用方法

* Character 类的常用方法如下表：

  | 方法                                  | 返回值  | 功能描述                                               |
  | ------------------------------------- | ------- | ------------------------------------------------------ |
  | compareTo(Character anotherCharacter) | int     | 根据数字比较两个 Character 对象，若两个对象相等则返回0 |
  | equals(Object obj)                    | Boolean | 将调用该方法的对象与指定对象进行比较                   |
  | toUpperCase(char ch)                  | char    | 将字符参数转换为大写                                   |
  | toLowerCase(char ch)                  | char    | 将字符参数转换为小写                                   |
  | toString()                            | String  | 返回一个表示指定 char 值的 String 对象                 |
  | charValue()                           | char    | 返回此 Character 对象的值                              |
  | isUpperCase(char ch)                  | boolean | 判断指定字符是否是大写字符                             |
  | isLowerCase(char ch)                  | boolean | 判断指定字符是否是小写字符                             |
  | isLetter(char ch)                     | boolean | 判断指定字符是否为字母                                 |
  | isDigit(char ch)                      | boolean | 判断指定字符是否为数字                                 |

  ```java
  public class UpperOrLower {
      public static void main(String[] args) {
          Character mychar1 = new Character('A');  //声明Character对象
          Character mychar2 = new Character('a'); //声明Character对象
          if(Character.isUpperCase(mychar1)){  //判断是否为大写字母
              System.out.println(mychar1+"是大写字母");
              System.out.println("转换小写字母的结果："+Character.toLowerCase(mychar1));  //转为小写字母
          }
          if(Character.isLowerCase(mychar2)){ //判断是否为小写
              System.out.println(mychar2+"是小写字母");
              System.out.println("转换为大写字母的结果是："+Character.toUpperCase(mychar2));
          }
      }
  }
  ```

#### 4.3、常量

* Character 类提供了大量表示特定字符的常量，例如：

  1）CONNECTOR_PUNCTUATION：返回 byte 型值，表示 Unicode 规范中的常规类别“pc”。

  2）UNASSIGNED：返回 byte 型值，表示Unicode 规范中的常规类别“Cn”。

  3）TITLECASE_LETTER：返回 byte 型值，表示Unicode 规范中的常规类别“Lt”。

### 5、Number 类

* Number 类是所有数值型包装类的父类，Number 类的方法分别被各个子类所实现。

* 数值型包装类共有的方法，如下表：

  | 方法          | 返回值 | 功能描述                       |
  | ------------- | ------ | ------------------------------ |
  | byteValue()   | byte   | 以 byte 形式返回指定的数值。   |
  | intValue()    | int    | 以 int 形式返回指定的数值。    |
  | floatValue()  | float  | 以 float 形式返回指定的数值。  |
  | shortValue()  | short  | 以 short 形式返回指定的数值。  |
  | longValue()   | long   | 以 long 形式返回指定的数值。   |
  | doubleValue() | double | 以 double 形式返回指定的数值。 |

---

## 二、Math 类

### 1、Math 类概述

* Math 表示数学类，位于 java.lang 包中，由系统默认调用，该类提供了众多数学函数方法，这些方法都被定义为 static 形式，因此在程序中可以直接通过类名进行调用，语法如下：

  ```java
  Math.数学方法
  ```

* 一些常用的数学常量，也可以通过上面这种形式进行调用，例如：

  ```java
  public class test {
      public static void main(String[] args) {
          System.out.println("圆周率 π的值为："+Math.PI);
          System.out.println("自然对数底数 e 的值为："+Math.E);
      }
  }
  圆周率 π的值为：3.141592653589793
  自然对数底数 e 的值为：2.718281828459045
  ```

### 2、常用的数学运算方法

* Math 类中的常用数学运算方法可分为 4 个类别：三角函数方法、指数函数方法、取整函数方法以及最大值、最小值和绝对值函数方法。

#### 2.1、三角函数方法

* Math 类中包含的三角函数方法如下表：

  | 方法                      | 返回值 | 功能描述             |
  | ------------------------- | ------ | -------------------- |
  | sin(double  a)            | double | 返回角度的正弦值     |
  | cos(double  a)            | double | 返回角度的余弦值     |
  | tan(double  a)            | double | 返回角度的正切值     |
  | asin(double  a)           | double | 返回指定值的反正弦值 |
  | acos(double  a)           | double | 返回指定值的反余弦值 |
  | atan(double  a)           | double | 返回指定值的反正切值 |
  | toRadians(double  angdeg) | double | 将角度转化为弧度     |
  | toDegrees(double  angdeg) | double | 将弧度转化为角度     |

* 示例：

  ```java
  public class TrigonmetricFunction {
      public static void main(String[] args) {
          //取90°的正弦
          System.out.println("90 度的正弦值："+Math.sin(Math.PI/2));
          //取0°的余弦
          System.out.println("0 度的余弦值："+Math.cos(0));
          //取60°的正切
          System.out.println("60 度的正切值："+Math.tan(Math.PI/3));
          //取2的平方根与2的商的反正弦值
          System.out.println("2的平方根与2的商的反正弦值："+Math.asin(Math.sqrt(2)/2));
          //取2的平方根与2的商的反余弦值
          System.out.println("2的平方根与2的商的反余弦值："+Math.acos(Math.sqrt(2)/2));
          //取1的反正切值
          System.out.println("1的反正切值："+Math.atan(1));
          //取120°的弧度值
          System.out.println("取120°的弧度值:"+Math.toRadians(120.0));
          //π/2的角度
          System.out.println("π/2的角度值："+Math.toDegrees(Math.PI/2));
      }
  }
  90 度的正弦值：1.0
  0 度的余弦值：1.0
  60 度的正切值：1.7320508075688767
  2的平方根与2的商的反正弦值：0.7853981633974484
  2的平方根与2的商的反余弦值：0.7853981633974483
  1的反正切值：0.7853981633974483
  取120°的弧度值:2.0943951023931953
  π/2的角度值：90.0
  ```

#### 2.2、指数函数方法

* Math 类中与指数相关的函数方法如下表：

  | 方法                   | 返回值 | 功能描述                  |
  | ---------------------- | ------ | ------------------------- |
  | exp(double a)          | double | 获取e的a次方              |
  | double log(double a)   | double | 用于取自然对数，即lna的值 |
  | double log10(double a) | double | 取底数为10的对数          |
  | sqrt(double a)         | double | 用于取a的平方根           |
  | cbrt(double a)         | double | 用于取a的立方根           |
  | pow(double a,double b) | double | 用于取a的b次方            |

* 例子

  ```java
  public class ExponentFunction {
      public static void main(String[] args) {
          //取e的2次方
          System.out.println("e的平方值："+Math.exp(2));
          //取e为底2的对数
          System.out.println("e为底2的对数值:"+Math.log(2));
          //取以10为底的2的对数
          System.out.println("以10为底的2的对数值："+Math.log10(2));
          //取4的平方根
          System.out.println("4的平方根："+Math.sqrt(4));
          //取8的立方根
          System.out.println("8的立方根："+Math.cbrt(8));
          //2的2次方
          System.out.println("2的2次方："+Math.pow(2,2));
      }
  }
  e的平方值：7.38905609893065
  e为底2的对数值:0.6931471805599453
  以10为底的2的对数值：0.3010299956639812
  4的平方根：2.0
  8的立方根：2.0
  2的2次方：4.0
  ```


#### 2.3、取整函数方法

* java 中常用的取整方法如下：

  | 方法            | 返回值 | 功能描述                                                     |
  | --------------- | ------ | ------------------------------------------------------------ |
  | ceil(double a)  | double | 返回大于等于参数的最小整数                                   |
  | floor(doble a)  | double | 返回小于等于参数的最大整数                                   |
  | rint(double a)  | double | 返回与参数最接近的整数，如果两个同为整数且同样接近，则结果取偶数。 |
  | round(float a)  | double | 将参数加上0.5后返回与参数最接近的整数                        |
  | round(double a) | double | 将参数加上0.5后返回与参数最近的整数，然后强制转换为长整形。  |

* 示例：

  ```java
  public class IntFunction {
      public static void main(String[] args) {
          System.out.println("使用 ceil() 方法取整："+Math.ceil(5.2));
          System.out.println("使用 floor() 方法取整："+Math.floor(2.5));
          System.out.println("使用 rint() 方法取整："+Math.rint(2.7));
          System.out.println("使用 rint() 方法取整："+Math.rint(2.5));
          System.out.println("使用 round() 方法取整："+Math.round(3.4f));
          System.out.println("使用 round() 方法取整："+Math.round(2.5));
      }
  }
  //结果：
  使用 ceil() 方法取整：6.0
  使用 floor() 方法取整：2.0
  使用 rint() 方法取整：3.0
  使用 rint() 方法取整：2.0
  使用 round() 方法取整：3
  使用 round() 方法取整：3
  ```

#### 2.4、取最大值、最小值、绝对值函数方法

| 方法                    | 返回值 | 功能描述                               |
| ----------------------- | ------ | -------------------------------------- |
| max(double a, double b) | double | 取 a 与 b 之间的最大值                 |
| min(int a, int b)       | int    | 取 a 与 b 之间的最小值，参数为整型     |
| min(long a, long b)     | long   | 取 a 与 b 之间的最小值，参数为长整型   |
| min(float a, float b)   | float  | 取 a 与 b 之间的最小值，参数为浮点型   |
| min(double a,double b)  | double | 取 a 与 b 之间的最小值，参数为双精度型 |
| abs(int a)              | int    | 返回整形参数的绝对值                   |
| abs(long a)             | long   | 返回长整形参数的绝对值                 |
| abs(float a)            | float  | 返回浮点型参数的绝对值                 |
| abs(double a)           | double | 返回双精度型参数的绝对值               |

* 示例

  ```java
  public class AnyFunction {
      public static void main(String[] args) {
          System.out.println("4 和 8 较大者："+Math.max(4,8));
          System.out.println("5.3 和 -8.7 较小者："+Math.min(5.3,-8.7));
          System.out.println("-20 的绝对值："+Math.abs(-20));
      }
  }
  //输出：
  4 和 8 较大者：8
  5.3 和 -8.7 较小者：-8.7
  -20 的绝对值：20
  ```


### 3、随机数

#### 3.1、Math.random() 方法

* 该方法用于生成一个随机数，默认生成大于等于0.0小于等于1.0的 doubel 型随机数。

* 要生成任意范围的随机数，可做如下修改：

  ```java
  (int)(Math.Random()*n)->返回大于等于0小于等于n的随机数
  m+(int)(Math.Random()*n)->返回大于等于m小于等于m+n（不包括m+n)的随机数
  ```

* 示例，生成0~100之间的随机数

  ```java
  import java.util.Scanner;
  
  public class NumGame {
      public static void main(String[] args) {
          System.out.println("------------猜数字游戏------------\n");
          int iNum;
          int iGuess;
          Scanner in = new Scanner(System.in);  //创建扫描对象，用于输入
          iNum = (int)(Math.random()*100);
          System.out.println("请输入你猜的数字：");
          iGuess = in.nextInt(); //输入首次猜测的数字
          while((iGuess != -1) &&(iGuess != iNum) ) //判断输入的数字不是-1或者基准数
          {
              if(iGuess < iNum)
              {
                  System.out.println("太小，请重新输入：");
                  iGuess = in.nextInt();
              }
              else
              {
                  System.out.println("太大，请重新输入：");
                  iGuess = in.nextInt();
              }
          }
          if(iGuess == -1)
          {
              System.out.println("退出游戏！");
          }
          else
          {
              System.out.println("恭喜你，你赢了，猜中的数字是："+iNum);
          }
          System.out.println("\n------------游戏结束-----------------");
      }
  }
  //输出
  ------------猜数字游戏------------
  
  请输入你猜的数字：
  99
  太大，请重新输入：
  50
  太小，请重新输入：
  75
  太小，请重新输入：
  80
  太小，请重新输入：
  98
  太大，请重新输入：
  95
  太大，请重新输入：
  90
  太大，请重新输入：
  85
  太大，请重新输入：
  82
  恭喜你，你赢了，猜中的数字是：82
  
  ------------游戏结束-----------------
  ```


* 使用下面两种表达式可以生成随机字符

  ```java
  (char)('a'+Math.random()*('z'-'a'+1));
  (char)(char1+Math.random()*(char2-char1+1));
  //例子
  public class MathRandomChar {
      public static char GetRandomChar(char c1, char c2){
          return (char)(c1+Math.random()*(c2-c1+1));
      }
  
      public static void main(String[] args) {
          //获取a~z之间随机字符
          System.out.println("任意小写字符："+GetRandomChar('a','z'));
          //获取A~Z之间的随机字符
          System.out.println("任意大写字符："+GetRandomChar('A','Z'));
          //获取0~9之间的随机字符
          System.out.println("0~9的任意字符："+GetRandomChar('0','9'));
      }
  }
  //输出结果
  任意小写字符：m
  任意大写字符：R
  0~9的任意字符：5
  ```

 ## 三、Random类

* java.util.random 类，表示一个随机数生成器，可以通过实例化一个 Random 对象创建一个随机数生成器。

* 语法格式有两种：

  1）Random r = new Random();  Java 编译器以当前的系统时间作为随机数生成器的种子。

  2）Random r =new Random(seedValue);   指定随机数生成器的种子。

* Random 类中常用的获取随机数的方法：

  | 方法           | 返回值  | 功能描述                         |
  | -------------- | ------- | -------------------------------- |
  | nextInt()      | int     | 返回一个随机整数                 |
  | nextInt(int n) | int     | 返回大于等于0小于等于n的随机整数 |
  | nextLong()     | long    | 返回一个随机长整形值             |
  | nextBoolean()  | boolean | 返回一个随机布尔型值             |
  | nextFloat()    | float   | 返回一个随机浮点型值             |
  | nextDouble()   | double  | 返回一个随机双精度型值           |
  | nextGaussian() | double  | 返回一个概率为高斯分布的双精度值 |

* 例子

  ```java
  import java.util.Random;
  import java.util.Scanner;
  
  
  public class RedBag {
      public static void main(String[] args) {
          System.out.println("-------------模拟微信抢红包-----------------\n");
          Scanner sc = new Scanner(System.in); //控制台输入
          System.out.println("请输入要装入红包的总金额(元）：");
          double total = sc.nextDouble(); //输入红包总金额
          System.out.println("请输入红包个数（个）：");
          int bagsum = sc.nextInt(); //输入红包个数
          double min = 0.01; //初始化“红包的最小金额
  
          Random random = new Random();  //创建随机数对象
          for(int i=1;i<bagsum;i++)
          {
              /*
              通过本公式模拟数学中的离散模型计算一个红包可以放入的最大金额
              本次红包可用最大金额 = 可分配金额 - （红包总数-已发出的红包数）*红包的最小金额
               */
              double max = total -(bagsum-i)*min;
  
              double bound = max - min; //设置随机金额的取值范围
              /*
                  *据随机金额的取值范围，随机生成红包金额
                  * 由于 nextInt(int bound)只能用整形做参数，所以先将bound乘100
                  * 获取到一个整数后，将这个整数除100并转换成与金额相同的浮点类型
               */
              double safe = (double)random.nextInt((int)(bound*100))/100;
              double money = safe + min;  //最后加上红包的最小金额，以防safe出现零值
  
              total -= money; //更新total值
  
              System.out.println("第"+i+"个红包："+String.format("%.2f",money)+"元");
          }
          System.out.println("第"+bagsum+"个红包:"+String.format("%.2f", total)+"元");
      }
  }
  //输出
  -------------模拟微信抢红包-----------------
  
  请输入要装入红包的总金额(元）：
  20
  请输入红包个数（个）：
  10
  第1个红包：5.65元
  第2个红包：7.91元
  第3个红包：3.54元
  第4个红包：0.26元
  第5个红包：1.99元
  第6个红包：0.45元
  第7个红包：0.06元
  第8个红包：0.07元
  第9个红包：0.02元
  第10个红包:0.05元
  ```


## 四、日期时间类

### 1、Date 类

* Date 类用于表示日期时间，位于 java.util 包中。

* Date 类的构造方法如下表：

  | 构造方法        | 功能描述                                                     |
  | --------------- | ------------------------------------------------------------ |
  | Date()          | 分配 Date 对象并初始化此对象，以表示分配它的时间（精确到毫秒） |
  | Date(long date) | 分配 Date 对象并初始化此对象，以表示自从标准基准时间（1970年1月1日 00:00:00 GMT）以来的指定毫秒数。 |

* 例子：

  ```java
  long timeMills = System.currentTimerMills();
  Date date = new Date(timeMills);
  ```

* Date 类常用方法：

  | 方法               | 返回值  | 功能描述                                                     |
  | ------------------ | ------- | ------------------------------------------------------------ |
  | after(Date when)   | boolean | 测试当前日期是否在指定的日期之后                             |
  | before(Date when)  | boolean | 测试当前日期是否在指定的日期之前                             |
  | getTime()          | long    | 获得自1970年1月1日 00:00:00 GMT 开始到现在所表示的毫秒数     |
  | setTime(long time) | void    | 设置当前 Date 对象所表示的日期时间值，该值用以表示1970年1月1日 00:00:00 GMT 以后 time 毫秒的时间点 |

* 示例

  ```java
  import java.util.Date;
  public class DateTest {
      public static void main(String[] args) {
          Date date = new Date();
          long value = date.getTime();
          System.out.println("日期："+date);
          System.out.println("到现在所经历的毫秒数为："+value);
      }
  }
  日期：Mon Jun 10 15:55:36 CST 2019
  到现在所经历的毫秒数为：1560153336315
  ```

#### 1.1、DateFormat 类

* DateFormat 类是日期/时间格式化子类的抽象类，位于 java.text 包中，可以按照指定的格式格式化日期或时间。

* 格式化风格有如下几个：

  SHORT：完全为数字，如12.13.52 或3:30pm

  MEDIUM：较长，如 Jun  12  1952

  LONG：更长，如 January  12,  1952  或  3:30:32pm

  FULL：完全指定，如 Tuesday、April  12、1952 AD  或 3:30:42pm  PST

* 可以通过使用 getDateInstance 方法来创建 DateFormat 对象

  ```java
  DateFormat  df =  DateFormat.getDateInstance();
  ```

* DateFormat 类常用方法如下：

  | 方法                  | 返回值            | 功能描述                                                    |
  | --------------------- | ----------------- | ----------------------------------------------------------- |
  | format(Date date)     | String            | 将一个 Date 格式化为日期/时间格式                           |
  | getCalendar()         | Calendar          | 获取与此日期/时间格式器关联的日历                           |
  | getDateInstance()     | static DateFormat | 获取日期格式器，该格式器具有默认语言环境的默认式化风格      |
  | getDateTimeInstance() | static DateFormat | 获取日期/时间格式器，该格式器具有默认语言环境的默认式化风格 |
  | getInstance()         | static DateFormat | 获取为日期和时间使用 SHORT 风格的默认日期/时间格式器        |
  | getTimeInstace()      | static DateFormat | 获取时间格式器，该格式器具有默认语言环境的默认式化风格      |
  | parse(String  source) | Date              | 将字符串解析成一个日期，并返回这个日期的 Date 对象          |


* 示例：

```java
  import java.text.DateFormat;
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.util.Locale;
  public class DateFormatTest {
      public static void main(String[] args) {
          Date date = new Date();
          DateFormat df1 = DateFormat.getInstance();
          DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE");
          DateFormat df3 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE",Locale.CHINA);
          DateFormat df4 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss EE",Locale.US);
          DateFormat df5 = new SimpleDateFormat("yyyy-MM-dd");
          DateFormat df6 = new SimpleDateFormat("yyyy年MM月dd日");
          System.out.println("--------------将日期时间按照不同格式输出----------------");
          System.out.println("按照java默认日期格式："+df1.format(date));
          System.out.println("按照yyyy-MM-dd hh:mm:ss,系统默认区域："+df2.format(date));
          System.out.println("按照yyyy年MM月dd日 hh时mm分ss秒,区域中国："+df3.format(date));
          System.out.println("按照yyyy-MM-dd hh:mm:ss,区域美国："+df4.format(date));
          System.out.println("按照yyyy-MM-dd格式："+df5.format(date));
          System.out.println("按照yyyy年MM月dd日格式："+df6.format(date));
  
      }
  }
  按照java默认日期格式：19-6-10 下午5:57
  按照yyyy-MM-dd hh:mm:ss,系统默认区域：2019-06-10 05:57:33 星期一
  按照yyyy年MM月dd日 hh时mm分ss秒,区域中国：2019年06月10日 05时57分33秒 星期一
  按照yyyy-MM-dd hh:mm:ss,区域美国：2019-06-10 05:57:33 Mon
  按照yyyy-MM-dd格式：2019-06-10
  按照yyyy年MM月dd日格式：2019年06月10日
```

### 2、Calendar 类
* Calendar 类是一个抽象类，为特定瞬间与诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法。
* 可以通过使用 Calendar 类的 GetInstance 方法声明一个通用的 Calendar 对象。语法如下：
```java
    Calendar rightNow = Calendar.getInstance();
```
* Calendar 类常用字段名及其说明，如下表：

| 字段名    |  说明   |
| :-- | :-- |
| DATE    |  get 和 set 的字段数字，指明一个月中的某天   |
|    DAY_OF_MONTH |  get 和 set 的字段数字，指明一个月中的某天   |
|   DAY_OF_WEEK  |  get 和 set 的字段数字，指明一个星期中的某天   |
|   DAY_OF_WEEK_IN_MONTH  |   get 和 set 的字段数字，指明当前月中的第几个星期  |
|   DAY_OF_YEAR  |  get 和 set 的字段数字，指明当前年中的天数   |
|   HOUR  |   get 和 set 的字段数字，指示上午或下午的小时  |
|   HOUR_OF_DAY  |  get 和 set 的字段数字，指示一天中的小时   |
|   MILLISECOND  |  get 和 set 的字段数字，指示一秒中的毫秒   |
|   MINUTE  |  get 和 set 的字段数字，指示一小时中的分钟   |
|   MONTH  |  指示月份的get 和 set 的字段数字   |
|   SECOND  |  get 和 set 的字段数字，指示一分钟中的秒   |
|   time  |  日历的当前设置时间，以毫秒为单位，表示自格林威治标准时间1970年1月1日 0:00:00 后经过的时间   |
|   WEEK_OF_MONTH  |   get 和 set 的字段数字，指示当前月中的星期数  |
|   WEEK_OF_YEAR  |   get 和 set 的字段数字，指示当前年中的星期数  |
|   YEAR  |   指示年的get 和 set 的字段数字  |

* Calendar 类常用方法：

| 方法                     | 返回值 | 说明 |
| :----------------------- | :---- | :-- |
| add(int field,intamount) | vodi | 根据日历的规则，为给定的日历字段添加或减去指定的时间量 |
| bafter(Object  when)     | boolean | 判断此 Calendar 表示的时间是否在指定 Object 表示的时间之后，返回判断结果 |
| before(Object when) | boolean | 判断此 Calendar 表示的时间是否在指定 Object 表示的时间之前，返回判断结果 |
| get(int field) | int | 返回给定日历字段的值 |
| getInstance() | static Calendar | 使用默认时区和语言环境获得一个日历 |
| getTime() | Date | 返回一个表示此 Calendar 时间值（从历元到现在的毫秒偏移量）的Date 对象 |
| getTimeInMillis() | long            | 返回此 Calendar 的时间值，以毫秒为单位                       |
| roll(int field,boolean up) | abstract  void | 在给定的时间段上添加或减去（上/下）单个时间单元，不更改更大的字段 |
| set(int field,int value) | void | 将给定的日历字段设置为给定值 |
| set(int year,int month,int date) | void | 设置日历字段 YEAR、MONTH、 和 DAY_OF_MONTH 的值 |
| set(int year,int month,int date,int hourOfDay,int minute) | void | 设置日历字段 YEAR、MONTH、DAY_OF_MONTH、HOUR_OF_DAY 和 MINUTE 的值 |
| set(int year,int month,int date,int hourOfDay,int minute,int second) | void | 设置日历字段 YEAR、MONTH、DAY_OF_MONTH、HOUR_OF_DAY 和 MINUTE 、SECOND的值 |
| setTime(Date date) | void | 使用给定的 Date 设置此 Calendar 的时间 |
| setTimeInMillis(long millis) | void | 用给定的 long  值设置此 Calendar  的当前时间 |

* 示例：

  ```java
  import java.text.SimpleDateFormat;
  import java.util.Date;
  import java.util.Calendar;
  public class OlympicWinterGames {
      public static void main(String[] args) {
          System.out.println("冬奥会倒计时");
          Date date = new Date();
          SimpleDateFormat formate = new SimpleDateFormat("yyyy-MM-dd");
          String today = formate.format(date);
          System.out.println("今天是："+today);
          long time1 = date.getTime();
          Calendar cal = Calendar.getInstance();
          cal.set(2022,2-1,4);
          long time2 = cal.getTimeInMillis();
          long day = (time2 - time1)/(1000*60*60*24);
          System.out.println("距离2022年“北京-张家口”冬奥会还有"+day+"天");
      }
  }
  //输出结果：
  冬奥会倒计时
  今天是：2019-06-11
  距离2022年“北京-张家口”冬奥会还有969天
  ```

  