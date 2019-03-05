import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Roads {

    public static void addEdge(LinkedList<Integer>[] adj, int src, int dest)
    {
        adj[src].add(dest);
        adj[dest].add(src);
    }

    public static LinkedList<Integer>[] createAdjList(int[][] cities, int n){

        LinkedList<Integer>[] adjList = new LinkedList[n + 1];

        for(int i = 0; i < n + 1; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < cities.length; i ++){
            int j = 0;
            addEdge(adjList, cities[i][j], cities[i][j+1]);
        }
        return adjList;

    }

    public static void dfs(int clusterNum, LinkedList<Integer>[] adj, int[] visited, int s){

        Stack<Integer> stack = new Stack();

        stack.add(s);
        visited[s] = clusterNum;

        while(!stack.empty()){
            int currentNode = stack.pop();
            Iterator<Integer> itr = adj[currentNode].iterator();

            while(itr.hasNext()){
                int n = itr.next();
                if(visited[n] == 0) {
                    stack.add(n);
                    visited[n] = clusterNum;
                }
            }
        }
    }

    // Complete the roadsAndLibraries function below.
    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {

        LinkedList<Integer>[] adj = createAdjList(cities, n);
        int clusterNum = 0;
        int[] visited = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            if(visited[i] == 0){
                clusterNum++;
                dfs(clusterNum, adj, visited, i);
            }
        }
        if (c_lib < c_road){
            return (long)c_lib * n;
        }
        return (long)c_road*(n - clusterNum) + c_lib * (long)clusterNum;
    }



    public static void main(String[] args) throws IOException {
        File file1 = new File("target/classes/" + args[0]);
        Scanner scanner = new Scanner(file1);

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nmC_libC_road = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmC_libC_road[0]);

            int m = Integer.parseInt(nmC_libC_road[1]);

            int c_lib = Integer.parseInt(nmC_libC_road[2]);

            int c_road = Integer.parseInt(nmC_libC_road[3]);

            int[][] cities = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] citiesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int citiesItem = Integer.parseInt(citiesRowItems[j]);
                    cities[i][j] = citiesItem;
                }
            }

            long result = roadsAndLibraries(n, c_lib, c_road, cities);

            System.out.println(String.valueOf(result));

        }

        scanner.close();
    }
}
