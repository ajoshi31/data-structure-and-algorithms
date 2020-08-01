/*
That is perfection
Write a program to determine whether a number N is equal to the sum of its proper positive divisors (excluding the number itself).

Input format

First line: T (number of test cases)
For each test case
First line: N
Output format

Print YES, if N is equal to the sum of its proper positive divisors else print NO.

Constraints

1≤T≤100
1≤N≤109

3
6
5
28


YES
NO
YES

Explanation
6 = 1 + 2+ 3, so it is perfect.

5 != 1 , so it is not perfect.

28 = 1 + 2 + 4 + 7 + 14, so it is perfect.
*/

package Programming.MathamaticsCoding;

import java.io.*;


public class ProperPositiveDivisor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());

            String out_ = Solve(N);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }

    private static String Solve(int N) {
        // Write your code here
        int sum = 0;
        for (int i = 1; i <= N / 2; i++) {
            if (N % i == 0) {
                sum = sum + i;
            }
        }
        if (sum == N) {
            return "YES";
        } else {
            return "NO";
        }

    }
}