package Searching;

import java.util.HashMap;

public class SumEqualToKInArray {
    public static void main(String args[]) {
        int[] array = {5, 15, 10, 35, 20};
        int sum = 45;
        HashMap<Integer, Integer> map = new HashMap<>();
        int x = 0, y = 0;
        if (array.length < 2) {
            System.out.println("There is no such two numbers");
        } else {
            for (int i = 0; i < array.length; i++) {

                if (map.containsKey(array[i])) {
                    x = array[map.get(array[i])];
                    y = array[i];
                } else {
                    map.put(sum - array[i], i);
                }

            }
        }
        System.out.println(" X :" + x + ", Y: " + y);
    }
}
