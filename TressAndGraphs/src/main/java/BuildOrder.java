import java.util.*;

public class BuildOrder {

    public static int NUM_OF_VERTICES = 6;

    public static ArrayList<Character> topologicalSort(Graph g){

        //Get the indegree of all nodes
        HashMap<Character, Integer> inDegreeMap = new HashMap<Character, Integer>();

        for(Object u : g.adjMap.keySet()){
            HashSet<Character> adjacentVertices = (HashSet<Character>)g.adjMap.get(u);
            Iterator<Character> iter = adjacentVertices.iterator();
            while(iter.hasNext()){
                Character o = iter.next();
                if(!inDegreeMap.containsKey((Character) u)){
                    inDegreeMap.put((Character) u, 0);
                }
                if(o == null){
                    break;
                }
                inDegreeMap.put((Character)u, inDegreeMap.get((Character)u) + 1);
            }
        }

        //count to store visited nodes
        int count = 0;

        Queue<Character> queue = new LinkedList<Character>();
        //Create a queue and enqueue all vertices with inDegree of 0
        for(Character c : inDegreeMap.keySet()){
            if(inDegreeMap.get(c) == 0){
                queue.add(c);
                count++;
            }
        }

        //Create an arraylist to store the resultant topological sort
        ArrayList<Character> list = new ArrayList<Character>();
        while(!queue.isEmpty()) {
            //Extract front of queue and add it to the list
            char visitedNode = queue.poll();
            list.add(visitedNode);

            for(Object u : g.adjMap.keySet()) {

                HashSet<Character> adjNodes = (HashSet<Character>) g.adjMap.get(u);
                Iterator<Character> iter = adjNodes.iterator();

                while (iter.hasNext()) {

                    Character c = iter.next();

                    if (c != null && c == visitedNode) {

                        inDegreeMap.put((Character)u, inDegreeMap.get(u) - 1);

                        if (inDegreeMap.get(u) == 0) {
                            queue.add((Character)u);
                            count++;
                        }
                    }
                }
            }
        }
         if(count != NUM_OF_VERTICES){
             System.out.println("There exists a cycle in the graph");
             return null;
         }
         return list;
    }

    public static void main(String[] args){
        Graph<Character> g = new Graph<Character>(NUM_OF_VERTICES);

        g.addEdge('a','f');
        g.addEdge('b','f');
        g.addEdge('c','d');
        g.addEdge('d','a');
        g.addEdge('d','b');
        g.addEdge('e',null);
        g.addEdge('f', null);

        ArrayList<Character> buildOrder = topologicalSort(g);

        for(Character c : buildOrder){
            System.out.println(c);
        }

    }

}
