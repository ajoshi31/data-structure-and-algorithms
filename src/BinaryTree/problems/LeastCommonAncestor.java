package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class LeastCommonAncestor {

    public void findLeastCommonAncestor(BinaryTreeNode root, Integer a, Integer b) {

        BinaryTreeNode nodeVal = findLeastCommonAncestorUtil(root, a, b);
        System.out.println("\n LCA for " + a + " and b " + b + " is:  " + nodeVal.getData());

    }

    private BinaryTreeNode findLeastCommonAncestorUtil(BinaryTreeNode node, Integer a, Integer b) {

        if (node == null) {
            return null;
        }

        // If any of the data matches with the root matches  it means any one is in path of the ancestor so return val
        if (node.getData() == a || node.getData() == b) {
            return node;
        }

        BinaryTreeNode nodeL = findLeastCommonAncestorUtil(node.getLeft(), a, b);
        BinaryTreeNode nodeR = findLeastCommonAncestorUtil(node.getRight(), a, b);

        if (nodeL != null && nodeR != null) {
            return node;
        }
        return nodeL != null ? nodeL : nodeR;
    }
}
