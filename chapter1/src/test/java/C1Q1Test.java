import static org.testng.Assert.*;

public class C1Q1Test {

    @org.testng.annotations.Test
    public void testIsUnqiue() {

        assertFalse(C1Q1.isUnique("Chandni"));
        assertTrue(C1Q1.isUnique(null));
        assertTrue(C1Q1.isUnique(" "));
        assertTrue(C1Q1.isUnique("Gaurng"));
    }

    @org.testng.annotations.Test
    public void testIsUnqiue2() {

        assertFalse(C1Q1.isUnique2("Chandni"));
        assertTrue(C1Q1.isUnique2(null));
        assertTrue(C1Q1.isUnique2(" "));
        assertTrue(C1Q1.isUnique2("Gaurng"));
    }

    @org.testng.annotations.Test
    public void testIsUnqiue3() {

        assertFalse(C1Q1.isUnique3("Chandni"));
        assertTrue(C1Q1.isUnique3(null));
        assertTrue(C1Q1.isUnique3(" "));
        assertTrue(C1Q1.isUnique3("Gaurng"));
    }

    @org.testng.annotations.Test
    public void testIsUnqiue4() {

        assertFalse(C1Q1.isUnique4("Chandni"));
        assertTrue(C1Q1.isUnique4(null));
        assertTrue(C1Q1.isUnique4(" "));
        assertTrue(C1Q1.isUnique4("gaurn"));
    }

}