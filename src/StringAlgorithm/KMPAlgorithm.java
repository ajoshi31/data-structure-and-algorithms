package StringAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class KMPAlgorithm {

    private int[] computeLPSAray(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0;
        int i = 1;
        lps[0] = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i] = j + 1;
                j++;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;

    }

    private ArrayList KMP(String text, String pattern) {

        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>();
        // Compute pre processing array for KMP
        int lps[] = computeLPSAray(pattern);

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == pattern.length()) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                {
                    if (j != 0) {
                        j = lps[j - 1];
                    } else {
                        i++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String args[]) {

        String str = "AABAACAADAABAABA";
        String subString = "AABA";
        KMPAlgorithm ss = new KMPAlgorithm();
        ArrayList pos = ss.KMP(str, subString);

        pos.forEach(System.out::println);


    }
}
