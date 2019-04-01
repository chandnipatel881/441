import java.util.HashMap;
import java.util.HashSet;

public class C2Q7 {

    public static Node<Integer> intersectingNode(Node<Integer> head1, Node<Integer> head2){
        if(head1 == null && head2 == null){
            return null;
        }
        Node<Integer> currentNode1 = head1;
        Node<Integer> currentNode2 = head2;

        HashSet set = new HashSet();
        while(currentNode1 != null){
            set.add(currentNode1);
            currentNode1 = currentNode1.next;
        }
        while(currentNode2 != null){
            if(set.contains(currentNode2)){
                return currentNode2;
            }
            currentNode2 = currentNode2.next;
        }
        return null;
    }
}
