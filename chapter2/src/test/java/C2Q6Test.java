import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class C2Q6Test {

    @Test
    public void testIsLinkedListPalindrone() {

        Node<Character> first = new Node('a', null);
        Node<Character> second = new Node('b', null);
        Node<Character> third = new Node('a', null);
        //Node<Character> fourth = new Node('a', null);

        first.next = second;
        second.next = third;
        //third.next = fourth;

        assertTrue(C2Q6.isLinkedListPalindrone(first));
    }
}