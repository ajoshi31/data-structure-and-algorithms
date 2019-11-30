package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

import java.util.HashMap;

public class VerticalSum {

    private HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    public void findMaxVerticalSum(BinaryTreeNode node) {
        verticalSumUtil(node, 0);
        for (int k : hashMap.keySet()) {

            System.out.print("\nk: " + k + " Sum:  " + hashMap.get(k));
        }
    }

    private void verticalSumUtil(BinaryTreeNode node, Integer position) {

        if (node != null) {
            if (node.getLeft() != null) {
                verticalSumUtil(node.getLeft(), position - 1);
            }
            if (node.getRight() != null) {
                verticalSumUtil(node.getRight(), position + 1);
            }
            int data = 0;
            if (hashMap.containsKey(position)) {
                data = hashMap.get(position);
            }
            hashMap.put(position, data + node.getData());
        }
    }

}
