package Searching;

/*
Given an array of size and all elelemt occure only once excpet two numbers whcic occour twice.
Find those two repeating element.
Input: {4,2,4,5,2,3,1} size  = 7, and n=5
Output: 4 2
 */

public class TwoRepeatingNumberInArray {
    public static void main(String args[]) {
        int[] array = {4, 2, 4, 5, 2, 3, 1};
        int n = 5;
        int rightMostSetBit = 0, X = 0, Y = 0;
        int XOR = 0;
        for (int anArray : array) {
            XOR = XOR ^ anArray;
        }
        for (int i = 1; i <= n; i++) {
            XOR = XOR ^ i;
        }

        // XOR is the final value of a and b no to be found
        // Find the right most set bit
        rightMostSetBit = XOR & ~(XOR - 1);
        for (int anArray : array) {
            if ((anArray & rightMostSetBit) == 0) {
                X = X ^ anArray;
            } else {
                Y = Y ^ anArray;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & rightMostSetBit) == 0) {
                X = X ^ i;
            } else {
                Y = Y ^ i;
            }
        }
        System.out.println(" A: " + X + ", B:  " + Y);
    }
}
