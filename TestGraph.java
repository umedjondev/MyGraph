public class TestGraph {
    public static void main(String[] args) {
        Graph g=new Graph();
        Vertex verA=g.addVertex("A");
        Vertex verB=g.addVertex("B");
        Vertex verC=g.addVertex("C");
        Vertex verD=g.addVertex("D");

       g.addEdge(verA,verB,1);  //e1
        g.addEdge(verA,verD,2);  //e2
        g.addEdge(verB,verC,3);  //e3
        g.addEdge(verB,verD,4);  //e4

        //g.removeEdge(verA,verB);

        g.show();
    }
}
