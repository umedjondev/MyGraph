package Graphs;

public class Edge {
    private Vertex start;
    private Vertex end;
    private double weight=-1;
        // vaznsiz graflar uchun
    public Edge(Vertex v1,Vertex v2){
       this.start=v1;
       this.end=v2;
    }
    // vaznli graflar uchun
    public Edge(Vertex v1,Vertex v2,double w){
        this.start=v1;
        this.end=v2;
        this.weight=w;
    }

    public Vertex getStart(){
        return this.start;
    }
    public Vertex getEnd(){
        return this.end;
    }
    public double getWeight(){return this.weight;}
    public void updateWeight(int w){
        if(weight>=0){weight=w;}
        else System.out.println("Vaznsiz graflar uchun bu funksiya ishlamaydi");
    }
}
