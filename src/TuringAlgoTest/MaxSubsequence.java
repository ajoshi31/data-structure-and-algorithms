package TuringAlgoTest;

public class MaxSubsequence {

    private static int count = 0;

    public static void main(String[] args) {
        //Initialise root
        String initial = "xyz";
        String goal = "xzyrxz";
        Integer abc = goal.length();
        String str = String.valueOf(goal.charAt(0));
        myFunc(str, goal, initial, 0, 1, abc, goal.charAt(0));
        System.out.print(count);
    }

    private static void myFunc(String str, String goal, String initial, Integer index, Integer strTracker, Integer len, char current) {
        if (strTracker.equals(len)) {
            count++;
            return;
        }
        boolean isCharaAvail = initial.contains(String.valueOf(current));
        if (!isCharaAvail) {
            count = -1;
            return;
        }

        boolean isFound = isSubSequence(str, initial, str.length(), initial.length());
        current = goal.charAt(index + 1);
        if (isFound) {
            index = index + 1;
            str = str + String.valueOf(goal.charAt(index));
            strTracker = strTracker + 1;
        } else {
            goal = goal.substring(index);
            index = 0;
            str = String.valueOf(goal.charAt(index));
            count++;
        }
        myFunc(str, goal, initial, index, strTracker, len, current);
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
