package Sorting;

public class SortMain {

    public static void main(String args[]) {

        int[] input = {3, 4, 1, 6, 18, 5, 10, 11, 2};


//        new SelectionSort().selectionSort(input, input.length);
//        new BubbleSort().bubbleSort(input, input.length);
//        new InsertionSort().insertionSort(input, input.length);
//        new InsertionSort().insertionSortRecursion(input, input.length);
//        new MergeSort().mergeSort(input, input.length);
        new QuickSort().quickSort(input, input.length);

    }
}


