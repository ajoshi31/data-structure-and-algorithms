package BinarySearchTree.problems;

import java.util.Vector;

class BST2DLL {

    // A binary tree node has data,
// and left and right pointers
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = right = null;
        }
    }

    ;

    // Function to perform In-Order traversal of the
// tree and store the nodes in a vector
    static void inorder(Node root, Vector<Integer> v) {
        if (root == null)
            return;

    /* first recur on left child */
        inorder(root.left, v);

    /* append the data of node in vector */
        v.add(root.data);

    /* now recur on right child */
        inorder(root.right, v);
    }

    // Function to convert Binary Tree to Circular
// Doubly Linked list using the vector which stores
// In-Order traversal of the Binary Tree
    static Node bTreeToCList(Node root) {
        // Base cases
        if (root == null)
            return null;

        // Vector to be used for storing the nodes
        // of tree in In-order form
        Vector<Integer> v = new Vector<>();

        // Calling the In-Order traversal function
        inorder(root, v);

        // Create the head of the linked list pointing
        // to the root of the tree
        Node head_ref = new Node(v.get(0));

        // Create a current pointer to be used in traversal
        Node curr = head_ref;

        // Traversing the nodes of the tree starting
        // from the second elements
        for (int i = 1; i < v.size(); i++) {

            // Create a temporary pointer
            // pointing to current
            Node temp = curr;

            // Current's right points to the current
            // node in traversal
            curr.right = new Node(v.get(i));

            // Current points to its right
            curr = curr.right;

            // Current's left points to temp
            curr.left = temp;
        }

        // Current's right points to head of the list
        curr.right = head_ref;

        // Head's left points to current
        head_ref.left = curr;

        // Return head of the list
        return head_ref;
    }

    // Display Circular Link List
    static void displayCList(Node head) {
        System.out.println("Circular Doubly Linked List is :");

        Node itr = head;
        do {
            System.out.print(itr.data + " ");
            itr = itr.right;
        } while (head != itr);

        System.out.println();
    }

    // Driver Code
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        Node head = bTreeToCList(root);
        displayCList(head);
    }
}