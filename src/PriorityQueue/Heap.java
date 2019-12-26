package PriorityQueue;

import java.util.Arrays;

public class Heap {
    private static int[] inputArray = {2, 1, 3, 4, 7, 9, 6, 5, 8};

    public static void main(String args[]) {
        int n = inputArray.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(inputArray, i, n);
        }
        System.out.println(Arrays.toString(inputArray));
    }

    public static void maxHeapify(int[] A, int i, int N) {
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

    public static void minHeapify(int[] A, int i, int N) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int min = Integer.MAX_VALUE;
        if (left < N && right < N) {
            if (A[left] < A[right]) {
                min = left;
            } else {
                min = right;
            }
            if (A[i] < A[min]) {
                min = i;
            }
            if (min != i) {
                swap(min, i);
                maxHeapify(A, min, N);
            }
        }

    }

    public static void swap(int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}
//[9, 8, 6, 5, 7, 3, 2, 1, 4]
//[9, 8, 6, 5, 7, 3, 2, 1, 4]