package DynamicProblems;

public class FibonacciNumber {

    public static void main(String args[]) {
        int n = 20;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i < 1) {
                arr[i] = 0;
            } else if (i == 1) {
                arr[i] = 1;
            } else {
                arr[i] = arr[i - 1] + arr[i - 2];
            }
            System.out.print(arr[i] + " ");
        }
    }
}