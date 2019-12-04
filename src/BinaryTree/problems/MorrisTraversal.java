//Complexity is O(n) Space Complexity O(1)

package BinaryTree.problems;

import BinaryTree.BinaryTreeNode;

public class MorrisTraversal {

    public void morrisTraversalAlgo(BinaryTreeNode root, String typeTraversal) {
        if (root == null)
            return;
        BinaryTreeNode current = root;
        while (current != null) {
            if (current.getLeft() == null) {
                System.out.print(" " + current.getData());
                current = current.getRight();
            } else {
                BinaryTreeNode pre = current.getLeft();
                while ((pre.getRight() != null) && (pre.getRight() != current)) {
                    pre = pre.getRight();
                }
                if (current == pre.getRight()) {
                    pre.setRight(null);
                    if (typeTraversal.equals("IN")) {
                        System.out.print(" " + current.getData());
                    }
                    current = current.getRight();
                } else {
                    if (typeTraversal.equals("PRE")) {
                        System.out.print(" " + current.getData());
                    }
                    pre.setRight(current);
                    current = current.getLeft();
                }
            }
        }
    }
}

