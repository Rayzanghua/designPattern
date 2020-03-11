package threadTest;

public class MethodValueTest {

    public static void main(String[] args) {
        final int a=1;
        new Thread(()->{
            System.out.println(a);
        }).start();

        class Run1 implements Runnable{
            @Override
            public void run() {
                System.out.println(a);
            }
        }
    }
}
