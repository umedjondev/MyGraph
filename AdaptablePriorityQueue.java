package Graphs;

import java.util.*;

public class AdaptablePriorityQueue{
    private List<Integer> keyArr,keyArrCopy;
    private Vertex v;
   private Map<Integer,Vertex> aPQ;

    public AdaptablePriorityQueue(){
         aPQ=new HashMap<>();
         keyArr =new ArrayList<>();
         keyArrCopy =new ArrayList<>();

    }
    public Map<Integer,Vertex> insert(int key, Vertex v){
        aPQ.put(key,v);
        keyArr.add(key);
        return aPQ;

    }

    public Map <Integer,Vertex> removeMin(){
        // listdan nusxa olish
        keyArrCopy=keyArr.subList(0,keyArr.size()-1);
        // sortirovka
        Collections.sort(keyArr);
        // eng kinchik key ga mos Vertexni o'chirish
        aPQ.remove(keyArrCopy.get(0));

      //int minKey= Arrays.stream(aPQ.keySet().toArray()).sorted()[0];
        return aPQ;

    }

    public boolean isEmpty(){
        return aPQ.isEmpty();

    }

    public void replaceKey(Map<Integer,Vertex> pq,int key){
        aPQ.replace(key,pq.get(key));
    }

}
