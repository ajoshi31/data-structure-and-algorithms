package BinarySearchTree.problems;


import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

import java.util.LinkedList;

public class SortedDLLToBST {

    private LinkedList<Integer> object = new LinkedList<>();


    public void sortedDLLtoBST() {
        // Adding elements to the linked list
        object.add(10);
        object.add(20);
        object.add(30);
        object.add(50);
        object.add(70);
        object.add(80);
        object.add(90);

        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        System.out.println("\nDLL TO BST");
        btt.preOrderTraversal(sortedDLLtoBST(0, object.size() - 1));

    }

    private BinaryTreeNode sortedDLLtoBST(int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        BinaryTreeNode newNode = new BinaryTreeNode(object.get(mid));
        newNode.setLeft(sortedDLLtoBST(start, mid - 1));
        newNode.setRight(sortedDLLtoBST(mid + 1, end));
        return newNode;
    }

}

