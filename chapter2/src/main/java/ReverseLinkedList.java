public class ReverseLinkedList {

    public static Node<Integer> reverse(Node<Integer> head){
        if(head == null){
            return null;
        }
        Node<Integer> currentNode = head;
        Node<Integer> reverse = null;

        while(currentNode!= null){
            Node<Integer> t = new Node(currentNode.data, reverse);
            reverse = t;
            currentNode = currentNode.next;

        }
        return reverse;
    }
}