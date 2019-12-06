package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

/**
 * Given a BST, transform it into greater sum tree where each
 * node contains sum of all nodes greater than that node.
 * Time Complexity O(n)
 * <p>
 * Geeks For Geeks : https://www.geeksforgeeks.org/transform-bst-sum-tree/
 */

public class GreaterSumTree {

    private static int sum;

    public void greaterSumTreeFromBST(BinaryTreeNode node) {

        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.println("\nInorder Traversal of actual tree");
        binaryTreeTraversal.inOrderTraversal(node);
        System.out.println();
        greaterSumTreeFromBSTUtil(node);

        System.out.println("\nInorder Traversal of sum tree");
        binaryTreeTraversal.inOrderTraversal(node);
    }

    private static void greaterSumTreeFromBSTUtil(BinaryTreeNode node) {

        if (node == null)
            return;

        greaterSumTreeFromBSTUtil(node.getRight());
        sum = sum + node.getData();
        node.setData(sum - node.getData());
        greaterSumTreeFromBSTUtil(node.getLeft());
    }
}
