import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Integer> stocksProfit = new ArrayList<>();
        stocksProfit.add(5);
        stocksProfit.add(7);
        stocksProfit.add(9);
        stocksProfit.add(13);
        stocksProfit.add(11);
        stocksProfit.add(6);
        stocksProfit.add(6);
        stocksProfit.add(3);
        stocksProfit.add(3);
        Integer[] intArray = new Integer[stocksProfit.size()];
        intArray = stocksProfit.toArray(intArray);
        Arrays.sort(intArray);
        for (Integer i : intArray)
            System.out.println(i);

        int result = Test.stockPairs(stocksProfit, 12);
        System.out.println(result);
    }

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        int result = 0;
        Set<Integer> checkSet = new HashSet<>();
        int length = stocksProfit.size();
        Integer[] stockArray = new Integer[length];
        stockArray = stocksProfit.toArray(stockArray);
        Arrays.sort(stockArray);
        int left = 0;
        int right = length - 1;
        while (left < right) {
            if (checkSet.contains(stockArray[left])) {
                left++;
                continue;
            }
            if (checkSet.contains(stockArray[right])) {
                right--;
                continue;
            }
            if (stockArray[left] + stockArray[right] == target) {
                result++;
                checkSet.add(stockArray[left]);
                checkSet.add(stockArray[right]);
                left++;
                right--;
            } else if (stockArray[left] + stockArray[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}
