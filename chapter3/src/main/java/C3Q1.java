import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class C3Q1<T> {

        //implementing three stacks using one array
        T[] arr;
        int[] top;  //size of k stacks

        public C3Q1(Class<T> c, int n){
            arr = (T[]) Array.newInstance(c,n);
            top = new int[3];
            //top[0] = 0;
            //top[1] = 1;
            //top[2] = 2;
            for(int i = 0; i < top.length; i++){
                top[i] = i;
            }
          }

        public void push(T item, int stack){
            if(top[stack - 1] >= arr.length){
                    throw new StackOverflowError();
            }
            arr[top[stack -1]] = item;
            top[stack -1] += 3;

        }

        public T pop(int stack){
            if(top[stack - 1] - 3 < stack-1){
                    throw new EmptyStackException();
            }
            top[stack -1] -= 3;
            T lastElement = arr[top[stack-1]];
            return lastElement;
        }

    }

