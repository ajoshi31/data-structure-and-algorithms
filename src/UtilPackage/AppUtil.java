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
        return new KeyValue(max, makKey);
    }
}


