import java.util.EmptyStackException;

public class StackWithMinElement<T extends Comparable<T>> {

    private class StackNode<T extends Comparable<T>> implements Comparable<StackNode> {
        T item;
        StackNode next;
        StackNode nextMin;

        StackNode(T item, StackNode nextMin ) {
            this.item = item;
            this.nextMin = nextMin;
        }

        public int compareTo(StackNode o) {
            return this.item.compareTo((T) o.item);
        }
    }

    StackNode<T> top;
    StackNode<T> min;

    public void push(T item){
        StackNode<T> t = new StackNode(item,null);
        if(min == null){
            min = t;
        }
        else if(min.item.compareTo(item) >= 0){
            t.nextMin = min;
            min = t;
        }
        t.next = top;
        top = t;

    }

    public T pop(){
        if(top == null){
            throw new EmptyStackException();
        }
        if(top.compareTo(min) == 0) {
            min = top.nextMin;
        }
        T lastItem = top.item;
        top = top.next;
        return lastItem;

    }

    public T min(){
        if(min == null){
            return null;
        }
        return min.item;
    }


}
