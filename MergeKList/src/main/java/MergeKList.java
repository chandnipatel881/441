import java.util.LinkedList;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class MergeKList {

    private static class Dummy implements Comparable<Dummy>{
        Integer data;
        ListIterator<Integer> listIterator;

        public Dummy(Integer data, ListIterator<Integer> listIterator){
            this.data = data;
            this.listIterator = listIterator;
        }

        public int compareTo(Dummy d){
            return this.data - d.data;
        }
    }

    public static LinkedList<Integer> mergeKSortedList(LinkedList<LinkedList<Integer>> listOfLists, int k){

        PriorityQueue<Dummy> heap = new PriorityQueue<Dummy>(k);
        LinkedList<Integer> list = new LinkedList<Integer>();
        Dummy dummy = null;

        //Add first elements of each list to the heap
        for(int i = 0; i < k; i++){
            if(listOfLists.get(i) == null){
                continue;
            }
            ListIterator<Integer> listIterator = listOfLists.get(i).listIterator();
            if(listIterator.hasNext()){
                heap.add(new Dummy(listIterator.next(), listIterator));
            }
        }

        while(!heap.isEmpty()){
            //Remove min from the heap, and add it to the list
            dummy = heap.poll();
            list.add(dummy.data);

            if(dummy.listIterator.hasNext()) {
                heap.add(new Dummy(dummy.listIterator.next(), dummy.listIterator));
            }
        }

        return list;
    }

    public static void main(String[] args){

        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();

        list1.add(1);
        list1.add(4);
        list1.add(5);
        list1.add(8);

        list2.add(2);
        list2.add(3);
        list2.add(6);

        list3 = null;

        list.add(list1);
        list.add(list2);
        list.add(list3);

        System.out.println();
        list3 = mergeKSortedList(list, list.size());
        for(Integer i : list3){
            System.out.print(i);
        }
        System.out.println();

    }
}
