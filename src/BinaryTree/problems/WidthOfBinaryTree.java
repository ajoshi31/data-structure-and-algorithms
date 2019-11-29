package BinaryTree.problems;


import UtilPackage.*;
import BinaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {

    private int count[] = new int[20];

    public int maxWidthOfBinaryTreeWithLevelOrder(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int maxWidth = 0;


        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

        queue.offer(node);
        while (!queue.isEmpty()) {

            int count = queue.size();
            maxWidth = Math.max(maxWidth, count);

            while (count > 0) {

                BinaryTreeNode temp = queue.poll();
                if (temp.getLeft() != null) {
                    queue.offer(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.offer(temp.getRight());
                }
                count--;
            }

        }
        return maxWidth;
    }

    public int maxWidthUsingPreOrderTraversal(BinaryTreeNode node) {
        maxWidthUsingPreOrderTraversalUtil(node, 0);
        AppUtil appUtil = new AppUtil();
        return appUtil.maxInIntegerArray(count);
    }

    private void maxWidthUsingPreOrderTraversalUtil(BinaryTreeNode node, int level) {
        if (node == null) {
            return;
        }
        count[level]++;
        maxWidthUsingPreOrderTraversalUtil(node.getLeft(), level + 1);
        maxWidthUsingPreOrderTraversalUtil(node.getRight(), level + 1);
    }

}
