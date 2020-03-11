package threadTest;


import java.math.BigDecimal;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        testTime(()->{
//          try {
//              String result = new FutureTask<>(() -> {
//                  BigDecimal sum = BigDecimal.ZERO;
//                  for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                      sum = sum.add(new BigDecimal(i));
//                  }
//                  return sum.toString();
//              }).get();
//              System.out.println(result);
//          }catch (Exception e){
//          }
//        });

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("我执行了");
                TimeUnit.SECONDS.sleep(3);
                return 0;
            }
        });
//        Executors.newCachedThreadPool().submit(task);
        System.out.println("main结束了");
        System.out.println(task.get());
//        Executors.newCachedThreadPool().shutdown();



    }

    public static void testTime(TestTask test){
        long start = System.currentTimeMillis();
        test.doTask();
        System.out.println("use time "+(System.currentTimeMillis()-start));
    }
}

interface TestTask{
    void doTask();
}