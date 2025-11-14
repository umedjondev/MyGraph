package Graphs;

public class TestGraph {
    public static void main(String[] args) {
        Graph g=new Graph(false);
        Vertex verA=g.addVertex("A");
        Vertex verB=g.addVertex("B");
        Vertex verC=g.addVertex("C");
        Vertex verD=g.addVertex("D");
        Vertex verE=g.addVertex("E");
        Vertex verF=g.addVertex("F");


        Edge e1=g.addEdge(verA,verD,9); //e1
        Edge e2=g.addEdge(verA,verC,3); //e2
        Edge e3=g.addEdge(verA,verF,1); //e3
        Edge e4=g.addEdge(verE,verA,10); //e4
        Edge e5=g.addEdge(verB,verD,1); //e5
        Edge e6=g.addEdge(verC,verB,4); //e6
        Edge e7=g.addEdge(verC,verE,8); //e7
        Edge e8=g.addEdge(verC,verF,5); //e8

        ShortestPath2 sh2=new ShortestPath2();
        sh2.printShortestPath(g,verA);
        //g.updateWeight(verA,verD,10);

        g.print();

        g.printIn();


        //System.out.println(g.getCountEdges());
        //System.out.println(g.opposite(verC,e2).getData());

        //g.divideByTwo(verA,verC);
        g.path(verA);





    }

}
