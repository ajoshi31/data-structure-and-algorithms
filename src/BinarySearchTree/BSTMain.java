package BinarySearchTree;

import BinarySearchTree.problems.*;
import BinaryTree.BinaryTreeNode;

public class BSTMain {

    public static void main(String[] args) {


        BinaryTreeNode root = new BinaryTreeNode(30);
        new InitialiseBST().initialise(root);

//        FindElementInBST findElementInBST = new FindElementInBST();
//        findElementInBST.findElement(root, 43, "RECURSIVE");
//        findElementInBST.findElement(root, 43, "ITERATIVE");
//
//        FindMinInBST findMinInBST = new FindMinInBST();
//        findMinInBST.findMinElement(root, "RECURSIVE");
//        findMinInBST.findMinElement(root, "ITERATIVE");
//
//        FindMaxInBST findMaxInBST = new FindMaxInBST();
//        findMaxInBST.findMaxElement(root, "RECURSIVE");
//        findMaxInBST.findMaxElement(root, "ITERATIVE");

//        FindLCAInBST findLCAInBST = new FindLCAInBST();
//        findLCAInBST.findLCAInBST(root, 30, 43);

        GreaterSumTree greaterSumTree = new GreaterSumTree();
        greaterSumTree.greaterSumTreeFromBST(root);


    }
}
