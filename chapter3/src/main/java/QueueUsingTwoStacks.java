import java.util.Stack;

public class QueueUsingTwoStacks {

    Stack<Integer> s1 = new Stack();
    Stack<Integer> s2 = new Stack();

    public void enqueue(Integer item) {
        s1.push(item);
    }

    public int dequeue() {
        if(s1.isEmpty() && s2.isEmpty()){
            return -1;
        }
        if(s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

}