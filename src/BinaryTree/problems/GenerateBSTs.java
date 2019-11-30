package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

import java.util.ArrayList;

public class GenerateBSTs {

    public void generateAllBSTWithGivenNodes(int n) {

        if (n == 0) {
            constructTree(1, 0);
        }
        ArrayList<BinaryTreeNode> myList = constructTree(1, n);
        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        for (BinaryTreeNode mynode : myList) {
            btt.postOrderTraversal(mynode);
            System.out.println();
        }
    }

    private ArrayList<BinaryTreeNode> constructTree(int start, int end) {
        ArrayList<BinaryTreeNode> list = new ArrayList<BinaryTreeNode>();

        if (start > end) {
            list.add(null);
            return list;
        }
        // There are n nodes
        for (int i = start; i <= end; i++) {
            ArrayList<BinaryTreeNode> leftSubTree = constructTree(start, i - 1);
            ArrayList<BinaryTreeNode> rightSubTree = constructTree(i + 1, end);
            for (BinaryTreeNode leftNode : leftSubTree) {
                for (BinaryTreeNode rightNode : rightSubTree) {
                    BinaryTreeNode addedNode = new BinaryTreeNode(i);
                    addedNode.setLeft(leftNode);
                    addedNode.setRight(rightNode);
                    list.add(addedNode);
                }
            }

        }
        return list;
    }

}


