package Searching;

public class MaxZeroInRow {

    public static void main(String args[]) {
        int[][] matrix = {
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };

        int row = matrix.length;
        int col = matrix[0].length;
        int rowTracker = 0;
        int colTracker = col - 1;
        int count = 0;

        while (rowTracker < row && colTracker >= 0) {
            if (matrix[rowTracker][colTracker] == 0) {
                // check further left if zero are there
                colTracker--;
                count++;
            } else {
                // Move down to check if new row has zero stream if yes move further down to check
                rowTracker++;
            }
        }

        System.out.println(count);
    }
}
