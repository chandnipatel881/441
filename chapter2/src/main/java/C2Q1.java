import java.util.HashSet;

public class C2Q1 {

    public static void removeDuplicate(Node<Integer> head){

        HashSet set = new HashSet();

        Node currentNode = head;
        Node prevNode = null;
        while(currentNode != null){
            if(!set.contains(currentNode.data)){
                set.add(currentNode.data);
                prevNode = currentNode;
            }
            else{
                prevNode.next = currentNode.next;
            }
            currentNode = currentNode.next;
        }
    }
}
