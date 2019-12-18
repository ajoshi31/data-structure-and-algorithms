package Sorting;

import java.util.Arrays;

class InsertionSort {
    void insertionSort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > key) {

                array[j] = array[j - 1];
                j--;
            }
            array[j] = key;
            System.out.print("Iteration " + (i + 1) + ": ");
            System.out.println(Arrays.toString(array));
        }
    }

    void insertionSortRecursion(int[] array, int n) {
        if (n <= 1)
            return;
        insertionSortRecursion(array, n - 1);
        int key = array[n - 1];
        int j = n - 2;
        while (j >= 0 && array[j] > key) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = key;
        System.out.println(Arrays.toString(array));
    }
}

