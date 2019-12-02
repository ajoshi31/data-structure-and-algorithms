package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;
import BinaryTree.BinaryTreeTraversal;

public class BTreeUsingInAndPreOrder {

    private static int preIndex = 0;

    public void generateBTFromInAndPreOrderTraversal(int pre[], int in[]) {
        int length = in.length;

        BinaryTreeNode node = buildBinaryTreeUtil(pre, in, 0, length - 1);
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        binaryTreeTraversal.inOrderTraversal(node);
        System.out.println();
        binaryTreeTraversal.postOrderTraversal(node);
        System.out.println();
        binaryTreeTraversal.preOrderTraversal(node);
        System.out.println();

    }

    private BinaryTreeNode buildBinaryTreeUtil(int pre[], int in[], int start, int end) {

        if (start > end) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode(pre[preIndex++]);
        if (start == end) {
            return node;
        }

        int inIndex = 0;
        for (int i = start; i <= end; i++) {
            if (node.getData() == in[i]) {
                inIndex = i;
                break;
            }
        }

        node.setLeft(buildBinaryTreeUtil(pre, in, start, inIndex - 1));
        node.setRight(buildBinaryTreeUtil(pre, in, inIndex + 1, end));
        return node;
    }
}
