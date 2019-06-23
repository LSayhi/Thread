public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World! Main");

/*        // 1. 多线程第一种方法，继承Runnable接口
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();

        //2. 多线程第二种方法，继承Thread类
        ThreadDemo T1 = new ThreadDemo("Thread-3");
        T1.start();
        ThreadDemo T2 = new ThreadDemo("Thread-4");
        T2.start();*/

        //3.锁与条件对象 BankTest
        Bank bank = new Bank(10,1111);

        //4.synchronized关键字

    }
}
