package BackTracking;

public class Permutation {
    public static void main(String[] args) {
        String str = "ABC";
        int n = str.length();
        Permutation permutation = new Permutation();
        permutation.permute(str, 0, n - 1);
    }

    private void permute(String str, int l, int r) {
        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i); // eg abcd (-> abdc) // Validate and Set the value using some utility function
                permute(str, l + 1, r); // check for other options
                // Backtracking to make it original string that was before going to recursion
                // abdc (-> abcd)
                str = swap(str, l, i);  // Backtrack
            }
        }
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
