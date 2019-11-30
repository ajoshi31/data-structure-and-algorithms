package BinaryTree;

class BinaryTreeUtilsFunctions {

    int heightOfTree(BinaryTreeNode root) {
        if (root == null)
            return 0;
        else
            return Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight())) + 1;
    }

    int sizeOfBinaryTree(BinaryTreeNode node) {
        return (node.getLeft() == null ? 0 : sizeOfBinaryTree(node.getLeft())) + 1 +
                (node.getRight() == null ? 0 : sizeOfBinaryTree(node.getRight()));
    }

    int maxElementInBinaryTree(BinaryTreeNode node) {
        int MAX_ELEMENT = Integer.MIN_VALUE;
        if (node != null) {
            int maxElementInSubtree = maxElementInBinaryTree(node.getLeft()) > maxElementInBinaryTree(node.getRight()) ?
                    maxElementInBinaryTree(node.getLeft()) : maxElementInBinaryTree(node.getRight());
            MAX_ELEMENT = maxElementInSubtree > node.getData() ? maxElementInSubtree : node.getData();
        }
        return MAX_ELEMENT;
    }
}
