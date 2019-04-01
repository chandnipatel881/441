import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q4Test {

    @Test
    public void testIsAnagram() {

        assertTrue(C1Q4.isAnagram("abc", "bca"));
        assertFalse(C1Q4.isAnagram("abc", "ba"));
    }
}