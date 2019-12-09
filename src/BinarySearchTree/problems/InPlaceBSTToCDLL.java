package BinarySearchTree.problems;

import BinaryTree.BinaryTreeNode;

/**
 * Create left linked list with recursion and right linked list with recursion merge two in inorder fashion.
 * <p>
 * The left leaf work as the previous pointer and right leaf work as the next pointer.
 * The left and right list will return the head position of the two list which has to be merged.
 * <p>
 * We need four important nodes to track, Head of left list, head of right list, last element of the right and left list
 * <p>
 * Last element of the list can be taken from the previous(here left) of first (head) node.
 * With these four nodes we can merge two circular linked list into single linked list
 * X:last = X-head->left
 * Y:last = Y-head->left
 * X: first = X-head
 * Y: first = Y-head
 * <p>
 * Once the linked list are merged we can do a recursion of the node in BST in inorder fashion without using extra space.
 */

public class InPlaceBSTToCDLL {

    public BinaryTreeNode binaryTreeToCDoubleList(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode leftSubTree = binaryTreeToCDoubleList(root.getLeft());
        BinaryTreeNode rightSubTree = binaryTreeToCDoubleList(root.getRight());
        root.setRight(root);
        root.setLeft(root);
        return concatenate(concatenate(leftSubTree, root), rightSubTree);
    }

    private BinaryTreeNode concatenate(BinaryTreeNode leftHead, BinaryTreeNode rightHead) {
        if (leftHead == null) {
            return rightHead;
        }
        if (rightHead == null) {
            return leftHead;
        }
        BinaryTreeNode leftLast = leftHead.getLeft();
        BinaryTreeNode rightLast = rightHead.getLeft();

        // Now we have required 4 nodes, LeftHead, LeftLast, RightHead, RightLast, we just need to fix each node and
        // make their right and left fixed to actual places after merging

        leftHead.setLeft(rightLast);
        leftLast.setRight(rightHead);
        rightHead.setLeft(leftLast);
        rightLast.setRight(leftHead);

        return leftHead; // just return the first head and all the element is tracked
    }

    public void displayCircularLinkedlistForBST(BinaryTreeNode node) {

        BinaryTreeNode itr = node;
        System.out.println("\nThe circular Linked List Is from right traversal(next): \n");
        do {
            System.out.print(itr.getData() + " ");
            itr = itr.getRight();
        } while (itr != node);

        System.out.println("\nThe circular Linked List Is From left traversal(previous): \n");
        do {
            System.out.print(itr.getData() + " ");
            itr = itr.getLeft();
        } while (itr != node);
    }

}
