package TuringAlgoTest;

public class MaxSubsequence {

    private static int goalLength = 0;
    private static int count = 0;
    private static int strTracker = 1;
    private static String initial;

    public static void main(String[] args) {

        initial = "xyz";
        String goal = "";
        goalLength = goal.length();
        if (goalLength == 0) {
            System.out.print(-1);
        } else {
            myFunc(goal.substring(0, 1), goal, 0);
            System.out.print(count);
        }

    }

    private static void myFunc(String newSubSequenceString, String goal, int index) {

        // To check if the next character exist in the initial string or not of no then goal cannot be formed
        if (!initial.contains(String.valueOf(goal.charAt(index)))) {
            count = -1;
            return;
        }
        boolean isFound = isSubSequence(newSubSequenceString, initial, newSubSequenceString.length(), initial.length());

        // Recursion termination condition to reach end of string
        if (strTracker == goalLength) {
            if (isFound) {
                count++;
                return;
            }
        }

        //Create the new sub sequence if the is found is false else keep on tracking the string
        if (isFound) {
            index = index + 1;
            newSubSequenceString = newSubSequenceString + String.valueOf(goal.charAt(index));
            strTracker = strTracker + 1;
        } else {
            goal = goal.substring(index);
            index = 0;
            newSubSequenceString = String.valueOf(goal.charAt(index));
            count++;
        }
        myFunc(newSubSequenceString, goal, index);
    }

    private static boolean isSubSequence(String str1, String str2, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequence(str1, str2, m - 1, n - 1);
        return isSubSequence(str1, str2, m, n - 1);
    }
}
