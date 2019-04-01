import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C1Q6Test {

    @Test
    public void testIsPermutationPalindrome() {

        assertTrue(C1Q6.isPermutationPalindrome("tactcoa"));
        assertFalse(C1Q6.isPermutationPalindrome("tatcoa"));


    }
}