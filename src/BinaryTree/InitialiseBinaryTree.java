package BinaryTree;

class InitialiseBinaryTree {
    void initialise(BinaryTreeNode root) {
        BinaryTreeOperation bto = new BinaryTreeOperation();
        int[] data = {10, 50,45, 60,55,51};
        for (int aData : data) {
            bto.insertElementInBinaryTree(root, aData);
        }
    }
}

