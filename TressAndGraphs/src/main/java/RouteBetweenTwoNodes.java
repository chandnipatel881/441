import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenTwoNodes {

    public static boolean isValidRoute(boolean[][] adjList, int start, int end){

        boolean[] visited = new boolean[6];

        for(int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        Queue queue = new LinkedList();
        queue.add(start);

        while(!queue.isEmpty()){
            int node = (Integer) queue.poll();
            for(int j = 0; j < adjList.length; j++){
                if(adjList[node][j] && !visited[j]){
                    if(visited[end]){
                        return true;
                    }
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        boolean[][] adjacencyList = new boolean[6][6];

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                adjacencyList[i][j] = false;
            }
        }

        adjacencyList[1][2] = true;
        adjacencyList[1][3] = true;
        adjacencyList[2][4] = true;
        adjacencyList[3][5] = true;

        System.out.println(isValidRoute(adjacencyList,3,4));
    }
}
