package a6;

import java.util.LinkedList;
import java.util.List;

public interface Node {

     /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

     /**
      * @return the name of the node
      */
     String getName();

     /**
      * add a new edge to the Edge List
      */
     public boolean addEdge(String src, String dest, double weight);

     /**
      * delete edge
      */
     boolean deleteEdge(String secondString);
     boolean checkEdge(String secondNode);

     /**
      * increase inDegree
      */
     List<Edge> getDestinations();

     void incrementInDegree();
     /**
      * decrease inDegree
      */
     void decrementInDegree();
     /**
      * @return inDegree
      */
     int getInDegree();
     /**
      * clears all edges
      */
     void clear();
}
