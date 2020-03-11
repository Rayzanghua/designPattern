package threadTest;

import java.util.concurrent.TimeUnit;

public class MainJoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("等我2s");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我也好了");
        });
        thread.start();
        thread.join();
        System.out.println("我一下子就执行完了");
    }


}
