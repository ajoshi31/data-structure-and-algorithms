package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class MinimumDepthOfBinaryTree {
    public int minimumDepthOfTree(BinaryTreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftDepth = minimumDepthOfTree(node.getLeft()) + 1;
        int rightDepth = minimumDepthOfTree(node.getRight()) + 1;

        return (leftDepth >= rightDepth) ? rightDepth : leftDepth;
    }
}
