package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;
import UtilPackage.AppUtil;
import UtilPackage.KeyValue;

public class LevelWithMaximumSum {

    private int[] count = new int[20];
    private AppUtil appUtil = new AppUtil();

    public int levelWithMaximumSum(BinaryTreeNode node) {
        maxWidthUsingPreOrderTraversalUtil(node, 0);

        KeyValue keyValue = appUtil.maxKeyValueInArray(count);
        return keyValue.value;
    }

    private void maxWidthUsingPreOrderTraversalUtil(BinaryTreeNode node, int level) {
        if (node == null) {
            return;
        }
        count[level] = count[level] + node.getData();
        maxWidthUsingPreOrderTraversalUtil(node.getLeft(), level + 1);
        maxWidthUsingPreOrderTraversalUtil(node.getRight(), level + 1);
    }

}

