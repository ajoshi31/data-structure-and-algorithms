package KAryTree;

public class Main {
    private static int ind;

    public static void main(String args[]) {
        int ind = 0;
        int k = 3, n = 10;
        int preorder[] = {1, 2, 5, 6, 7, 3, 8, 9, 10, 4};

        KAryNode root = BuildKaryTree_1(preorder, n, k, ind);
        System.out.println("Postorder traversal of " +
                "constructed full k-ary tree is: ");
        postord(root, k);
        System.out.println();
    }

    // Function to find the height of the tree
    private static KAryNode BuildKaryTree_1(int[] A, int n, int k, int in) {
        int height = (int) Math.ceil(Math.log((double) n * (k - 1) + 1) /
                Math.log((double) k));
        ind = in;
        return BuildKaryTree(A, n, k, height);
    }

    private static KAryNode BuildKaryTree(int A[], int n,
                                          int k, int h) {
        // For null tree
        if (n <= 0)
            return null;

        KAryNode nNode = new KAryNode(A[ind]);

        // For adding k children to a node
        for (int i = 0; i < k; i++) {

            // Check if ind is in range of array
            // Check if height of the tree is greater than 1
            if (ind < n - 1 && h > 1) {
                ind++;
                // Recursively add each child
                nNode.getChildren().add(BuildKaryTree(A, n, k, h - 1));
            } else {
                nNode.getChildren().add(null);
            }
        }
        return nNode;
    }

    static void postord(KAryNode root, int k) {
        if (root == null)
            return;
        for (int i = 0; i < k; i++)
            postord(root.getChildren().get(i), k);
        System.out.print(root.getValue() + " ");
    }
}
//5 6 7 2 8 9 10 3 4 1

