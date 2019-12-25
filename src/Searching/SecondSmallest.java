package Searching;

public class SecondSmallest {

    public static void main(String args[]) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int smallest = 0;
        int secondSmallest = 0;

        if (array[0] > array[1]) {
            smallest = array[1];
            secondSmallest = array[0];
        } else if (array[0] < array[1]) {
            smallest = array[0];
            secondSmallest = array[1];
        }

        for (int i = 2; i <= array.length - 1; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                secondSmallest = smallest;
            } else if (array[i] > smallest && array[i] < secondSmallest) {
                secondSmallest = array[i];
            }
        }

        System.out.println(secondSmallest);


    }
}
