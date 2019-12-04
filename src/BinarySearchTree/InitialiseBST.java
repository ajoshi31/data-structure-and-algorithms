package BinarySearchTree;

import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

class InitialiseBST {

    void initialise(BinaryTreeNode root) {
        int[] subTreeData = {40,30,10,75,65, 5, 45};
        for (int aData : subTreeData) {
            insertUtil(root, aData);
        }
        new BinaryTreeTraversal().inOrderTraversal(root);
    }

    private BinaryTreeNode insertUtil(BinaryTreeNode root, int data) {
        if (root == null) {
            root = new BinaryTreeNode(data);
            return root;
        }
        if (data > root.getData()) {
            root.setRight(insertUtil(root.getRight(), data));
        } else if (data < root.getData()) {
            root.setLeft(insertUtil(root.getLeft(), data));
        }
        return root;
    }
}
