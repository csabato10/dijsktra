package a6;

public class EdgeImpl implements Edge {
    /* You will include the implementations for any edge methods you need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    private String source;
    /*Also, any edge fields you want to add for the object should go in this file.  */
    private String destination;
    double weight;

    public EdgeImpl(String src, String dest, double amount){
        this.source = src;
        this.destination = dest;
        this.weight = amount;
    }
    public String getSource() { return this.source; }
    public String getDest(){ return this.destination; }

    public double getWeight(){
        return this.weight;
    }

}
