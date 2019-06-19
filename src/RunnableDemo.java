//通过Runnable接口创建线程
public class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    //构造函数
    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    //重写Run
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    //重写start,加上打印信息，为了对比
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}


