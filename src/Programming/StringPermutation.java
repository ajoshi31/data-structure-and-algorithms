package Programming;

public class StringPermutation {
    public static void main(String args[]) {
        String str = "abc";
        permutation(str);
    }

    private static void permutation(String str) {
        permutation(str, "");
    }

    private static void permutation(String str, String prefix) {
        //System.out.println("str : " + str + " prefix : " + prefix);
        if (str.length() == 0) {
            System.out.println("prefix - " + prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                // track each letter remove from string and
                // add to the prefix
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }
}