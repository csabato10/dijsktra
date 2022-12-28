package a6;
import java.util.*;
public class Main {


    public static void main(String[] args) {

        Graph test1 = new GraphImpl();
        test1.addNode("A");
        test1.addNode("B");
        test1.addNode("C");
        test1.addNode("D");
        test1.addNode("E");
        test1.addNode("F");
        test1.addNode("G");

        test1.addEdge("A", "B", 4);
        test1.addEdge("A", "C", 2);
        test1.addEdge("A", "G", 3);
        test1.addEdge("B", "D", 3);
        test1.addEdge("B", "F", 4);
        test1.addEdge("B", "G", 2);
        test1.addEdge("C", "B", 1);
        test1.addEdge("C", "G", 1);
        test1.addEdge("D", "E", 2);
        test1.addEdge("D", "F", 1);
        test1.addEdge("F", "E", 2);
        test1.addEdge("G", "D", 1);
        test1.addEdge("G", "F", 2);

        Map<String, Double> dijkstraTest = test1.dijkstra("A");
        for (String label : dijkstraTest.keySet()){
            System.out.println(label + " distance is " + dijkstraTest.get(label));
        }
    }

}
