package PriorityQueue;

import java.util.Arrays;

public class HeapSort {
    private static int[] inputArray = {2, 1, 3, 4, 7, 9, 6, 5, 8};

    private static void heapSort() {

        Heap heap = new Heap();
        int N = inputArray.length;
        System.out.println("Initial Input");
        System.out.println(Arrays.toString(inputArray));
        for (int i = (N / 2) - 1; i >= 0; i--) {
            maxHeapify(inputArray, i, N);
        }

        int heapSize = N;
        //Now delete max and put ithe last element in the root and then hapify that element, and put max in the last element
        for (int i = N - 1; i >= 1; i--) {
            swap(0, i); // Swap last element with the first max element
            heapSize = heapSize - 1;
            maxHeapify(inputArray, 0, heapSize);
        }

        System.out.println("Sorted Array");
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

    public static void main(String args[]) {
        heapSort();
    }

}
