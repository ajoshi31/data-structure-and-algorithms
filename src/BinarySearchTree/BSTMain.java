package BinarySearchTree;

import BinarySearchTree.problems.FindElementInBST;
import BinaryTree.BinaryTreeNode;

public class BSTMain {

    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode(60);
        new InitialiseBST().initialise(root);

        FindElementInBST findElementInBST = new FindElementInBST();
        findElementInBST.findElement(root, 43, "RECURSIVE");
        findElementInBST.findElement(root, 43, "ITERATIVE");

    }
}
