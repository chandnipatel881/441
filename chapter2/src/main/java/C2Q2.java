public class C2Q2 {

    public static Node kthToLastElement(Node head, int k){

        if(head == null){
            return null;
        }
        Node slow = head, fast = head;

        for(int i = 0; i < k; i++){
            if(fast == null){
                return null;
            }
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
