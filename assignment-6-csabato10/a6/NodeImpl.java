package a6;

import javax.print.DocFlavor;

import javax.print.DocFlavor;
import java.util.*;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */
    String name = "";
    private List<Edge> edgeList;

    private int inDegree = 0;

    /*Also, any node fields you want to add for the object should go in this file.  */

    public NodeImpl(String givenName){
        this.name = givenName;
        this.edgeList = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean addEdge(String src, String dest, double weight){
        if (checkEdge(dest) == false && weight >= 0.0) {
            Edge newEdge = new EdgeImpl(src, dest, weight);
            edgeList.add(newEdge);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Edge> getDestinations() {
        return edgeList;
    }

    public boolean deleteEdge(String secondString){
        if (edgeList == null){
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++){
            if (edgeList.get(i).getDest() == secondString){
                edgeList.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean checkEdge(String secondString){
        if (edgeList == null){
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++){
            if (edgeList.get(i).getSource() == name && edgeList.get(i).getDest() == secondString){
                return true;
            }
        }
        return false;
    }

    public void clear(){
        edgeList.clear();
    }

    public void incrementInDegree(){
        this.inDegree += 1;
    }

    public void decrementInDegree(){
        this.inDegree -= 1;
    }

    public int getInDegree(){
        return this.inDegree;
    }

    public void clearEdges(){this.edgeList.clear();}

}


