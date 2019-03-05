import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Dijkstra {

    public static void addEdge(int[][] graph, int src, int dest, int weight)
    {
        if(graph[src][dest] == 0) {
            graph[dest][src] = weight;
            graph[src][dest] = weight;
        } else {
            graph[dest][src] = Math.min(weight, graph[dest][src]);
            graph[src][dest] = Math.min(weight, graph[src][dest]);
        }
    }

    public static int[][] createAdjList(int[][] edges, int n){

            int[][] graph = new int[n+1][n+1];

            for(int i = 0; i < edges.length; i ++){
                int j = 0;
                addEdge(graph, edges[i][j], edges[i][j+1], edges[i][j+2]);
            }
            return graph;
    }

    private static class pqNode implements Comparable<pqNode>{
        int node;
        int distance;

        public pqNode(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }

        public int compareTo(pqNode o) {
            return this.distance - o.distance;
        }
    }

    // Complete the shortestReach function below.
    static int[] shortestReach(int n, int[][] edges, int s) {

        int[][] graph = createAdjList(edges, n);
        int[] distance = new int[n + 1];

        for(int i = 1; i < n+1 ; i++){
            if (i != s) {
                distance[i] = -1;
            }
        }
        Queue<pqNode> queue = new PriorityQueue<pqNode>();
        queue.add(new pqNode(s, 0));
        while(!queue.isEmpty()) {
            pqNode curNode = queue.poll();
            for (int i = 1; i < n + 1; i++) {
                if (graph[curNode.node][i] > 0 && (distance[i] == -1 || distance[i] > curNode.distance + graph[curNode.node][i])) {
                    queue.add(new pqNode(i, curNode.distance + graph[curNode.node][i]));
                    distance[i] = curNode.distance + graph[curNode.node][i];
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) throws IOException {

            File file1 = new File("target/classes/" + args[0]);
            Scanner scanner = new Scanner(file1);


        int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                String[] nm = scanner.nextLine().split(" ");

                int n = Integer.parseInt(nm[0]);

                int m = Integer.parseInt(nm[1]);

                int[][] edges = new int[m][3];

                for (int i = 0; i < m; i++) {
                    String[] edgesRowItems = scanner.nextLine().split(" ");
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    for (int j = 0; j < 3; j++) {
                        int edgesItem = Integer.parseInt(edgesRowItems[j]);
                        edges[i][j] = edgesItem;
                    }
                }
                int s = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                int[] result = shortestReach(n, edges, s);

                for (int i = 1; i < result.length; i++) {
                    if(i != s) {
                        System.out.print(String.valueOf(result[i]));
                    }
                    if (i != result.length - 1) {
                        System.out.print(" ");
                    }
                }
            }
            scanner.close();
        }
    }


