package Graphs;

import java.util.ArrayList;

public class Vertex {
    private String data;
    private ArrayList<Edge> outEdges, inEdges;
    public Vertex(String inputData, boolean graphIsDirected){
        this.data=inputData;
        outEdges =new ArrayList<Edge>();
        if(graphIsDirected)
            inEdges=new ArrayList<>();
        else inEdges=outEdges;
    }
    public Edge addOutEdge(Vertex endVertex){
        Edge e=new Edge(this,endVertex);
        outEdges.add(e);
        return e;
    }
    public Edge addOutEdge(Vertex endVertex, double w){
        Edge e=new Edge(this,endVertex,w);
        outEdges.add(e);
        return e;
    }

    public void addInEdge(Vertex endVertex){
        Edge e=new Edge(this,endVertex);
        inEdges.add(e);
    }
    public void addInEdge(Vertex endVertex, double w){
        Edge e=new Edge(this,endVertex,w);
        inEdges.add(e);
    }

    public void removeEdge(Vertex endVer){
        for (Edge e:this.outEdges){
            if(e.getEnd()==endVer){
                outEdges.remove(e);
                break;
            }
        }
        if(!(inEdges.equals(outEdges))){
            // be continue...
        }
    }


    public String getData(){
        return this.data;
    }
    public ArrayList<Edge> getOutEdges(){
        return this.outEdges;
    }

    public int getInDegree(){
        return inEdges.size();
    }
    public int getOutDegree(){
        return outEdges.size();
    }


    public void print(){
        String message="";
        message+=data+"-->";
        if(!outEdges.isEmpty() && outEdges.get(0).getWeight()==0)
            for(int i = 0; i< outEdges.size(); i++){
                message+= outEdges.get(i).getEnd().data+", ";
            }
        else {
            for(int i = 0; i< outEdges.size(); i++)
                message+= outEdges.get(i).getEnd().data+"("+ outEdges.get(i).getWeight()+"), ";
        }
        System.out.print(message.substring(0,message.length()-2));
        System.out.println(" || Out Degree = "+getOutDegree());

    }


    public void printIn(){
        String message="";
        message+=data+"<--";
        if(!inEdges.isEmpty() && inEdges.get(0).getWeight()==0)
            for(int i = 0; i< inEdges.size(); i++){
                message+= inEdges.get(i).getEnd().data+", ";
            }
        else {
            for(int i = 0; i< inEdges.size(); i++)
                message+= inEdges.get(i).getEnd().data+"("+ inEdges.get(i).getWeight()+"), ";
        }
        System.out.print(message.substring(0,message.length()-2));
        System.out.println(" || In Degree = "+getInDegree());
    }
    public boolean updateWeight(Vertex endVer,int w){
        int key=0;
        for (Edge e: outEdges){
            if(e.getEnd().equals(endVer)){
                e.updateWeight(w);
                //return true;
                key=1;
            }
        }
        if(!outEdges.equals(inEdges)){
            for (Edge e: inEdges){
                if(e.getEnd().equals(endVer)){
                    e.updateWeight(w);
                    key=1;
                }
            }
        }
        if(key==1)return true;
        System.out.println("Bunday yo'l yo`q");
        return false;
        }


        public Vertex opposite(Edge e){
        // yo'nalishsiz Graf uchun
        if(inEdges.equals(outEdges)){
        for (Edge e1:outEdges){
            if(e1.equals(e)){
                return e.getEnd();
            }
            if(this.equals(e.getEnd()))
                return e.getStart();
        }
        }
        // yo'nalishli Graf uchun
        else {
            for (Edge e1:outEdges){
                if(e1.equals(e)){
                    return e.getEnd();
                }
            }
        }

        return new Vertex("Bunday yo'l yo'q",true);
        }

}
