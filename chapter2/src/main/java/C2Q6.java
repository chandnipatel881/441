import java.util.LinkedList;
import java.util.Stack;

public class C2Q6 {

    public static boolean isLinkedListPalindrone(Node<Character> head){
        if(head == null){
            return true;
        }
        Node currentNode = head;
        Stack stack = new Stack();

        while(currentNode != null){
            stack.push(currentNode.data);
            currentNode = currentNode.next;
        }

        Node currentNode2 = head;
        while(currentNode2 != null){
            if(stack.pop() != currentNode2.data){
                return false;
            }
            currentNode2 = currentNode2.next;
        }
        return true;
    }
}

