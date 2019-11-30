package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class HasPathSum {

    public boolean hasPathSum(BinaryTreeNode node, int sum, int currentSum) {
        if (node == null) {
            return false;
        }
        currentSum = currentSum + node.getData();
        if (currentSum == sum && node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return (hasPathSum(node.getLeft(), sum, currentSum) || hasPathSum(node.getRight(), sum, currentSum));
    }
}
