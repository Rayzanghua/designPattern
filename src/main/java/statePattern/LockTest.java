package statePattern;

import java.util.concurrent.TimeUnit;

public class LockTest {
    private Lock1 l1=new Lock1();
    private Lock1 l2=new Lock1();
    public static void main(String[] args) {
        LockTest test=new LockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.go();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    test.go1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public static void go() throws InterruptedException {
        synchronized (LockTest.class){
            System.out.println("我进来了");
            TimeUnit.SECONDS.sleep(2);
        }
    }

    public synchronized static void go1() throws InterruptedException {
            System.out.println("我进来了");
            TimeUnit.SECONDS.sleep(2);
    }
}

class Lock1{

}