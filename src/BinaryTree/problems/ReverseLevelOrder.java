package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    public void levelOrderTraversalInReverse(BinaryTreeNode node) {
        System.out.print("\n\nPrinting the reverse level order traversal\n");
        if (node == null) {
            return;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        Stack<Integer> stack = new Stack<Integer>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
            stack.push(temp.getData());
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
