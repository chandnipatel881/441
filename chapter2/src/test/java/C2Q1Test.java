import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C2Q1Test {

    @Test
    public void testRemoveDuplicate() {

        Node<Integer> first = new Node(1, null);
        Node<Integer> second = new Node(2, null);
        Node<Integer> third = new Node(2, null);
        Node<Integer> fourth = new Node(3, null);

        first.next = second;
        second.next = third;
        third.next = fourth;

        C2Q1.removeDuplicate(first);

        assertEquals(first.toString(), "1-->2-->3-->");
    }
}