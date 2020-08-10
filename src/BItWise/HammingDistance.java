package BItWise;

public class HammingDistance {
    public int hammingDistance(int x, int y) {
        // Approach One is Xor and then shift
        int xorVal = x ^ y;
        int result = 0;
        while (xorVal > 0) {

            result = result + (xorVal & 1);
            xorVal >>= 1; // or xorVal= xorVal/2
        }
        return result;

    }

    public int hammingDistanceApproach2(int x, int y) {
        int result = 0;
        while (x > 0 || y > 0) {
            result = result + ((x % 2) ^ (y % 2)); // If number is even then its last bit is 0 else 1
            x >>= 1;
            y >>= 1;
        }
        return result;
    }

}
