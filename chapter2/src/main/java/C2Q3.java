public class C2Q3 {

    public static void removeMiddle(Node middleNode){
        if (middleNode == null){
            return;
        }
        middleNode.data = middleNode.next.data;
        middleNode.next = middleNode.next.next;
    }
}
