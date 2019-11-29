package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class DiameterOfBinaryTree {
    private int DIAMETER = 0;

    public void getDiameterOfBinaryTree(BinaryTreeNode node) {
        getHeightUtil(node, DIAMETER);
        System.out.print("\n\n Maximum Diameter of the tree is : " + DIAMETER);
    }

    private int getHeightUtil(BinaryTreeNode node, Integer maXValue) {
        if (node == null) {
            return 0;
        }
        int leftHeight = getHeightUtil(node.getLeft(), maXValue);
        int rightHeight = getHeightUtil(node.getRight(), maXValue);
        DIAMETER = Math.max(DIAMETER, leftHeight + rightHeight + 1);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
