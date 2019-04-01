import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.*;

public class C2Q4Test {

    @Test
    public void testPartitionAroundValue() {

        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.add(3);
        ll.add(5);
        ll.add(8);
        ll.add(5);
        ll.add(10);
        ll.add(2);
        ll.add(1);

        LinkedList<Integer> list = C2Q4.partitionAroundValue(5, ll);
        System.out.println(list);
    }
}