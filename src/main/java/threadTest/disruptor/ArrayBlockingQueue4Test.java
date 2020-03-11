package threadTest.disruptor;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueue4Test {
    //ArrayBlockingQueue costTime = 11949ms
    public static void main(String[] args) {
        final ArrayBlockingQueue<Data> queue = new ArrayBlockingQueue<>(100000000);
        final long startTime = System.currentTimeMillis();
        // 向容器中添加元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                long i = 0;
                while(i < Constants.EVENT_NUM_FM) {
                    try {
                        queue.put(new Data(i, "c"+i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        }).start();
        // 从容器中取出元素
        new Thread(new Runnable() {
            @Override
            public void run() {
                long k = 0;
                while (k < Constants.EVENT_NUM_FM) {
                    try {
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    k++;
                }
                long endTime = System.currentTimeMillis();
                System.out.println("ArrayBlockingQueue costTime = " + (endTime - startTime) + "ms");
            }
        }).start();
    }
}
