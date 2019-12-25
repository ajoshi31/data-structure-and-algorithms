package Searching;
/*
This is dutch national flag problem to seperate 1's and 0's
 */

import java.util.Arrays;

public class SeperateEvenAndOdd {
    public static void main(String args[]) {

        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 14, 14};
        int left = 0, right = inputArray.length - 1;
        int count1 = 0;
        while (left < right) {
            count1++;
            if (inputArray[left] % 2 == 0) {
                left++;
            } else if (inputArray[right] % 2 == 1) {
                right--;
            } else {
                int temp = inputArray[left];
                inputArray[left] = inputArray[right];
                inputArray[right] = temp;
                left++;
                right--;
            }
        }
        System.out.println(Arrays.toString(inputArray));

        // int[] inputArray = {1, 0, 1, 0, 1, 1};
        left = 0;
        right = inputArray.length - 1;
        int count2 = 0;

        while (left < right) {
            count2++;
            if (inputArray[left] == 1) {
                int temp = inputArray[left];
                inputArray[left] = inputArray[right];
                inputArray[right] = temp;
                right--;

            } else {
                left++;
            }

        }

        System.out.println("Count1: " + count1 + " Count2: " + count2);
    }


}