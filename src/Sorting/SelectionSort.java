package Sorting;

class SelectionSort {
    void selectionSort(int[] array, int n) {

        for (int i = 0; i < n; i++) {

            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;

            System.out.print("Iteration " + (i + 1) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }

    }
}
