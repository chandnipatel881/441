public class PaintHouses {

    public static void paintHouses(int[][] cost, int[][] memo){
        if(cost.length == 0){
            return;
        }
        for(int n = 1; n < cost.length; n++) {
            memo[n][0] += cost[n][0] + Math.min(cost[n-1][1], cost[n-1][2]);
            memo[n][1] += cost[n][1] + Math.min(cost[n-1][0],cost[n-1][2]);
            memo[n][2] += cost[n][2] + Math.min(cost[n-1][0],cost[n-1][1]);
        }
    }

    public static void main(String[] args){

        int NUM_OF_HOUSES = 3;
        int cost[][] = new int[NUM_OF_HOUSES][3];

        cost[0][0] = 5;
        cost[0][1] = 3;
        cost[0][2] = 2;
        cost[1][0] = 1;
        cost[1][1] = 4;
        cost[1][2] = 5;
        cost[2][0] = 2;
        cost[2][1] = 3;
        cost[2][2] = 4;

        int memo[][] = new int[NUM_OF_HOUSES][3];

        paintHouses(cost, memo);

        int result = Math.min(Math.min(memo[cost.length-1][0], memo[cost.length-1][1]), memo[cost.length-1][2]);

        System.out.println(result);
    }

}
