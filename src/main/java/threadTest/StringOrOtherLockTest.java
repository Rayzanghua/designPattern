package threadTest;

import java.util.concurrent.TimeUnit;

public class StringOrOtherLockTest {
//    public static  String lock="lock";
    public static Object lock=new Object();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                task();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                task();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public static void task() throws InterruptedException {
        synchronized (lock){
            TimeUnit.SECONDS.sleep(1);
            lock="new Lock";
            for(int i=0;i<5;i++){
                if(i==2){
//                    lock="new Lock";
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println("i="+i);
            }
        }
    }
}
