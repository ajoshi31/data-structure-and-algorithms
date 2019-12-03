package KAryTree;

class CreateKAryTree {
    private static int ind = 0;

    KAryNode buildKaryTree(int A[], int n,
                           int k, int h) {
        // For null tree
        if (n <= 0)
            return null;
        KAryNode nNode = new KAryNode(A[ind]);

        for (int i = 0; i < k; i++) {
            if (ind < n - 1 && h > 1) {
                ind++;
                // Recursively add each child
                nNode.getChildren().add(buildKaryTree(A, n, k, h - 1));
            } else {
                nNode.getChildren().add(null);
            }
        }
        return nNode;
    }
}
