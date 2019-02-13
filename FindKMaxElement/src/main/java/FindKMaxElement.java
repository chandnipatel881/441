import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKMaxElement {

    public static int[] findKMaxElement(int[] arr,int k){
        if(arr == null || arr.length == 0){
            return arr;
        }

        int maxElementArray[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int i = 0;
        while(!pq.isEmpty()) {
            maxElementArray[i++] = pq.poll();
        }
        return maxElementArray;
    }

    public static void main(String[] args){

        int[] arr = {5,10,15,2,23,35,634};

        int[] result;

        result = findKMaxElement(arr, 3);

        for(int i : result){
            System.out.println(i);
        }
    }

}

