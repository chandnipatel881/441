import java.util.HashMap;

public class KnapSack {

    public static int knapsack(int[] weight, int[] value, int n, int W, HashMap<TempNode, Integer> memo){
        TempNode temp = new TempNode(W, n);
        if (memo.containsKey(temp)) {
            System.out.println("cache hit at: " + n + ' ' + W);
            return memo.get(temp);
        }
        if(n < 0){
            return 0;
        }
        if(weight[n] > W){
            return -1;
        }
        else{
            if (W == 3 && n == 0) {
                System.out.println("hello");
            }
            memo.put(temp, Math.max(value[n] + knapsack(weight,value,n-1, W - weight[n], memo), knapsack(weight,value,n-1,W, memo)));
            return memo.get(new TempNode(W, n));
        }
    }

    private static class TempNode {
        Integer w,n;
        public TempNode(int w, int n) {
            this.w = w;
            this.n = n;
        }
   
        @Override
        public int hashCode() {
            return w.hashCode() + n.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            TempNode o = (TempNode)obj;
            return this.w == o.w && this.n == o.n;
        }
    }

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack2(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n+1][W+1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i==0 || w==0)
                    K[i][w] = 0;
                else if (wt[i-1] <= w)
                    K[i][w] = Math.max( + K[i-1][w-wt[i-1]],  K[i-1][w]);
                else
                    K[i][w] = K[i-1][w];
                System.out.print(K[i][w] + ", ");
            }
            System.out.println();
        }

        return K[n][W];
    }


    public static void main(String[] args){

        int weight[] = {2,1,3,4};
        int value[] = {5,10,3,7};

        int capacity = 7;
        HashMap<TempNode, Integer> memo = new HashMap<TempNode, Integer>();
        TempNode n1 = new TempNode(1,2);
        TempNode n2 = new TempNode(1,2);

        System.out.println(knapsack(weight,value,value.length - 1, capacity, memo));
        System.out.println(memo.size());
//        System.out.println(knapSack2(capacity, weight,value,value.length));

    }
}
