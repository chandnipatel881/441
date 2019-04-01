import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q2Test {

    @Test
    public void testReverseString() {

        char[] chars = "chandni".toCharArray();
        char[] chars2 = "bob".toCharArray();
        char[] chars3 = null;
        char[] chars4 = "".toCharArray();


        C1Q2.reverseString(chars);
        C1Q2.reverseString(chars2);
        C1Q2.reverseString(chars3);
        C1Q2.reverseString(chars4);

        assertEquals(new String(chars), "indnahc");
        assertEquals(new String(chars2), "bob");
        assertEquals(new String(chars4), "");
        assertNull(chars3);


    }
}