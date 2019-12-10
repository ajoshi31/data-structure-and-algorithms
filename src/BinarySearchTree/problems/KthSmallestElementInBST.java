package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

public class KthSmallestElementInBST {
    public void FindKthSmallestElementInBST(BinaryTreeNode node, int key) {

        int count = 0;
        FindKthSmallestElementInBSTUtil(node, key, count);

    }

    private BinaryTreeNode FindKthSmallestElementInBSTUtil(BinaryTreeNode node, int kth, int count) {

        if (node == null) {
            return null;
        }
        BinaryTreeNode leftNode = FindKthSmallestElementInBSTUtil(node.getLeft(), kth, count);
        if (++count == kth) {
            return node;
        }

        return null;
    }
}
