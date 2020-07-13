package DynamicProblems;

public class StockSales {

    private static int maxProfit(int price[], int n, int k) {
        int currentProfit[] = new int[n];
        int previousProfit[];
        int evenProfit[] = new int[n];
        int oddProfit[] = new int[n];

        for (int t = 0; t <= k - 1; t++) {
            int max = Integer.MIN_VALUE;
            if (t % 2 == 1) {
                currentProfit = oddProfit;
                previousProfit = evenProfit;
            } else {
                currentProfit = evenProfit;
                previousProfit = oddProfit;
            }

            for (int i = 1; i < n; i++) {
                max = Math.max(max, previousProfit[i - 1] - price[i - 1]);
                currentProfit[i] = Math.max(currentProfit[i - 1], max + price[i]);
            }
        }

        return currentProfit[n - 1];
    }

    public static void main(String args[]) {
        int price[] = {10, 20, 5, 30, 40, 50, 100, 5, 40}; //10+70
        int k = 2;
        int n = price.length;
        System.out.println("\nMaximum Profit = " + maxProfit(price, n, k));
    }
}


//We can extend this solution to any number of the variable,
// using the even steps and odd steps. Coz we don't need any previous values other than k and k-1


//      Condition for the only one transaction is possible
//        for (int i = 1; i < n; i++) {
//            min = Math.min(price[i - 1], min);
//            profit[i] = Math.max(profit[i - 1], price[i] - min);
//        }
//
//      Condition for at most two transaction is possible
//        for (int i = 1; i < n; i++) {
//            max = Math.max(max, profit[i] - price[i]);
//            profit[i] = Math.max(profit[i - 1], max + price[i]);
//        }