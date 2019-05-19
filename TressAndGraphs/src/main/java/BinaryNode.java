public class BinaryNode<T extends Comparable<T>> implements Comparable<BinaryNode>{
    T item;
    BinaryNode left, right,parent;

    public BinaryNode(T item, BinaryNode parentPointer){
        this.item = item;
        this.parent = parentPointer;

    }

    public int compareTo(BinaryNode o){
        return this.item.compareTo((T) o.item);
    }
}
