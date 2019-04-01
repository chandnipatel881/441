import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> origStack){

        Stack<Integer> tmpStack = new Stack<Integer>();

        while(!origStack.isEmpty()){
            Integer temp = origStack.pop();
            while(!tmpStack.isEmpty() && tmpStack.peek() > temp){
                    origStack.push(tmpStack.pop());
                }
            tmpStack.push(temp);
        }
        return tmpStack;
    }

    public static void main(String args[])
    {
        Stack<Integer> input = new Stack<Integer>();
        input.add(34);
        input.add(3);
        input.add(31);
        input.add(98);
        input.add(92);
        input.add(23);

        // This is the temporary stack
        Stack<Integer> tmpStack=sortStack(input);
        System.out.println("Sorted numbers are:");

        while (!tmpStack.empty())
        {
            System.out.print(tmpStack.pop()+" ");
        }
    }
}
