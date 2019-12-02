package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class PrintAncestorOfNode {
    public void printAncestor(BinaryTreeNode root, BinaryTreeNode node) {
        if (root == null) {
            System.out.println("No such tree exist");
        }
        printAncestorUtil(root, node);

    }

    private boolean printAncestorUtil(BinaryTreeNode root, BinaryTreeNode node) {

        if (root == null) {
            return false;
        }

        if (root.getData() == node.getData())
            return true;

        if ( printAncestorUtil(root.getLeft(), node) || printAncestorUtil(root.getRight(), node)) {
            System.out.print(root.getData() + " ");
            return true;
        }
        return false;
    }

}
