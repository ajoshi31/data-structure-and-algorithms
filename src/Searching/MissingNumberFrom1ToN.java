package Searching;

public class MissingNumberFrom1ToN {
    public static void main(String args[]) {

        int[] array = {1, 2, 4, 5, 6, 7};
        int n = 7;

        int sumOfN = (n * (n + 1)) / 2;

        int arraySum = 0;
        for (int aData : array) {
            arraySum = arraySum + aData;
        }

        System.out.println(sumOfN - arraySum);
    }
}

