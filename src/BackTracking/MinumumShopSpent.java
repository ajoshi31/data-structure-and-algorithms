/*
There are K shops in a row. You can spend minimum of A[i] amount at ith shop, i = (0,K).

The shopping has to be sequential and every shop you skip a minimum amount has to be given to skip the shop.
You cannot skip 1st and last shop and you can skip max of 3 shops in continuation.

Determine minimum amount of money spent after all k shops passed.

Input:
K x
K seperated integer value that has to be spend at each shop.

Output: y (min amount )

2 <= K <= 210^5
1 <= x <= 210^5
1 <= A[i] <= 2*10^5

Input:
5 2
1 2 3 4 5

**Output
12
*/
package BackTracking;

public class MinumumShopSpent {

	static int MIN_VALUE = Integer.MAX_VALUE;

	public static void main(String args[]) {
		// int[] input = {1,2,3,4,5};
		// int[] input = {1,2,2,2,5,2,2,2,1};
		int[] input = { 1, 2, 3, 4, 5 };
		int minPass = 2;
		shopProblem(input, 1, input.length, 0, minPass);
		System.out.println(MIN_VALUE + input[0] + input[input.length - 1]);
	}

	public static void shopProblem(int[] shops, int k, int N, int counter, int minPass) {
		
		// base case
		if (k == N - 1) {
			int sum = sumTillYet(shops, k);
			if (sum <= MIN_VALUE) {
				MIN_VALUE = sum;
			}
			return;
		}

		// bound condition
		if (counter == 3 || sumTillYet(shops, k) >= MIN_VALUE) {
			return;
		}

		// check for each value
		for (int i = k; i < shops.length - 1; i++) {
			int temp = shops[i];
			shops[i] = minPass;
			shopProblem(shops, i + 1, N, ++counter, minPass);

			// revert condition and check
			shops[i] = temp;
			shopProblem(shops, i + 1, N, 0, minPass);
		}
	}

	public static int sumTillYet(int[] shops, int k) {
		int sum = 0;
		for (int i = 1; i < k; i++) {
			sum = sum + shops[i];
		}
		return sum;
	}
}
