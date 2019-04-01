import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MyStackTest {

    MyStack mystack = new MyStack();

    @Test
    public void testPush() {
        mystack.push(2);
        mystack.push(1);
        mystack.push(3);
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.isEmpty());
        System.out.println(mystack.peek());

    }

}