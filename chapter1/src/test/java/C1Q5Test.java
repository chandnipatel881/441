import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q5Test {

    @Test
    public void testReplaceSpace() {

        char[] chars = C1Q5.replaceSpace("Hello World   ".toCharArray());
        assertEquals(chars, "Hello%20World ".toCharArray());
    }
}