package threadTest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) throws InterruptedException {
        TaskRun taskRun1 = new TaskRun();
        TaskRun taskRun2 = new TaskRun();
        TaskRun taskRun3 = new TaskRun();
        taskRun1.start();
        taskRun2.start();
        taskRun3.start();

        while (true){
            TimeUnit.SECONDS.sleep(1);
            if(taskRun1.fininsh && taskRun2.fininsh && taskRun3.fininsh){
                break;
            }
        }
        System.out.println(TaskRun.i);
    }
}

class TaskRun extends Thread{

    public static volatile AtomicInteger i=new AtomicInteger(0);
//    public static int i=0;
    static int k=100000;
    static Object lock=new Object();
    public volatile boolean fininsh=false;
    @Override
    public void run() {
        for(int j=0;j<k;j++){
//            synchronized (lock){
//                i=i+1;
                i.addAndGet(1);
//            }
        }
        fininsh=true;
    }
}
