package a6;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
    // key: name of node. value: a5.Node object associated with name
    int edgeAmount = 0;

    public GraphImpl() {
        nodes = new HashMap<>();
    }

    public Map<String, Node> getGraph() {
        return nodes;
    }

    @Override
    public boolean addNode(String name) {
        if (nodes.get(name) != null) {
            return false;
        } else {
            Node value = new NodeImpl(name);
            nodes.put(name, value);
            return true;
        }
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (nodes.get(src) != null && nodes.get(dest) != null && weight >= 0.0) {
            if (nodes.get(src).checkEdge(dest)) {
                return false;
            } else {
                edgeAmount += 1;
                nodes.get(dest).incrementInDegree();
                return nodes.get(src).addEdge(src, dest, weight);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteNode(String name) {
        if (nodes.get(name) != null) {
            if (nodes.get(name).getDestinations() != null) {
                for (Edge item : nodes.get(name).getDestinations()) {
                    String destination = item.getDest();
                    nodes.get(destination).decrementInDegree();
                }
            }
            if (nodes.keySet() != null) {
                for (String key : nodes.keySet()) {
                    if (nodes.get(key).checkEdge(name)) {
                        deleteEdge(name, key);
                    }
                }
            }
            nodes.get(name).clear();
            nodes.remove(name);
            return true;
        }
        //Hint: Do you need to remove edges when you delete a node?

        return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean deleteEdge(String src, String dest) {
        if (nodes.get(src) != null && nodes.get(dest) != null) {
            if (nodes.get(src).checkEdge(dest)) {
                nodes.get(src).deleteEdge(dest);
                nodes.get(dest).decrementInDegree();
                edgeAmount -= 1;
                return true;
            }
        }
        return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numNodes() {
        return nodes.size();  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numEdges() {
        return edgeAmount;  //Dummy return value.  Remove when you implement!
    }


    @Override
    public Map<String, Double> dijkstra(String start) {

        Map<String, Double> shortestPaths = new HashMap<>();
        Map<String, QueueObject> allObjects = new HashMap<>();
        if (nodes == null) {
            return shortestPaths;
        }
        if (!nodes.containsKey(start)) {
            return shortestPaths;
        }

        Comparator<QueueObject> compare = (a, b) -> Double.compare(a.distance, b.distance);
        PriorityQueue<QueueObject> queue = new PriorityQueue<>(compare);

        if(nodes.keySet() != null) {
            for (String node : nodes.keySet()) {
                if (!Objects.equals(node, start)) {
                    allObjects.put(node, new QueueObject(node, Double.MAX_VALUE));
                }
                else{
                    allObjects.put(node, new QueueObject(node, 0.0));
                }
            }
        }

        queue.add(new QueueObject(start, 0));

        while (queue.size() != 0){
            QueueObject current = queue.remove();

            if (!shortestPaths.containsKey(current.label)) {

                String currentName = current.label;

                if (nodes.containsKey(currentName)) {
                    for (Edge edge : nodes.get(current.label).getDestinations()) {
                        if (edge.getDest() != null) {

                            if (!shortestPaths.containsKey(edge.getDest())) {
                                double temp = allObjects.get(currentName).distance + edge.getWeight();
                                if (allObjects.containsKey(edge.getDest())) {
                                    allObjects.get(edge.getDest()).distance = Math.min(temp, allObjects.get(edge.getDest()).distance);
                                    queue.add(new QueueObject(edge.getDest(), temp));
                                }
                            }
                        }
                    }
                }

                shortestPaths.put(current.label, current.distance);
            }
        }
        return shortestPaths;
    }
}

class QueueObject {
    String label;
    double distance;

    public QueueObject(String label, double distance) {
        this.label = label;
        this.distance = distance;
    }

    //public double getDistance(){return this.distance;}
}

