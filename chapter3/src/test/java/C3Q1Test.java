import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C3Q1Test {

    C3Q1 threeStacks = new C3Q1( Integer.class, 10);
    @Test
    public void testPush() {

        threeStacks.push(2,3);
        System.out.println(threeStacks.pop(3));

        threeStacks.push(1,1);
        threeStacks.push(2,1);
        System.out.println(threeStacks.pop(1));
    }
}