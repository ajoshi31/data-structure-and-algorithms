package BinaryTree.problems;

public class BinaryTreeWithGivenNodes {

    public int numberOfBSTs(int n) {

        int[] count = new int[n];
        count[0] = count[1] = 1;
        for (int i = 2; i < n; i++) {
            count[i] = 0;
            for (int j = 0; j < i; j++) {
                count[i] = count[i] + (count[j] * count[i - 1 - j]); // DP problem
            }
        }

        return count[n - 1];

    }
}












