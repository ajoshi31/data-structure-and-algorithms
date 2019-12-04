package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

public class FindMinInBST {

    private BinaryTreeNode minNode;

    public void findMinElement(BinaryTreeNode node, String type) {
        if (type.equals("RECURSIVE")) {
            minNode = findMinElementInBSTRecursively(node);
        }
        if (type.equals("ITERATIVE")) {
            minNode = findMinElementInBST(node);
        }
        if (node != null) {
            System.out.print("\n The number " + minNode.getData());
        } else {
            System.out.print("\n The number is not present");
        }

    }

    private BinaryTreeNode findMinElementInBST(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private BinaryTreeNode findMinElementInBSTRecursively(BinaryTreeNode node) {

        if (node == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node;
        } else {
            return findMinElementInBSTRecursively(node.getLeft());
        }
    }
}
