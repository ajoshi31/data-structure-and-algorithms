package DynamicProblems;

public class LongestPalindromicSubsequence {
    public static void main(String[] args){
        String input = "agbdba";

        LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
        int n = lps.PalindromicSubsequenceUtil(input);
        System.out.println(n);
    }

    public int PalindromicSubsequenceUtil(String str){

        int N = str.length();

        if(N == 0){
            return 0;
        }
        int[][] T = new int[N][N];
       
        for(int l=1; l <= N; l++){
            for(int i = 0; i < N - l + 1 ; i++){
                int j = i + l - 1;
                if(i == j && l==1){
                    T[i][j] = 1;
                } else if( (l == 2) & (str.charAt(i) == str.charAt(j))){
                    T[i][j] = 2;
                } else if( l > 2 & (str.charAt(i) == str.charAt(j))){
                    T[i][j] = T[i+1][j-1] + 2;
                } else {
                    T[i][j] = Math.max(T[i+1][j], T[i][j-1]);
                }
            }
        }

        return T[0][N-1];
    }

}