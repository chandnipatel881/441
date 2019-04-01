import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FrequentCharacterTest {

    @Test
    public void testNFreqChar() {

        String str = FrequentCharacter.nFreqChar2("gee", 3);

        assertEquals(str, "eg");
    }
}