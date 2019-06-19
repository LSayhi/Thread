public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World! Main");

        //创建两个线程，线程调用start后开始运行run()，是倒着打印4，3，2，1
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();


    }
}
