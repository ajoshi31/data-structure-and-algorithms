package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

public class SortedArrayToBST {

    public void sortedArrayToBST(int inputArray[]) {

        int n = inputArray.length;

        BinaryTreeNode root = sortedArrayToBST(inputArray, 0, n - 1);

        BinaryTreeTraversal btt = new BinaryTreeTraversal();
        btt.inOrderTraversal(root);


    }

    private BinaryTreeNode sortedArrayToBST(int A[], int start, int end) {


        if (start > end) {
            return null;
        }
        // middle item is root
        int mid = start + (end - start) / 2;

        BinaryTreeNode newNode = new BinaryTreeNode(A[mid]);
        newNode.setLeft(sortedArrayToBST(A, start, mid - 1));
        newNode.setRight(sortedArrayToBST(A, mid + 1, end));

        return newNode;
    }
}
