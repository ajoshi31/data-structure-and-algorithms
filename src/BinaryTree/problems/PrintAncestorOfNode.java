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
        if (root.getLeft() == node || root.getRight() == node
                || printAncestorUtil(root.getLeft(), node) || printAncestorUtil(root.getRight(), node)) {
            System.out.println(root.getData() + " ");
            return true;
        }
        return false;
    }

    public boolean printAncestors(BinaryTreeNode node, int target)
    {
         /* base cases */
        if (node == null)
            return false;

        if (node.getData() == target)
            return true;

        /* If target is present in either left or right subtree
           of this node, then print this node */
        if (printAncestors(node.getLeft(), target)
                || printAncestors(node.getRight(), target))
        {
            System.out.print(node.getData() + " ");
            return true;
        }

        /* Else return false */
        return false;
    }
}
