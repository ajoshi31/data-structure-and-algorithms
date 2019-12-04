package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

public class FindElementInBST {

    private boolean value;

    public void findElement(BinaryTreeNode node, int data, String type) {
        if (type.equals("RECURSIVE")) {
            value = findElementInBSTRecursively(node, data);
        }
        if (type.equals("ITERATIVE")) {
            value = findElementInBST(node, data);
        }
        if (value) {
            System.out.print("\n The number " + data + " is present in the tree");
        } else {
            System.out.print("\n The number " + data + " is not present in the tree");
        }
    }

    private boolean findElementInBST(BinaryTreeNode node, int data) {

        if (node == null) {
            return false;
        }
        while (node != null) {
            if (data == node.getData()) {
                return true;
            } else if (data > node.getData()) {
                node = node.getRight();
            } else {
                node = node.getLeft();
            }
        }
        return false;
    }

    private boolean findElementInBSTRecursively(BinaryTreeNode node, int data) {

        if (node == null) {
            return false;
        }
        if (node.getData() == data) {
            return true;
        }

        if (data > node.getData()) {
            return findElementInBSTRecursively(node.getRight(), data);
        } else {
            return findElementInBSTRecursively(node.getLeft(), data);
        }
    }
}
