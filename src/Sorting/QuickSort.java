package Sorting;

import java.util.Arrays;

class QuickSort {

    public void quickSort(int[] arr, int n) {
        System.out.println(Arrays.toString(arr));
        quickSortUtil(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            // to do a increasing do a less tah  check and for decreasing do a greater than check
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    private void quickSortUtil(int arr[], int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSortUtil(arr, low, pivotIndex - 1);
            quickSortUtil(arr, pivotIndex + 1, high);
        }
    }

}