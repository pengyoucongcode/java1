package 多线程;

public class PriorityTest {
    public PriorityTest() {
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++) { // 通过循环控制线程的启动次数
            Priority test1 = new Priority( "加","+" );
            test1.setPriority( Thread.MIN_PRIORITY ); // 设置优先级最低
            Priority test2 = new Priority( "减","-" );
            test2.setPriority( 3 );
            Priority test3 = new Priority( "乘","×" );
            test3.setPriority( 8 );
            Priority test4 = new Priority( "除","÷" );
            test4.setPriority( Thread.MAX_PRIORITY ); // 设置优先级最高
            // 启动线程
            test1.start();
            test2.start();
            test3.start();
            test4.start();
            System.out.println(  ); // 换行
        }
    }
}
