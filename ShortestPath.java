package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class ShortestPath {
    public static  Map<Vertex,Integer>
    shortestPathLengths(Graph g,Vertex src){
        Map<Vertex,Integer> d=new HashMap<>();
        Map<Vertex,Integer> cloud=new HashMap<>();
        AdaptablePriorityQueue pq=new AdaptablePriorityQueue();
        //PriorityQueue pq2=new PriorityQueue();

        Map<Vertex, Map<Integer,Vertex>> pqTokens;
        pqTokens=new HashMap<>();

        for (Vertex v:g.getVertices()){
            if(v==src)
                d.put(v,0);
            else
                d.put(v,Integer.MAX_VALUE);
            pqTokens.put(v, pq.insert(d.get(v),v));
        }
        while (!pq.isEmpty()) {
           Entry<Integer,Vertex> entry =(Entry<Integer, Vertex>) pq.removeMin();
            int key=entry.getKey();
            Vertex u=entry.getValue();
            cloud.put(u,key);
            pqTokens.remove(u);
            for (Edge e : u.getOutEdges()){
                Vertex v = g.opposite(u,e);
                if (cloud.get(v) == null){
                    int wgt=(int)e.getWeight();
                    if(d.get(u)+wgt<d.get(v)){
                        d.put(v,d.get(u)+wgt);
                        pq.replaceKey(pqTokens.get(v), d.get(v));  //xatosi bor


                    }
                }
            }
        }
        return cloud;
    }
}
