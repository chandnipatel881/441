import java.util.Arrays;

public class TripleStep {

    public static int countWays(int n, int[] memo){

        if(n < 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        else if(memo[n] > -1){
            return memo[n];
        }
        else{
            memo[n] = countWays(n-1,memo) + countWays(n-2, memo)+ countWays(n-3, memo);
            return memo[n];
        }
    }

    public static void main(String[] args){

        int NUM_OF_STAIRS = 36;

        int[] array = new int[NUM_OF_STAIRS + 1];
        for(int i = 0; i < array.length; i++){
            array[i] = -1;
        }
        System.out.println(countWays(NUM_OF_STAIRS, array));
    }
}
