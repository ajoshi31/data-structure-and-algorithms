package DynamicProblems;

import java.util.Arrays;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String input = "gamaambganaanag";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        int n = lps.LPSubString(input);
        System.out.println(n);
    }

    static void printSubStr(String str, int low, int high) {
        System.out.println(str.substring(low, high + 1));
    }

    public int LPSubString(String str) {

        
        int N = str.length();
        if(N == 0){
            return 0;
        }
        int maxLength = 1;
        int start = 0;

        boolean[][] T = new boolean[N][N];

        for (int l = 1; l <= N; l++) {
            for (int i = 0; i <= N - l; i++) {
                int j = i + l - 1;
                if (l == 1) {
                    start = i;
                    T[i][j] = true;
                } else if (l == 2 && (str.charAt(i) == str.charAt(j))) {
                    T[i][j] = true;
                    start = i;
                    maxLength = 2;
                } else {
                    if ((str.charAt(i) == str.charAt(j)) && T[i + 1][j - 1]) {
                        T[i][j] = true;
                        if (l > maxLength) {
                            start = i;
                            maxLength = l;
                        }
                    }
                }
            }
        }
        // Arrays.stream(T).forEach(item -> System.out.println(Arrays.toString(item)));
        System.out.print("Longest palindrome substring is; ");
        printSubStr(str, start, start + maxLength - 1);

        return maxLength;
    }
}