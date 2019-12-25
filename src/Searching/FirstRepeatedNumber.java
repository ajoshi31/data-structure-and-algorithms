package Searching;

import java.util.Hashtable;

public class FirstRepeatedNumber {
    public static void main(String args[]) {
        int[] array = {12, 14, 15, 16, 3, 2, 2, 2, 4, 5, 3, 3, 7};
        int max = Integer.MIN_VALUE;
        int index = 0;
        Hashtable<Integer, Integer> hash = new Hashtable<>();
        for (int i = 0; i < array.length; i++) {
            if (hash.get(array[i]) == null) {
                hash.put(array[i], i + 1);
            } else {
                if (hash.get(array[i]) > 0) { // If condition to skip more than 2 repetition
                    hash.put(array[i], -1 * hash.get(array[i]));
                }
            }
            if (hash.get(array[i]) < 0) {
                if (hash.get(array[i]) > max) {
                    max = hash.get(array[i]);
                    index = i;
                }
            }
        }
        System.out.println(array[index]);
    }
}
