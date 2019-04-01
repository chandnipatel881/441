import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q8Test {

    @Test
    public void testIsOneEditAway() {

        assertTrue(C1Q8.isOneEditAway("pale", "ple"));
        assertTrue(C1Q8.isOneEditAway("pales", "pale"));
        assertTrue(C1Q8.isOneEditAway("pale", "bale"));
        assertFalse(C1Q8.isOneEditAway("pale", "bake"));

    }
}