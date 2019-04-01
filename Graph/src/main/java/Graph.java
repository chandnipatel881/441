import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.lang.Object;

public class Graph {

    // Complete the bfs function below.
    public static void addEdge(LinkedList<Integer>[] adj, int src, int dest)
    {
        // Add an edge from src to dest.
        adj[src].add(dest);

        // Since graph is undirected, add an edge from dest
        // to src also
        adj[dest].add(src);
    }

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {

        int startNode = s;
        int visited[] = new int[n + 1];

        for(int i = 0; i < visited.length; i++){
            visited[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<Integer>();

        LinkedList<Integer> adj[] = new LinkedList[n + 1];
        for(int i = 0; i < n + 1; i++){
            adj[i] = new LinkedList<Integer>();
        }

        for(int i=0; i < m; i++){
            int j = 0;
            addEdge(adj,edges[i][j],edges[i][j+1]);
        }

        //mark s as visited
        visited[s] = 0;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int adjV = i.next();
                if(visited[adjV] != 0){
                    visited[adjV] = visited[s] + 6;
                    queue.add(adjV);
                }
            }
        }
        return visited;
    }



    public static void main(String[] args) throws IOException {

        File file1 = new File("target/classes/" + args[0]);
        Scanner scanner = new Scanner(file1);
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                if(i != 0 && i != s){
                    System.out.println(String.valueOf(result[i]));
                }
                if (i != 0 && i != s && i != result.length - 1) {
                    System.out.println(" ");
                }
            }

        }
        scanner.close();
    }
}
