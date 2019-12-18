package Sorting;

import java.util.Arrays;

class BubbleSort {
    void bubbleSort(int[] array, int n) {

        System.out.println(Arrays.toString(array));
        for (int i = 0; i < n - 1; i++) {

            boolean swapBool = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapBool = true;
                }
            }

            System.out.print("Iteration " + (i + 1) + ": ");
            System.out.println(Arrays.toString(array));
            if (!swapBool) {
                break;
            }
        }

    }
}
