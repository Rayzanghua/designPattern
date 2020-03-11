package threadTest;

import java.util.concurrent.ConcurrentLinkedDeque;

public class QueueTest {
    public static void main(String[] args) {
        ConcurrentLinkedDeque<String> que=new ConcurrentLinkedDeque();
        System.out.println(que.peek());;
    }
}
