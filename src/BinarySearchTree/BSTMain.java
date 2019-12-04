package BinarySearchTree;

import BinarySearchTree.problems.FindElementInBST;
import BinarySearchTree.problems.FindLCAInBST;
import BinarySearchTree.problems.FindMaxInBST;
import BinarySearchTree.problems.FindMinInBST;
import BinaryTree.BinaryTreeNode;

public class BSTMain {

    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode(20);
        new InitialiseBST().initialise(root);

        FindElementInBST findElementInBST = new FindElementInBST();
        findElementInBST.findElement(root, 43, "RECURSIVE");
        findElementInBST.findElement(root, 43, "ITERATIVE");

        FindMinInBST findMinInBST = new FindMinInBST();
        findMinInBST.findMinElement(root, "RECURSIVE");
        findMinInBST.findMinElement(root, "ITERATIVE");

        FindMaxInBST findMaxInBST = new FindMaxInBST();
        findMaxInBST.findMaxElement(root, "RECURSIVE");
        findMaxInBST.findMaxElement(root, "ITERATIVE");

        FindLCAInBST findLCAInBST = new FindLCAInBST();
        findLCAInBST.findLCAInBST(root, 30, 43);


    }
}
