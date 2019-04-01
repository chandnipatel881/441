import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C2Q2Test {

    @Test
    public void testKthToLastElement() {

        Node first = new Node(1, null);
        Node second = new Node(2, null);
        Node third = new Node(2, null);
        Node fourth = new Node(3, null);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node result = C2Q2.kthToLastElement(first,2);
        System.out.println(result);

    }
}