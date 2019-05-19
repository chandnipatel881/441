import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Graph<T> {

    private int V;
    public HashMap<T, HashSet<T>> adjMap;

    public Graph(int v){
        this.V = v;
        adjMap = new HashMap<T, HashSet<T>>();
    }

    public void addEdge(T u, T v){
        if(!adjMap.containsKey(u)){
            adjMap.put(u, new HashSet());
        }
        adjMap.get(u).add(v);
    }
}
