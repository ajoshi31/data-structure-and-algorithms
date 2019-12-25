package Searching;

public class MissingNumberFrom1ToNPart2 {
    public static void main(String args[]) {

        int[] array = {1, 2, 4, 5, 6, 7};
        int n = 7;

        int xorOfNNumber = 0;
        for (int i = 1; i <= n; i++) {
            xorOfNNumber = xorOfNNumber ^ i;
        }

        int XorOfArray = 0;
        for (int aData : array) {
            XorOfArray = XorOfArray ^ aData;
        }

        System.out.println(XorOfArray ^ xorOfNNumber);
    }
}
