package Searching;

import java.util.Arrays;

public class RGBSeperation {
    public static void main(String args[]) {
        String[] inputArray = {"R", "G", "B", "R", "R", "G", "R", "B"};
        // Output = [R, R, R, R, G, G, B, B]

        int high = inputArray.length - 1;
        int low = 0;
        int tracker = 0;
        String temp = "";

        while (tracker <= high) {
            switch (inputArray[tracker]) {
                case "R":
                    temp = inputArray[tracker];
                    inputArray[tracker] = inputArray[low];
                    inputArray[low] = temp;
                    tracker++;
                    low++;
                    break;
                case "G":
                    tracker++;
                    break;
                case "B":
                    temp = inputArray[tracker];
                    inputArray[tracker] = inputArray[high];
                    inputArray[high] = temp;
                    high--;
                    break;
            }
        }
        System.out.println(Arrays.toString(inputArray));
    }
}
