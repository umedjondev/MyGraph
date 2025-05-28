import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private List<Edge> outEdge,inEdge;
    public Vertex(String name,boolean isDirected){

        this.name=name;
        outEdge=new ArrayList<>();
        if(!isDirected)inEdge=outEdge;
        else inEdge=new ArrayList<>();
    }
    public void addEdgeOut(Vertex v2){
        Edge e=new Edge(this,v2);
        outEdge.add(e);
    }
    public void addEdgeOut(Vertex v2, double w){

    }
    public void addEdgeIn(Vertex v2){
        Edge e=new Edge(this,v2);
        inEdge.add(e);
    }
    public void show(){

    }
    public void removeEdge(Vertex v2){

    }
}
