import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C2Q8Test {

    @Test
    public void testCircularList() {

        Node<Integer> first = new Node(1, null);
        Node<Integer> second = new Node(2, null);
        Node<Integer> third = new Node(3, null);
        Node<Integer> fourth = new Node(4, null);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        System.out.println(C2Q8.circularList2(first));
    }
}