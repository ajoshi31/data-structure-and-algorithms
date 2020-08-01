/*
Problem Description
Saurabh is in his last year of engineering college and is still scared of maths, so he passed on his assignment to you.
He believes that any integer of the form A^x + B^y makes him angry. So, he gives you an integer array X of size N.
For each X[i], You have to find count of angry integers less than X[i].

Input Format:

The first line of input contains an integer N which denotes the size of array.
The second line of input contains an integer A.
The third line of input contains an integer B.
The fourth line of input contains an integer array X of size N.

Output Format:
For each X[i] output the count of angry integers less than X[i] on a new line.


Sample Input :

3
10
3
2 4 11

Sample Output :
0
1
3

Constraints:
1 <= N <= 100000
1 <= A,B <= 1000
1 <= X[i] < 2^(31)
0<=0 x,y

Function Description
Constraints
* */

package Programming.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class AngryInteger {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(input);

        input = br.readLine();
        long A = Long.parseLong(input);

        input = br.readLine();
        long B = Long.parseLong(input);

        long[] arr = new long[n];

        input = br.readLine();
        String[] str = input.trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(str[i]);
        }

        long[] ans = solve(arr, n, A, B);
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }
    }

    private static long[] solve(long arr[], long length, long A, long B) {
        long[] newArr = new long[(int) length];
        for (int i = 0; i < length; i++) {
            long number = arr[i];
            int sum = 0;
            for (int y = 0; Math.pow(A, y) < number; y++) {
                for (int x = 0; Math.pow(B, x) + Math.pow(A, y) < number; x++) {
                    sum++;
                }
            }
            newArr[i] = sum;
        }
        return newArr;
    }
}

