package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;
import UtilPackage.AppUtil;

public class AllRootToLeafPath {

    private AppUtil appUtil = new AppUtil();

    public void printAllRootToLeafPath(BinaryTreeNode node) {

        int[] paths = new int[256];
        printAllRootToLeafPathUtil(node, paths, 0);
    }

    private void printAllRootToLeafPathUtil(BinaryTreeNode node, int[] pathArray, int pathLength) {
        if (node == null) {
            return;
        }
        pathArray[pathLength] = node.getData();
        pathLength++;
        if (node.getLeft() == null && node.getRight() == null) {
            appUtil.printIntegerArrayValues(pathArray, pathLength);
        }
        printAllRootToLeafPathUtil(node.getLeft(), pathArray, pathLength);
        printAllRootToLeafPathUtil(node.getRight(), pathArray, pathLength);

        System.out.println();
    }
}

