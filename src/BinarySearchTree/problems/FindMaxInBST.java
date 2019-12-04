package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

public class FindMaxInBST {

    private BinaryTreeNode minNode;

    public void findMaxElement(BinaryTreeNode node, String type) {
        if (type.equals("RECURSIVE")) {
            minNode = findMaxElementInBSTRecursively(node);
        }
        if (type.equals("ITERATIVE")) {
            minNode = findMaxElementInBST(node);
        }
        if (node != null) {
            System.out.print("\n The number " + minNode.getData());
        } else {
            System.out.print("\n The number is not present");
        }

    }

    private BinaryTreeNode findMaxElementInBST(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    private BinaryTreeNode findMaxElementInBSTRecursively(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }
        if (node.getRight() == null) {
            return node;
        } else {
            return findMaxElementInBSTRecursively(node.getRight());
        }
    }
}
