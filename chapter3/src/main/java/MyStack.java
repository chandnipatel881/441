import java.util.EmptyStackException;

public class MyStack<T>{

    private class StackNode<T> {
        T item;
        StackNode next;

        StackNode(T item) {
            this.item = item;
        }
    }
        StackNode<T> top;

        public void push(T item){
            StackNode<T> temp = new StackNode<T>(item);
            temp.next = top;
            top = temp;
        }

        public T pop(){
            if(top == null){
                throw new EmptyStackException();
            }
            T lastItem = top.item;
            top = top.next;
            return lastItem;
        }

        public boolean isEmpty(){
            return top == null;
        }

        public T peek(){
            if(top == null){
                throw new EmptyStackException();
            }
            return top.item;
        }
}

