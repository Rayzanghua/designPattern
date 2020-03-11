package threadTest;

import java.util.concurrent.TimeUnit;

public class WaitTest {

    public static final Object lock=new Object();

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"我进来了");
                System.out.println(Thread.currentThread().getName()+"我准备释放了");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"我结束了");
            }
        }).start();
        new Thread(()->{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName()+"我进来了");
                System.out.println(Thread.currentThread().getName()+"我结束了");
                lock.notify();
            }
        }).start();
    }
}
