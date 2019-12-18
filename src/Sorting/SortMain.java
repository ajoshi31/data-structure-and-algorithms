package Sorting;

public class SortMain {

    public static void main(String args[]) {

        int[] input = {3, 4, 1, 6, 18, 5, 10, 11, 2};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(input, input.length);


    }
}


