import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C2Q3Test {

    @Test
    public void testRemoveMiddle() {

        Node first = new Node(1, null);
        Node second = new Node(4, null);
        Node third = new Node(2, null);
        Node fourth = new Node(3, null);

        first.next = second;
        second.next = third;
        third.next = fourth;

        C2Q3.removeMiddle(second);
        assertEquals(first.toString(), "1-->2-->3-->");
    }
}