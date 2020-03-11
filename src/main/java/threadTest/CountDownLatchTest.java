package threadTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    static CountDownLatch downLatch=new CountDownLatch(2);
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("我进来了");
            try {
                downLatch.countDown();
                downLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我结束了");
        }).start();
        new Thread(()->{downLatch.countDown();
            System.out.println("我进来了，等我一秒");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                downLatch.countDown();
//            try {
//                downLatch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("我结束了,经过了1秒");
        }).start();
    }
}
