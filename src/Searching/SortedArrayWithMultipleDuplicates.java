package Searching;

/*
Sorted array of n numbers possibly with duplicates, find the first occurrence of a number
Input : arr int[n] n<100000; int data;
Output: int index
 */

public class SortedArrayWithMultipleDuplicates {

    public static void main(String args[]) {
        int[] array = {1, 2, 2, 4, 5, 6, 6, 6, 7, 7, 7, 8};
        int data = 2;
        int output = BinaryFirstOccuranceSearchUtil(array, data, 0, array.length - 1);
        if (output == -1) {
            System.out.println("Data not found");
        } else {
            System.out.println(output);
        }
        int output2 = BinaryLastOccourrenceSearchUtil(array, data, 0, array.length - 1);
        if (output2 == -1) {
            System.out.println("Data not found");
        } else {
            System.out.println(output2);
        }
    }

    private static int BinaryFirstOccuranceSearchUtil(int[] arr, int data, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        // checking fo first element as it dont' have mid -1
        if (arr[mid] == data && mid == low || arr[mid] == data && arr[mid] > arr[mid - 1]) {
            return mid;
        } else if (data > arr[mid]) {
            return BinaryFirstOccuranceSearchUtil(arr, data, mid + 1, high);
        } else {
            return BinaryFirstOccuranceSearchUtil(arr, data, low, mid - 1);
        }
    }

    private static int BinaryLastOccourrenceSearchUtil(int[] arr, int data, int low, int high) {
        if (high < low) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        // checking fo first element as it dont' have mid -1
        if (arr[mid] == data && mid == high || arr[mid] == data && arr[mid] < arr[mid + 1]) {
            return mid;
        } else if (data >= arr[mid]) {
            return BinaryLastOccourrenceSearchUtil(arr, data, mid + 1, high);
        } else {
            return BinaryLastOccourrenceSearchUtil(arr, data, low, mid - 1);
        }
    }
}
