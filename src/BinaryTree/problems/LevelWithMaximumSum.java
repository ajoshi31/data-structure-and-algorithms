package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;
import UtilPackage.AppUtil;
import UtilPackage.KeyValue;

public class LevelWithMaximumSum {

    private int[] count = new int[20];
    private AppUtil appUtil = new AppUtil();

    public void levelWithMaximumSum(BinaryTreeNode node) {
        levelWithMaximumSumUtil(node, 0);
        KeyValue keyValue = appUtil.maxKeyValueInArray(count);
        System.out.print("\n\n Maximum sum in level " + keyValue.key + "  is : " + keyValue.value);

    }

    private void levelWithMaximumSumUtil(BinaryTreeNode node, int level) {
        if (node == null) {
            return;
        }
        count[level] = count[level] + node.getData();
        levelWithMaximumSumUtil(node.getLeft(), level + 1);
        levelWithMaximumSumUtil(node.getRight(), level + 1);
    }
}

