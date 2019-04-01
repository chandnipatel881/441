import java.util.Iterator;
import java.util.LinkedList;

public class C2Q5 {

    public static LinkedList<Integer> sumOfLists(LinkedList<Integer> list1, LinkedList<Integer> list2, boolean descening){
        if(list1 == null && list2 == null){
            return null;
        }
        Iterator<Integer> itr1 = descening ? list1.descendingIterator() : list1.listIterator();
        Iterator<Integer> itr2 = descening ? list2.descendingIterator() : list2.listIterator();
        return sumOfListsImpl(itr1, itr2);
    }

    private static LinkedList<Integer> sumOfListsImpl(Iterator<Integer> itr1, Iterator<Integer> itr2) {
        boolean carryOver = false;
        int sum;

        LinkedList<Integer> sumList = new LinkedList<Integer>();

        while(itr1.hasNext() || itr2.hasNext()){
            sum = carryOver ? 1 : 0;
            sum += itr1.hasNext() ? itr1.next() : 0;
            sum += itr2.hasNext() ? itr2.next() : 0;
            carryOver = sum >= 10;
            sumList.add(sum%10);
        }
        if(carryOver){
            sumList.add(1);
        }
        return sumList;
    }


}
