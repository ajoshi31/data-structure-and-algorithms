package Programming.MathamaticsCoding;

/**
 * Given two numbers ‘k’ and ‘n’. Write an algorithm to calculate kn.
 * Find the algorithm that can be done in log n time
 */

public class PowerOfKtoN {
    public static void main(String args[]) {
        int k = 3;
        int n = -5;
        System.out.println(k + " power " + n + " :  Result: " + PowerOfKtoNUtilFunc(k, n));
    }

    private static double PowerOfKtoNUtilFunc(int k, int n) {

        if (n == 0) {
            return 1;
        }
        double halfPower = PowerOfKtoNUtilFunc(k, n / 2);

        if (n % 2 == 0) {
            return halfPower * halfPower;
        } else if (n > 0) {
            return halfPower * halfPower * k;
        } else {
            return halfPower * halfPower / k;
        }
    }

}

