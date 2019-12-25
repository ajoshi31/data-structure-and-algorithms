package Searching;

public class SortedRotatedArray {
    public static void main(String args[]) {
        int[] inputArr = {8, 15, 20, 26, 30, 1, 4};
        int key = 30;
        int mid;
        boolean isFound = false;
        int first = 0;
        int last = inputArr.length - 1;

        while (first <= last) {
            mid = first + (last - first) / 2;
            if (first == last) {
                if (inputArr[first] == key) {
                    System.out.println(key + " at " + first);
                    isFound = true;
                    break;
                }
            }
            if (inputArr[mid] == key) {
                System.out.println(key + " at " + mid);
                isFound = true;
                break;
            }
            // Left is sorted
            if (inputArr[mid] > inputArr[first]) {
                if (key >= inputArr[first] && key < inputArr[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            } else if (inputArr[mid] < inputArr[first]) {
                if (key <= inputArr[last] && key > inputArr[mid]) {
                    first = mid + 1;
                } else {
                    last = mid - 1;
                }
            }
        }
        if (!isFound) {
            System.out.println("Not Found");
        }
    }
}