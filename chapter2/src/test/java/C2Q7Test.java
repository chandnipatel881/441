import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C2Q7Test {

    @Test
    public void testIntersectingNode() {

        Node<Integer> first = new Node(1, null);
        Node<Integer> second = new Node(2, null);
        Node<Integer> third = new Node(2, null);
        Node<Integer> fourth = new Node(3, null);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Node<Integer> fifth = third;

        Node<Integer> result = C2Q7.intersectingNode(first, fifth);
        System.out.println(result.toString());
    }
}