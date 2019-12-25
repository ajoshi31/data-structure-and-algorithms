package Searching;

import java.util.Arrays;

public class a1b1array {
    public static void main(String args[]) {

        String[] inputArr = {"a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8",
                "b1", "b2", "b3", "b4", "b5", "b6", "b7", "b8"};

        System.out.println(Arrays.toString(inputArr));
        int start = 0;
        int end = inputArr.length - 1;
        String[] result = a1b1Util(inputArr, start, end);
        System.out.println(Arrays.toString(result));

    }

    private static String[] a1b1Util(String[] arr, int start, int end) {

        int n = end - start + 1; // length of array = 8
        if (n < 2) {
            return arr;
        }

        for (int i = 0; i < n / 4; i++) {
            String temp = arr[(start + n / 4) + i];
            arr[(start + n / 4) + i] = arr[start + n / 2 + i];
            arr[(start + n / 2) + i] = temp;
        }
        a1b1Util(a1b1Util(arr, start, start + n / 2 - 1), start + n / 2, end);
        return arr;
    }
}
