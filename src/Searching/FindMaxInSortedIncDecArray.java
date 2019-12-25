package Searching;

public class FindMaxInSortedIncDecArray {
    public static void main(String args[]) {
        int[] array = {4, 5, 6, 7, 9, 10, 12, 14, 15, 17, 6, 5, 3, 2, 1};
        // get three element and check if sequence is inc or dec or mid is max

        int mid, first = 0, last = array.length - 1;
        while (first <= last) {
            if (first == last) {
                // Only one element
                System.out.println(array[first]);
                break;
            }
            if (last == first + 1) {
                // Two element are left
                System.out.println(Math.max(array[first], array[last]));
                break;
            }
            mid = first + (last - first) / 2;
            if (array[mid - 1] < array[mid] && array[mid] > array[mid + 1]) {
                // This is the element
                System.out.println(array[mid]);
                break;
            } else if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
                // The sequence is dec means the element is on left side
                last = mid - 1;
            } else if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
                // The sequence is inc means the element is on right side
                first = mid + 1;
            } else {
                System.out.println(Integer.MIN_VALUE);
                break;
            }
        }
    }
}
