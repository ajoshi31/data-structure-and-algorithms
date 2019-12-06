package BinarySearchTree;

import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

class InitialiseBST {

    void initialise(BinaryTreeNode root) {
        int[] subTreeData = {5, 10, 20, 40, 50, 60};
        for (int aData : subTreeData) {
            insertUtil(root, aData);
        }
        System.out.print("\nThe created tree is: \n");
        new BinaryTreeTraversal().inOrderTraversal(root);
        System.out.print("\n");
        System.out.print("-----------------------------");
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
