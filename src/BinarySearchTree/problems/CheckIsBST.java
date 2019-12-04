package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

/**
 *
 */
public class CheckIsBST {

    // check max in left subtree and min in left sub tree if the data is between its valid BST
    // Track with min and max passed on to the tree
    // This approach will increase complexity so we can use inorder traversal

    void isBST(BinaryTreeNode root) {
        isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(BinaryTreeNode node, int min, int max) {
        /* an empty tree is BST */
        return node == null ||
                node.getData() > min &&
                        node.getData() < max &&
                        (isBSTUtil(node.getLeft(), min, node.getData())) &&
                        (isBSTUtil(node.getRight(), node.getData(), max));

    }

    void isBSTUsingPreOrderTraversal(BinaryTreeNode root) {
        isBSTPreOrderUtil(root);
    }

    private int prev = Integer.MIN_VALUE;

    boolean isBSTPreOrderUtil(BinaryTreeNode node) {

        if (node == null) {
            return true;
        }

        if (!isBSTPreOrderUtil(node.getLeft())) {
            return false;
        }
        if (node.getData() < prev) {
            return false;
        }
        prev = node.getData();

        return isBSTPreOrderUtil(node.getRight());
    }

}
