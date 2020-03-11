package threadTest;

import java.util.concurrent.TimeUnit;

public class ExceptionThreadTest {
    public static void main(String[] args) {
       new Thread(()->{
           test1(0);
       }).start();
        new Thread(()->{
            test1(1);
        }).start();
    }

    public synchronized static void  test1(int i){
        System.out.println("start test1");

        try {
            if(i==0){
                throw new RuntimeException("exception");
            }
            TimeUnit.SECONDS.sleep(3);
        } catch (Exception e) {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return;
        }

        System.out.println("end test1");
    }


}
