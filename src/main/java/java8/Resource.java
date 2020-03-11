package java8;

/**
 *

 闲聊 synchronize(版本变化)和ReentrantLock
 多生产者多消费者
 tkmapper的bug
 volatile cas(聊聊锁) threadLocal ThreadPool
 juc：sempare countdownlatch CyclicBarrier
 线程安全集合
 并发框架 disruptor


 */



/*
生产者，消费者。

多生产者，多消费者的问题。
if判断标记，只有一次，会导致不该运行的线程运行了。出现了数据错误的情况。
while判断标记，解决了线程获取执行权后，是否要运行！

notify:只能唤醒一个线程，如果本方唤醒了本方，没有意义。而且while判断标记+notify会导致死锁。
notifyAll解决了本方线程一定会唤醒对方线程的问题。


*/

public class Resource
{
    private String name;
    private int count = 1;
    private boolean flag = false;
    public synchronized void set(String name)//
    {

        while(flag)
            try{this.wait();}catch(InterruptedException e){}//   t1    t0

        this.name = name + count;//烤鸭1  烤鸭2  烤鸭3
        count++;//2 3 4
        System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);//生产烤鸭1 生产烤鸭2 生产烤鸭3
        flag = true;
        notifyAll();
    }

    public synchronized void out()//  t3
    {
        while(!flag)
            try{this.wait();}catch(InterruptedException e){}	//t2  t3
        System.out.println(Thread.currentThread().getName()+"...消费者........"+this.name);//消费烤鸭1
        flag = false;
        notifyAll();
    }
}




class  ProducerConsumerDemo
{
    public static void main(String[] args)
    {
        Resource r = new Resource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);
        t0.start();
        t1.start();
        t2.start();
        t3.start();

    }
}


