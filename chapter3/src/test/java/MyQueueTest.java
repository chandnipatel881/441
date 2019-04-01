import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyQueueTest {

    MyQueue myqueue = new MyQueue();

    @Test
    public void testEnqueue() {
        myqueue.enqueue(3);
        myqueue.enqueue(4);
        myqueue.enqueue(3);
        System.out.println(myqueue.peek());
        System.out.println(myqueue.dequeue());

    }
}