package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

import java.util.Stack;

public class ZigZagTraversal {

    private Stack<BinaryTreeNode> stackLeftToRight = new Stack<BinaryTreeNode>();
    private Stack<BinaryTreeNode> stackRightToLeft = new Stack<BinaryTreeNode>();


    public void zigZagTraversalOfBinaryTree(BinaryTreeNode node) {

        if (node == null) {
            System.out.println("The tree is empty");
        }
        stackLeftToRight.push(node);
        while (stackRightToLeft.isEmpty() || !stackLeftToRight.isEmpty()) {
            while (!stackLeftToRight.isEmpty()) {
                BinaryTreeNode tempNode = stackLeftToRight.pop();
                System.out.print(tempNode.getData() + "  ");
                if (tempNode.getLeft() != null) {
                    stackRightToLeft.push(tempNode.getLeft());
                }
                if (tempNode.getRight() != null) {
                    stackRightToLeft.push(tempNode.getRight());
                }
            }
            while (!stackRightToLeft.isEmpty()) {
                BinaryTreeNode temp = stackRightToLeft.pop();
                System.out.print(temp.getData() + "  ");
                if (temp.getRight() != null) {
                    stackLeftToRight.push(temp.getRight());
                }
                if (temp.getLeft() != null) {
                    stackLeftToRight.push(temp.getLeft());
                }
            }
        }
    }
}
