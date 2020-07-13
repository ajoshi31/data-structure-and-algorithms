package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class NonRecursiveBinaryTreeTraversal {
    void preOrderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        if (node == null) {
            return;
        }
        stack.push(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode temp = stack.pop();
            System.out.print(temp.getData() + " ");
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
    }

    void inOrderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode currentNode = node;
        Boolean flag = true;
        while (flag) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            } else {
                if (stack.isEmpty()) {
                    flag = false;
                } else {
                    currentNode = stack.pop();
                    System.out.print(currentNode.getData() + " ");
                    currentNode = currentNode.getRight();
                }
            }
        }
    }

    void postOrderTraversal(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        stack.push(node);
        BinaryTreeNode prev = null;
        while (!stack.isEmpty()) {
            BinaryTreeNode curr = stack.peek();
            if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
                if (curr.getLeft() != null) {
                    stack.push(curr.getLeft());
                } else if (curr.getRight() != null) {
                    stack.push(curr.getRight());
                }
            } else if (curr.getLeft() == prev) {
                if (curr.getRight() != null) {
                    stack.push(curr.getRight());
                }
            } else {
                stack.pop();
                System.out.print(curr.getData() + " ");
            }

            prev = curr;
        }
    }

    void printLevelOrder(BinaryTreeNode node) {
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            BinaryTreeNode tempNode = queue.poll();
            System.out.print(tempNode.getData() + " ");
            if (tempNode.getLeft() != null) {
                queue.add(tempNode.getLeft());
            }
            if (tempNode.getRight() != null) {
                queue.add(tempNode.getRight());
            }
        }
    }


}