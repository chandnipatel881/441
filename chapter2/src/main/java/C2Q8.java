import java.util.HashSet;

public class C2Q8 {

    public static int circularList(Node<Integer> head){
        if(head == null){
            return -1;
        }
        Node<Integer> currentNode = head;
        HashSet set = new HashSet();

        while(currentNode != null){
            if(set.contains(currentNode)){
                return currentNode.data;
            }
            set.add(currentNode);
            currentNode = currentNode.next;
        }
        return -1;
    }

    public static int circularList2(Node<Integer> head){
        if(head == null){
            return -1;
        }
        Node<Integer> slowRunner = head;
        Node<Integer> fastRunner = head;
        while(slowRunner != null && fastRunner != null && fastRunner.next != null){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
            if(slowRunner == fastRunner){
                return slowRunner.data;
            }
        }
        return -1;
    }
}
