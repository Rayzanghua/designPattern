package threadTest;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        MyCallable myCallable1 = new MyCallable();
        MyCallable myCallable2 =new MyCallable();
        MyCallable myCallable3 = new MyCallable();
        Future<Boolean> submit1 = executorService.submit(myCallable1);
        Future<Boolean> submit2 = executorService.submit(myCallable2);
        Future<Boolean> submit3 = executorService.submit(myCallable3);
        if(submit1.get() && submit2.get() && submit3.get()){
            System.out.println(MyCallable.i);
            executorService.shutdown();
        }

    }
}
class MyCallable implements Callable<Boolean>{
    public static volatile AtomicInteger i=new AtomicInteger(0);
    static int k=100000;
    static Object lock=new Object();
    public volatile boolean fininsh=false;
    @Override
    public Boolean call() throws Exception {
        for(int j=0;j<k;j++){
            i.addAndGet(1);
        }
        fininsh=true;
        return fininsh;
    }
}