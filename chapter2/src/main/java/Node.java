
public class Node<T>{

        public T data;
        public Node next;

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

    @Override
    public String toString() {
            StringBuffer str = new StringBuffer();
            Node currentNode = this;
            while(currentNode != null) {
                str.append(currentNode.data);
                str.append("-->");
                currentNode = currentNode.next;
            }
            return str.toString();
    }
}

