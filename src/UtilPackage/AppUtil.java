package UtilPackage;

public class AppUtil {
    public int maxInIntegerArray(int array[]) {

        int max = Integer.MIN_VALUE;
        for (Integer i : array) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public KeyValue maxKeyValueInArray(int array[]) {
        int max = 0;
        int makKey = 0;
        int count = 1;
        for (Integer i : array) {
            count++;
            if (i > max) {
                max = i;
                makKey = count;
            }
        }
        return new KeyValue(makKey, max);
    }

    public void printIntegerArrayValues(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i] + " ");
        }
    }

}


