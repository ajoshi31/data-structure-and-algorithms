package PriorityQueue;

import java.util.Arrays;

public class HeapSort {
    private static int[] inputArray = {2, 1, 3, 4, 7, 9, 6, 5, 8};

    private static void heapSort() {

        int N = inputArray.length;
        System.out.println("Initial Input");
        System.out.println(Arrays.toString(inputArray));
        for (int i = (N / 2) - 1; i >= 0; i--) {
            maxHeapify(inputArray, i, N);
        }
//Sorting
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
        int length = inputArray.length + 1;
        int[] copy = new int[inputArray.length + 1];
        System.arraycopy(inputArray, 0, copy, 0, inputArray.length);
        inputArray = copy;

        swim(length - 1, 78);

        System.out.println("Sorted Array");
        System.out.println(Arrays.toString(inputArray));
        heapSort();


    }


    private static void swim(int i, int val) {
        inputArray[i] = val;
        while (i > 0 && inputArray[i / 2] < inputArray[i]) {
            swap(i / 2, i);
            i = i / 2;
        }

    }
}
