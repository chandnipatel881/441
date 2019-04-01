import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q9Test {

    @Test
    public void testStringCompression() {

        assertEquals(C1Q9.stringCompression("aabcccccaaa"),"a2b1c5a3" );
    }
}