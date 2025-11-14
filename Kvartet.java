package Graphs;

public class Kvartet {
    private Vertex v;
    private int key;
    public Kvartet(Vertex v,int key){
        this.v=v;
        this.key=key;
    }
    public Vertex getV(){
        return this.v;
    }
    public int getKey(){
        return this.key;
    }
public void setKey(int d){
        key=d;
}
}
