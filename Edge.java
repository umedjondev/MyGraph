public class Edge {

    private Vertex startV;
    private Vertex endV;
        private double weight=-1;

    public Edge(Vertex v1,Vertex v2){

    }
    public Edge(Vertex v1,Vertex v2,double w){
    }
    public Vertex getEnd(){
        return endV;
    }
    public double getWeight(){
        return weight;
    }


}
