package DisjointSets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DisJointSets {

    private Map<Long, Node> disjointSetMap = new HashMap<>();

    class Node {
        // can add the id as unique here we assume data is unique
        long data;
        Node parent;
        int weight;

        @Override
        public String toString() {
            return "SetNode [data=" + data + ", parent=" + parent.data
                    + ", weight=" + weight + "]";
        }
    }

    public Node findRoot(long data) throws Exception {
        // find the node related to this data
        if (!disjointSetMap.containsKey(data)) {
            throw new Exception("The key is not valid");
        }
        return findRoot(disjointSetMap.get(data));
    }

    public Node findRoot(Node node) {
        Node parent = node.parent;
        while (node != parent) {

            // path compression of current node
            node.parent = parent.parent;

            // Update node to parent and parent to parents node
            node = parent;
            parent = node.parent;
        }
        return node;
    }

    public void makeSet(long data) {
        Node node = new Node();
        node.data = data;
        node.parent = node;
        node.weight = 1;
        disjointSetMap.put(data, node);
    }

    public boolean quickUnion(long a, long b) throws Exception {
        if (!disjointSetMap.containsKey(a) || !disjointSetMap.containsKey(b)) {
            throw new Exception("The key is not valid");
        }

        return quickUnion(disjointSetMap.get(a), disjointSetMap.get(b));
    }

    public boolean quickUnion(Node a, Node b) {
        if (!isConnected(a, b)) {
            Node rootA = findRoot(a);
            Node rootB = findRoot(b);
            if (rootA.weight >= rootB.weight) {
                rootB.parent = rootA.parent;
                rootA.weight = rootA.weight + rootB.weight;
            } else {
                rootA.parent = rootB.parent;
                rootB.weight = rootB.weight + rootA.weight;
            }
            return true;
        }
        return false;
    }


    public boolean isConnected(Node a, Node b) {
        return (findRoot(a).data == findRoot(b).data);
    }

    public void printMap(Map map) {
        for (Object objectName : map.keySet()) {
            System.out.println();
            System.out.println("data: " + objectName + " - " + map.get(objectName).toString());
        }
    }


    public static void main(String args[]) throws Exception {

        DisJointSets ds = new DisJointSets();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);


        ds.quickUnion(1, 2);
        ds.quickUnion(2, 3);
        ds.quickUnion(3, 5);
        ds.quickUnion(1, 2);
        ds.quickUnion(6, 7);

        ds.printMap(ds.disjointSetMap);
        System.out.println();
    }

}


