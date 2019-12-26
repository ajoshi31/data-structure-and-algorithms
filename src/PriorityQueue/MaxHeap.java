package PriorityQueue;

import java.util.Arrays;

public class MaxHeap {
    private static int[] inputArray = {7, 3, 5, 12, 45, 69, 23, 12, 45, 67, 34, 12};

    public static void main(String args[]) {
        int n = inputArray.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(inputArray, i, n - 1);
        }
        System.out.println(Arrays.toString(inputArray));
    }

    private static void maxHeapify(int[] A, int i, int N) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = -1;
        if (left < N && right < N) {
            if (A[left] > A[right]) {
                max = left;
            } else {
                max = right;
            }
            if (A[i] > A[max]) {
                max = i;
            }
            if (max != i) {
                swap(max, i);
                maxHeapify(A, max, N);
            }
        }

    }

    private static void swap(int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}
