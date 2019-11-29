package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBinaryTree {
    public int maxWidth(BinaryTreeNode node) {
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
}
