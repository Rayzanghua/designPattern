package threadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenLockTest {



    public static void main(String[] args) {
        final ReentrantLock lock=new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(
                ()->{
                    System.out.println("t1 start");
                    lock.lock();
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("t1 end");
                }
        ).start();
        new Thread(
                ()->{
                    lock.lock();
                    System.out.println("t2 start");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {

                    }
                    condition.signal();
                    lock.unlock();
                    System.out.println("t2 end");
                }
        ).start();
    }

    private static void test1() {
        final ReentrantLock lock=new ReentrantLock();
        new Thread(
                ()->{
                    System.out.println("t1 start");
                    lock.lock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {

                    }
                    lock.unlock();
                    System.out.println("t1 end");
                }
        ).start();
        new Thread(
                ()->{
                    lock.unlock();
                    System.out.println("t2 start");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {

                    }
                    lock.unlock();
                    System.out.println("t2 end");
                }
        ).start();
    }
}
