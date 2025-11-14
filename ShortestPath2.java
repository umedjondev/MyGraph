package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class ShortestPath2 {

    public  Map<Vertex,Integer>
    shortestPathLengths(Graph g,Vertex src){
        //Map<Vertex,Integer> myMap=new HashMap<>();
        Map<Vertex,Integer> cloud=new HashMap<>();
        ArrayList<Kvartet> pq=new ArrayList<>();
        //PriorityQueue pq2=new PriorityQueue();

        //Map<Vertex, Map<Integer,Vertex>> pqTokens;
        //pqTokens=new HashMap<>();

        for (Vertex v:g.getVertices()){
            if(v==src)
                pq.add(new Kvartet(v,0));
            else
                pq.add(new Kvartet(v,Integer.MAX_VALUE));
        }

        while (!pq.isEmpty()) {
            Kvartet entry =removeMin(pq);

            int key=entry.getKey();
            Vertex u=entry.getV();
            cloud.put(u,key);
           // pqTokens.remove(u);
            for (Edge e : u.getOutEdges()){
                Vertex v = g.opposite(u,e);
                if (cloud.get(v) == null){
                    int wgt=(int)e.getWeight();
                    int dictance=key+wgt;
                    if(dictance<search(pq,v).getKey()){
                        //myMap.put(v,myMap.get(u)+wgt);
                        //pq.replaceKey(pqTokens.get(v), myMap.get(v));  //xatosi bor
                        replaceKey(pq,v,dictance);

                    }
                }
            }
        }
        return cloud;
    }

    private Kvartet removeMin(ArrayList<Kvartet> pqAr){
        int min=pqAr.get(0).getKey();
        int minIndex=0;
        for (int i=0;i<pqAr.size();i++){
            if(min>pqAr.get(i).getKey()){
                min=pqAr.get(i).getKey();
                minIndex=i;
            }
        }
        return pqAr.remove(minIndex);
    }
    private Kvartet search(ArrayList<Kvartet> pqAr,Vertex v){
        for (Kvartet ent:pqAr){
            if(ent.getV().equals(v)){
                return ent;
            }
        }
        return null;
    }

    private void replaceKey(ArrayList<Kvartet> pqAr,Vertex v,int d){
        for (Kvartet ent:pqAr){
            if(ent.getV().equals(v)){
                ent.setKey(d);
            }
        }
    }
    public void printShortestPath(Graph g,Vertex src){
        Map<Vertex,Integer> distance=shortestPathLengths(g,src);
        for (Vertex v:distance.keySet()){
            System.out.print(v.getData()+" ");
            System.out.println(distance.get(v));
        }
    }
}

