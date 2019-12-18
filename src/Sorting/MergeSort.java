package Sorting;

import java.util.Arrays;

class MergeSort {

    void mergeSort(int[] arr, int n) {
        System.out.println(Arrays.toString(arr));
        mergeSortUtil(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));

    }

    private void mergeSortUtil(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortUtil(arr, left, mid);
        mergeSortUtil(arr, mid + 1, right);
        mergeSortedArray(arr, left, mid, right);
    }

    private void mergeSortedArray(int[] arr, int left, int mid, int right) {

        int leftLen = mid - left + 1;
        int rightLen = right - mid;
        int[] leftArr = new int[leftLen];
        int[] rightArr = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < rightLen; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = left;
        while (i < leftLen && j < rightLen) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        while (i < leftLen) {
            arr[k] = leftArr[i];
            k++;
            i++;
        }
        while (j < rightLen) {
            arr[k] = rightArr[j];
            k++;
            j++;
        }
    }
}
