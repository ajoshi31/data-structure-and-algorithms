package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

public class FindLCAInBST {

    public void findLCAInBST(BinaryTreeNode root, int a, int b) {

        BinaryTreeNode LCANode = findLCAInBSTUtil(root, a, b);
        System.out.println();
        if (LCANode == null) {
            System.out.print("Root was null");
        } else {
            System.out.print("The LCA is " + LCANode.getData());
        }
    }

    private BinaryTreeNode findLCAInBSTUtil(BinaryTreeNode root, int a, int b) {

        if (root == null) {
            return root;
        }
        if (root.getData() == a || root.getData() == b) {
            return root;
        }

        if (root.getData() > Math.max(a, b)) {
            return findLCAInBSTUtil(root.getLeft(), a, b);
        } else if (root.getData() < Math.min(a, b)) {
            return findLCAInBSTUtil(root.getLeft(), a, b);
        } else {
            return root;
        }
    }
}
