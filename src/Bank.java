import java.util.*;
import java.util.concurrent.locks.*;

//银行类
public class Bank{
    private final double[] accounts;
    private Lock bankLock;//锁
    private Condition sufficientFund;//余额检查 条件对象

    //构造方法
    public Bank(int n, double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
        bankLock = new ReentrantLock();
        sufficientFund = bankLock.newCondition();//条件对象与锁对应

    }

    //转账方法
    public void transfer(int from ,int to,double amount) throws InterruptedException{
        //先加锁
        bankLock.lock();

        try{
            //余额不足，这里设置条件对象
            while (accounts[from]< amount){
                sufficientFund.await();
            }
            //转账动作
            accounts[from] -= amount;
            accounts[to] += amount;
            System.out.println("transfer:"+amount);

            //重新激活因余额不足等待的线程，因为其它线程的转载动作可能会让其余额变动，只是个信号
            sufficientFund.signalAll();
        }
        finally{

            //临界区释放锁
            bankLock.lock();
        }
    }

    //获得总额方法
    public double getTotalBanlance(){

        //加锁
        bankLock.lock();

        //总额计算动作
        try {
            double sum = 0;
            for (double account : accounts)
                sum += account;
            System.out.println("银行总额:"+sum);
            return sum;
        }
        finally {
            bankLock.unlock();//释放锁
        }
    }

    //获得总额方法syschronized方式
    public synchronized double GetTotalBanlance(){
        //总额计算动作
        double sum = 0;
        for (double account : accounts)
            sum += account;
        System.out.println("银行总额:"+sum);
        return sum;
    }
    //银行的账户数方法
    public int size(){
        return this.accounts.length;
    }
}

