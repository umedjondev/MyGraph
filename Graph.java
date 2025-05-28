import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    private boolean isDirected=false;

    public Graph(){
        vertices=new ArrayList<>();
    }
    public Graph(boolean k){
        isDirected=k;
        vertices=new ArrayList<>();
    }
    public Vertex addVertex(String name){
        Vertex v=new Vertex(name,isDirected);
        vertices.add(v);
        return v;
    }
    public void addEdge(Vertex v1, Vertex v2){
        v1.addEdgeOut(v2);
        if(!isDirected)
            v2.addEdgeOut(v1);
        else v2.addEdgeIn(v1);
    }
    public void addEdge(Vertex v1, Vertex v2,double w){
        v1.addEdgeOut(v2,w);
        if(!isDirected)
            v2.addEdgeOut(v1,w);
    }
    public void removeEdge(Vertex v1,Vertex v2){

    }
    public void show(){

    }
}
