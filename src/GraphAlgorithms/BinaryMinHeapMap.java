package GraphAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Date 08/01/2020
 *
 * @author Atul Joshi
 * <p>
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 * <p>
 * We can do it with just the array list of <Node: with (weight, T (vertex (id, T value))),
 * just it make the contains
 * operation with O(n) so we use a hashmap to reduce that operation with O(1) with some extra space complexity
 */

public class BinaryMinHeapMap<T> {

    private ArrayList<Node<T>> heapArray;
    private Map<T, Integer> positionMap;

    /**
     * Constructor
     */
    private BinaryMinHeapMap() {
        this.heapArray = new ArrayList<Node<T>>();
        this.positionMap = new HashMap<>();
    }

    /**
     * Operations
     */
    private void addToHeap(int weight, T key) {
        Node<T> node = new Node<T>(weight, key);
        heapArray.add(node);
        int size = heapArray.size();
        positionMap.put(key, size - 1);
        swim(size);
    }

    public boolean containsKey(T key) {
        return positionMap.containsKey(key);
    }

    public void extractMin() {
        int size = heapArray.size();
        Node<T> endNode = heapArray.get(size - 1);
        heapArray.remove(size - 1);
        // replace first with the node and heapify or sink
    }

    /**
     * Heap Utility Functions
     */
    private void swim(int n) {
        int i = n - 1;
        while (i > 0) {
            // Get value at this node and parent node is parent is > current swap
            Node<T> currentNode = heapArray.get(i);
            Node<T> parent = heapArray.get((i - 1) / 2);
            if (parent.getWeight() > currentNode.getWeight()) {
                swap(heapArray, i, (i - 1) / 2);
                updateMap(currentNode.getKey(), parent.getKey(), i);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void updateMap(T key1, T key2, int i) {
        positionMap.put(key1, (i - 1) / 2);
        positionMap.put(key2, i);
    }

    private void swap(ArrayList<Node<T>> list, int x1, int x2) {
        Node<T> temp = list.get(x1);
        list.set(x1, list.get(x2));
        list.set(x2, temp);
    }

    private void printHeap() {
        int i = 0;
        for (Node<T> n : heapArray) {
            System.out.println(n.getWeight() + " " + n.getKey() + " at : " + i++);
        }
        System.out.println("");
    }

    private void printPositionMap() {
        System.out.println(positionMap);
    }

    public static void main(String args[]) {
        BinaryMinHeapMap<String> heap = new BinaryMinHeapMap<String>();
        heap.addToHeap(2, "B");
        heap.addToHeap(4, "C");
        heap.addToHeap(3, "A");
        heap.addToHeap(8, "D");
        heap.addToHeap(1, "E");
        heap.addToHeap(12, "F");
        heap.addToHeap(22, "G");
        heap.addToHeap(0, "H");

        heap.printHeap();
        heap.printPositionMap();
    }
}

class Node<E> {

    private int weight;
    private E key;

    Node(int weight, E key) {
        this.weight = weight;
        this.key = key;
    }

    int getWeight() {
        return weight;
    }

    public E getKey() {
        return key;
    }
}

