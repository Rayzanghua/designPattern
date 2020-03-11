package threadTest;

import java.util.concurrent.TimeUnit;

public class VolatileTest {
    public static volatile boolean flag=true;
    public static void main(String[] args) {
        Object obj=new Object();
        new Thread(()->{
            System.out.println("我马上就修改flag了");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag=false;
            System.out.println("修改完毕");
        }).start();
        new Thread(()->{
            while (flag){
//                System.out.println(flag);
            }
            System.out.println("flag被改变了");
        }).start();
    }
}
