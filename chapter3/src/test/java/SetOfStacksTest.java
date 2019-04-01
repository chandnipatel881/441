import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SetOfStacksTest {

    SetOfStacks<Integer> stack = new SetOfStacks<Integer>(3);

    @Test
    public void testPush() {
        stack.push(2);
        stack.push(5);
        stack.push(34);
        stack.push(3);

        assertEquals((int) stack.pop(), 3);
        assertEquals((int) stack.pop(), 34);
        assertEquals((int) stack.pop(), 5);

        assertEquals((int) stack.pop(), 2);
        assertNull(stack.pop());



    }
}