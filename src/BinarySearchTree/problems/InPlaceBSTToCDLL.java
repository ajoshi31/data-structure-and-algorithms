package BinarySearchTree.problems;

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


}
