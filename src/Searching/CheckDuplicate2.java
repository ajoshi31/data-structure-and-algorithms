package Searching;

/*
The array in range of 0 to n-1, find the duplicate in the array in O(1) auxillary space
 */

public class CheckDuplicate2 {

    public static void main(String args[]) {
        int[] array = {1, 2, 2};
        boolean duplicate = false;
        for (int i = 0; i < array.length; i++) {
            if (array[Math.abs(array[i])] < 0) {
                duplicate = true;
                break;
            }
            array[Math.abs(array[i])] = -array[Math.abs(array[i])];
        }
        if (duplicate) {
            System.out.println("Duplicate found");
        } else {
            System.out.println("Duplicate not found");
        }
    }

}
