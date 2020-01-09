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

    private Node<T> extractMin() {
        int size = heapArray.size();
        Node<T> endNode = heapArray.get(0);
        swap(0, size - 1);
        positionMap.remove(heapArray.get(size - 1).getKey());
        heapArray.remove(size - 1);
        // replace first with the node and heapify or sink
        sink(0, size);
        return endNode;
    }

    public void decreaseVal(T key, int newWeight) {
        int pos = positionMap.get(key);
        heapArray.get(pos).setWeight(newWeight);
        swim(pos + 1);
    }


    private void sink(int i, int N) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int min;

        if (left < N && right < N) {
            if (heapArray.get(left).getWeight() < heapArray.get(right).getWeight()) {
                min = left;
            } else {
                min = right;
            }
            if (heapArray.get(i).getWeight() < heapArray.get(min).getWeight()) {
                min = i;
            }
            if (min != i) {
                swap(min, i);
                updateMap(heapArray.get(min).getKey(), min, heapArray.get(i).getKey(), i);
                sink(min, N);
            }
        }
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
                swap(i, (i - 1) / 2);
                updateMap(currentNode.getKey(), (i - 1) / 2, parent.getKey(), i);
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void updateMap(T key1, int i1, T key2, int i2) {
        positionMap.put(key1, i1);
        positionMap.put(key2, i2);
    }

    private void swap(int x1, int x2) {
        Node<T> temp = heapArray.get(x1);
        heapArray.set(x1, heapArray.get(x2));
        heapArray.set(x2, temp);
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
        Node<String> a = heap.extractMin();
        System.out.println(a.getKey() + " - " + a.getWeight());
        heap.decreaseVal("B", -1);
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


    public void setWeight(int weight) {
        this.weight = weight;
    }

}
