package BinaryTree;

class BinaryTreeOperation {
    private boolean findInBinaryTree(BinaryTreeNode node, int data) {
        return node != null &&
                (data == node.getData() || (findInBinaryTree(node.getLeft(), data) || findInBinaryTree(node.getRight(), data)));
    }

    void insertElementInBinaryTree(BinaryTreeNode node, int data) {
        if (node == null) {
            new BinaryTreeNode(data);
        } else {
            insertHelper(node, data);
        }
    }

    private void insertHelper(BinaryTreeNode node, int data) {
        if (node.getData() > data) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode(data));
            } else {
                insertHelper(node.getLeft(), data);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode(data));
            } else {
                insertHelper(node.getRight(), data);
            }
        }
    }
}

