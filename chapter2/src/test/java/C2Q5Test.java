import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class C2Q5Test {

    @Test
    public void testSumOfLists() {

        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(3);
        ll.add(5);
        ll.add(8);

        LinkedList<Integer> ll2 = new LinkedList<Integer>();
        ll.add(3);
        ll.add(5);
        ll.add(8);

        LinkedList<Integer> result = C2Q5.sumOfLists(ll,ll2,false);

        System.out.println(result);
    }
}