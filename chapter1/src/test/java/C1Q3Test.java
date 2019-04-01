import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q3Test {

    @Test
    public void testRemoveDuplicate() {

        char[] chars = "geeksforgeek".toCharArray();
        C1Q3.removeDuplicate(chars);

        assertEquals(new String(chars), "geksfor     ");
    }

    @Test
    public void testRemoveDuplicate2() {

        char[] chars = "geeksforgeek".toCharArray();
        C1Q3.removeDuplicate2(chars);

        assertEquals(new String(chars), "geksfor     ");
    }

    @Test
    public void testRemoveDuplicate3() {

        char[] chars = "geeksforgeek".toCharArray();
        C1Q3.removeDuplicate3(chars);

        assertEquals(new String(chars), "geksfor     ");
    }
}
