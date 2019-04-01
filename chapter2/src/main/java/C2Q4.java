import java.util.LinkedList;

public class C2Q4 {

    public static LinkedList<Integer> partitionAroundValue(int value, LinkedList<Integer> ll){
        if(ll == null){
            return null;
        }
        LinkedList<Integer> leftPartition = new LinkedList<Integer>();
        LinkedList<Integer> rightPartition = new LinkedList<Integer>();

        for(int i = 0; i < ll.size(); i++){
            if(ll.get(i) < value){
                leftPartition.add(ll.get(i));
            }
            else {
                rightPartition.add(ll.get(i));
            }
        }
        leftPartition.addAll(rightPartition);
        return leftPartition;
    }
}
