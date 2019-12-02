package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class BuildTreeFromPreOrder {

    public BinaryTreeNode buildTreeFromPreOrder(char arr[], int i) {

        if (arr.length == i) {
            return null;
        }
        // This is check

        BinaryTreeNode node = new BinaryTreeNode(arr[i]);

        if (arr[i] == 'L') {
            return node;
        }
        i++;
        node.setLeft(buildTreeFromPreOrder(arr, i));
        i++;
        node.setRight(buildTreeFromPreOrder(arr, i));
        return node;
    }

}
