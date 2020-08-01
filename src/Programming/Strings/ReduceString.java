/*
Steve has a string of lowercase characters in range ascii[‘a’..’z’]. He wants to reduce the string to its shortest length by doing a series of operations. In each operation he selects a pair of adjacent lowercase letters that match, and he deletes them. For instance, the string aab could be shortened to b in one operation.

Steve’s task is to delete as many characters as possible using this method and print the resulting string. If the final string is empty, print Empty String

Function Description

Complete the superReducedString function in the editor below. It should return the super reduced string or Empty String if the final string is empty.

superReducedString has the following parameter(s):

s: a string to reduce
Input Format

A single string, .

Constraints

Output Format

If the final string is empty, print Empty String; otherwise, print the final non-reducible string.


ample Input 0

aaabccddd
Sample Output 0

abd
Explanation 0

Steve performs the following sequence of operations to get the final string:

aaabccddd → abccddd → abddd → abd

 */


package Programming.Strings;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReduceString {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String result = reduceStringUtil(input);

        if (result.length() > 0) {
            System.out.println(result);
        } else {
            System.out.println("EMPTY STRING");
        }
    }

    private static String reduceStringUtil(String s) {

        StringBuilder result = new StringBuilder();
        result.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (result.length() > 0) {
                char lastChar = result.charAt(result.length() - 1);
                if (lastChar == s.charAt(i)) {
                    result.deleteCharAt(result.length() - 1);
                } else {
                    result.append(s.charAt(i));
                }
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
