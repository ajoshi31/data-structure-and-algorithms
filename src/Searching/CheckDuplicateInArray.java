package Searching;

import java.util.Hashtable;

public class CheckDuplicateInArray {

    public static void main(String args[]) {
        int[] array = {1, 2, 2, 4, 5, 6, 7};
        boolean duplicate = false;
        Hashtable<Integer, Integer> hash = new Hashtable<>();

        for (int anArray : array) {
            hash.merge(anArray, 1, (a, b) -> a + b);
            if (hash.get(anArray) > 1) {
                duplicate = true;
                break;
            }

        }
        if (duplicate) {
            System.out.println("Duplicate found");
        } else {
            System.out.println("Duplicate not found");
        }

    }

}
