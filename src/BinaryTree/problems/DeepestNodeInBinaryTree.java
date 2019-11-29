package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestNodeInBinaryTree {

    private int MAX_LEVEL = 0;
    private int LEAF_COUNT = 0;
    private BinaryTreeNode result = null;
    private Queue<BinaryTreeNode> deepestNodes = new LinkedList<BinaryTreeNode>();

    public void deepMostLeftLeafNode(BinaryTreeNode node) {
        deepestLeftLeafUtil(node, 0, MAX_LEVEL, false);
        System.out.print("\n\nResult Data:" + String.valueOf(result.getData()));
    }

    private void deepestLeftLeafUtil(BinaryTreeNode node, int level, int maxLevel, boolean isLeft) {
        if (node == null) {
            return;
        }
        if (isLeft && node.getLeft() == null && node.getRight() == null && level > maxLevel) {
            MAX_LEVEL = level;
            result = node;
        }
        deepestLeftLeafUtil(node.getLeft(), level + 1, MAX_LEVEL, true);
        deepestLeftLeafUtil(node.getRight(), level + 1, MAX_LEVEL, false);
    }

    /**
     * Get all the deepest nodes at the same level
     *
     * @param node
     */
    public void getAllDeepestNodes(BinaryTreeNode node) {
        getAllDeepestNodeUtil(node, 0, MAX_LEVEL);
        for (BinaryTreeNode node1 : deepestNodes) {
            System.out.print(node1.getData() + " ");
        }
    }

    private void getAllDeepestNodeUtil(BinaryTreeNode node, int level, int maxLevel) {

        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null && level >= maxLevel) {
            MAX_LEVEL = level;
            if (level > maxLevel) {
                //delete the previous array
                while (!deepestNodes.isEmpty()) {
                    deepestNodes.poll();
                }
            }
            deepestNodes.add(node);
        }
        getAllDeepestNodeUtil(node.getLeft(), level + 1, MAX_LEVEL);
        getAllDeepestNodeUtil(node.getRight(), level + 1, MAX_LEVEL);

    }

    public void getAllLeafNode(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            System.out.print(node.getData() + " ");
        }
        getAllLeafNode(node.getLeft());
        getAllLeafNode(node.getRight());
    }

    public void countAllLeafNodeUsingRecursion(BinaryTreeNode node) {
        countAllLeafNodeUsingRecursionUtil(node, LEAF_COUNT);
        System.out.print("\n\n Leaf Count using recursion: " + LEAF_COUNT);
    }

    private void countAllLeafNodeUsingRecursionUtil(BinaryTreeNode node, int count) {
        if (node == null) {
            return;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            LEAF_COUNT = count + 1;
        }
        countAllLeafNodeUsingRecursionUtil(node.getLeft(), LEAF_COUNT);
        countAllLeafNodeUsingRecursionUtil(node.getRight(), LEAF_COUNT);
    }


    public BinaryTreeNode deepestNodeInBinaryTreeWithQueue(BinaryTreeNode node) {

        // This problem is same as level order traversal and hence the same logic can be applied
        // This code can also be used as the same right most deepest leaf node
        BinaryTreeNode temp = null;
        if (node == null) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
        return temp;
    }

    public void countAllLeafNodeWithoutRecursion(BinaryTreeNode node) {

        int count = 0;
        BinaryTreeNode temp = null;
        if (node == null) {
            System.out.print("\n\nThe count is : 0");
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.getRight() == null && temp.getLeft() == null) {
                count++;
            }
            if (temp.getLeft() != null) {
                queue.offer(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.offer(temp.getRight());
            }
        }
        System.out.print("\n\nThe count is :" + count);
    }


}

