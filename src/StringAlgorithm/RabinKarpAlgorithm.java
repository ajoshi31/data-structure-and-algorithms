package StringAlgorithm;

public class RabinKarpAlgorithm {

    private int primeHash = 2;

    public static void main(String args[]) {
        RabinKarpAlgorithm rks = new RabinKarpAlgorithm();
        System.out.println(rks.RabinKarPatternSearch("Atul".toCharArray(), "l".toCharArray()));


    }

    private int RabinKarPatternSearch(char[] text, char[] pattern) {

        int textLength = text.length;
        int patternLength = pattern.length;

        if (patternLength <= textLength) {
            double patternHash = createHash(patternLength, pattern);
            double testIteratorHash = createHash(patternLength, text);

            for (int i = 0; i <= textLength - patternLength; i++) {

                if (patternHash == testIteratorHash && checkIfEqual(text, i, pattern, patternLength)) {
                    return i;
                }

                if (i < textLength - patternLength)
                    testIteratorHash = recalculateHash(text, i + 1, testIteratorHash, patternLength);

            }
        }

        return -1;

    }

    private double recalculateHash(char[] text, int start, double oldHash, int len) {

        oldHash = oldHash - text[start - 1];
        oldHash = oldHash / primeHash;
        oldHash = oldHash + text[start + len - 1] * Math.pow(primeHash, len - 1);
        return oldHash;
    }


    private double createHash(int length, char[] str) {
        double hash = 0;
        for (int i = 0; i < (length); i++) {
            hash = hash + str[i] * Math.pow(primeHash, i);
        }

        return hash;
    }


    private boolean checkIfEqual(char[] text, int start, char[] pattern, int len) {

        int j = 0;
        for (int i = start; i < start + len; i++) {
            if (text[i] != pattern[j]) {
                return false;
            }
            j++;
        }
        return true;
    }

}
