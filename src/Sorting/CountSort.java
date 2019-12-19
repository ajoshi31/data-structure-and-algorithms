package Sorting;

import java.util.Arrays;

class CountSort {

    void countSort(int[] arr, int n) {

        System.out.println(Arrays.toString(arr));
        int[] outputArray = new int[n];
        int[] count = new int[20];

        for (int i = 0; i < n; i++) {
            count[arr[i]] = count[arr[i]] + 1;
        }

        for (int j = 1; j < count.length; j++) {
            count[j] = count[j] + count[j - 1];
        }

        for (int i = 0; i < n; i++) {
            outputArray[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        System.arraycopy(outputArray, 0, arr, 0, n);
        System.out.println(Arrays.toString(arr));
    }

}
