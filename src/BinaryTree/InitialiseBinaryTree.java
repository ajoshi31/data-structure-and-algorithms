package BinaryTree;

class InitialiseBinaryTree {
    void initialise(BinaryTreeNode root) {
        BinaryTreeOperation bto = new BinaryTreeOperation();
        int[] data = {20, 50, 10, 30, 5,8, 25, 32, 33};
        for (int aData : data) {
            bto.insertElementInBinaryTree(root, aData);
        }
    }
}

