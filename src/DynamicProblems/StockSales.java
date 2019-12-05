package DynamicProblems;

public class StockSales {

    private static int maxProfit(int price[], int n) {
        int profit[] = new int[n];
        for (int i = 0; i < n; i++)
            profit[i] = 0;

        int min = price[0];
        System.out.println(profit[0]);
        for (int i = 1; i < n; i++) {
            min = Math.min(price[i - 1], min);
            profit[i] = Math.max(profit[i - 1], price[i] - min);

        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i < n; i++) {
            max = Math.max(max, profit[i] - price[i]);
            profit[i] = Math.max(profit[i - 1], max + price[i]);
        }
        return profit[n - 1];
    }


    public static void main(String args[]) {
//        int price[] = {2, 30, 15, 10, 8, 25, 80};
        int price[] = {2, 30, 25, 30, 200, 400};
//        int price[] = {2, 5, 7, 1, 4, 3, 1, 3};
//        int price[] = {10, 20, 10, 5, 40, 10, 500};
//        int price[] = {5, 3, 2, 1};
        int n = price.length;
        System.out.println("\nMaximum Profit = " + maxProfit(price, n));
    }
}


//We can extend this solution to any number of the variable,
// using the even steps and odd steps. Coz we don't need any previous values other than k and k-1