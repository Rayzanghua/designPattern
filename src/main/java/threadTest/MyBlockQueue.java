package threadTest;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MyBlockQueue<E> {

    private LinkedList<E> elements;

    private int maxSize=10;

//    private AtomicInteger capacity=new AtomicInteger(0);

    private int capacity=0;

    public MyBlockQueue() {
        this.elements=new LinkedList();
    }


    public synchronized void add(E e){
        while(capacity==maxSize){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        elements.addFirst(e);
//        capacity+=1;
        this.notifyAll();
//        capacity.getAndIncrement();
    }

    public synchronized E take(){
//        capacity.getAndDecrement();
        while(capacity==0){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        E e = elements.pollLast();
//        capacity-=1;
        this.notifyAll();
        return e;
    }

    public static void main(String[] args) {
        MyBlockQueue<String> q1=new MyBlockQueue();

        new Thread(()->{
                System.out.println(q1.take());
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q1.add("s1");
        }).start();


//        new Thread(()->{
//            IntStream.range(0,20).forEach(item->{
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(q1.take());
//                System.out.println(q1.take());
//                System.out.println(q1.take());
//                System.out.println(q1.take());
//                System.out.println(q1.take());
//            });
//        }).start();
//        new Thread(()->{
////            q1.add("s1");
//            IntStream.range(0,20).forEach(item->{
//                q1.add(item+"s");
//            });
//        }).start();

    }
}
