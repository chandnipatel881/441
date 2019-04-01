import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StackWithMinElementTest {

    StackWithMinElement<Integer> mystack = new StackWithMinElement();

    @Test
    public void testPush() {

        mystack.push(5);
        mystack.push(3);
        mystack.push(3);
        mystack.push(5);

        assertEquals((int)mystack.pop(),5);
        assertEquals((int)mystack.min(),3);

        assertEquals((int)mystack.pop(),3);
        assertEquals((int)mystack.min(),3);

        assertEquals((int)mystack.pop(),3);
        assertEquals((int)mystack.min(),5);

        assertEquals((int)mystack.pop(),5);
        assertNull(mystack.min());

    }
}