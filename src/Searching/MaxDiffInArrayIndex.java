package Searching;


import java.util.Arrays;

public class MaxDiffInArrayIndex {
    public static void main(String args[]) {
        int[] array = {3, 8, 10, 3, 2, 80, 30, 33, 4};
        int maxDiff = -1, n = array.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];
        leftMin[0] = array[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(array[i], leftMin[i - 1]);
        }
        System.out.println(Arrays.toString(leftMin));
        rightMax[n - 1] = array[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rightMax[j] = Math.max(array[j], rightMax[j + 1]);
        }
        System.out.println(Arrays.toString(rightMax));
        int i = 0, j = 0;
        while (j < n && i < n) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else {
                i = i + 1;
            }
        }
        System.out.println(maxDiff);
    }
}
