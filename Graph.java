package Graphs;


import java.util.ArrayList;

public class Graph {
    private boolean isDirected=false;
    private ArrayList<Vertex> vertices;
    public Graph(){
        vertices=new ArrayList<Vertex>();
    }
    public Graph(boolean isDirected){
        this.isDirected=isDirected;
        vertices=new ArrayList<Vertex>();
    }
    public Vertex addVertex(String verName){
        Vertex newVertex=new Vertex(verName,isDirected);
        vertices.add(newVertex);
        return newVertex;
    }
    public Edge addEdge(Vertex startVer, Vertex endVer){
        Edge e=startVer.addOutEdge(endVer);
        endVer.addInEdge(startVer);
        return e;
    }
    public Edge addEdge(Vertex startVer, Vertex endVer,double w){
        Edge e=startVer.addOutEdge(endVer,w);
        endVer.addInEdge(startVer,w);
        return e;
    }
    public void removeEdge(Vertex v1,Vertex v2){
        v1.removeEdge(v2);
        v2.removeEdge(v1);
    }

    public void removeVertex(Vertex delVer){
        if(vertices.indexOf(delVer)!=-1){
            vertices.remove(delVer);
            for (Edge e:delVer.getOutEdges()){
                e.getEnd().removeEdge(delVer);

            }
        }
        else System.out.println("Grafda "+delVer.getData()+" verteks mavjud emas");
    }

public int getCountEdges(){
        int count=0;
        for (Vertex v:vertices){
            count+=v.getOutEdges().size();
        }
        if(isDirected)return count;
        return count/2;
}

    public void print(){
        System.out.println("OutBox ##########################");
        for (Vertex v:vertices){
            v.print();

        }
        System.out.println("_________________________________");
    }
    public void printIn(){
        System.out.println("InBox  ##########################");
        for (Vertex v:vertices){
            v.printIn();
        }
        System.out.println("_________________________________");
    }
public ArrayList<Vertex> getVertices(){
        return this.vertices;
}

public void updateWeight(Vertex v1, Vertex v2, int w){
        v1.updateWeight(v2,w);
        v2.updateWeight(v1,w);

}
public Vertex opposite(Vertex v,Edge e){
       return v.opposite(e);
}
    public void divideByTwo(Vertex u,Vertex v){
        for (Edge e:u.getOutEdges()){
            if(e.getEnd().equals(v)){
                removeEdge(u,v);


                Vertex newV=addVertex(u.getData()+v.getData());
                addEdge(u,newV,e.getWeight()/2);
                addEdge(v,newV,e.getWeight()/2);
                System.out.println("After divideByTwo("+u.getData()+","+v.getData()+")");
                print();
                printIn();
                break;
            }
        }
    }
    private ArrayList<Vertex> element=new ArrayList<>();
    public void path( Vertex src){
       
    }



}

