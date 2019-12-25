package Searching;

import java.util.Arrays;

public class DutchNationalFlag {
    public static void main(String args[]) {

        int[] inputArray = {1, 0, 1, 0, 1, 1};
        int left = 0, right = inputArray.length - 1;

        while (left < right) {
            if (inputArray[left] == 1) {
                int temp = inputArray[left];
                inputArray[left] = inputArray[right];
                inputArray[right] = temp;
                right--;

            } else {
                left++;
            }

        }

        System.out.println(Arrays.toString(inputArray));
    }
}
