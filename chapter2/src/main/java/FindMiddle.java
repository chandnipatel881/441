public class FindMiddle {

    public static Node<Integer> findMiddleOfTheList(Node<Integer> head){
        if(head == null){
            return null;
        }
        Node<Integer> slowRunner = head;
        Node<Integer> fastRunner = head;

        while(fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }
        return slowRunner;
    }
}
