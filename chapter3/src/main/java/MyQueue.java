
public class MyQueue<T> {

    private class QueueNode<T> {
        T item;
        QueueNode next;

        QueueNode(T item) {
            this.item = item;
        }
    }

    QueueNode<T> front;
    QueueNode<T> last;

    public void enqueue(T item){
        QueueNode<T> temp = new QueueNode<T>(item);
        if(front == last){
            temp.next = null;
            front = last = temp;
            return;
        }
        temp.next = last;
        last = temp;
    }

    public T dequeue() {
        if (front != null) {
            T data = front.item;
            front = front.next;
            return data;
        }
        return null;
    }

    public boolean isEmpty(){
        return front == null;
    }

    public T peek(){
        if(front == null){
            return null;
        }
        return front.item;
    }
 }
