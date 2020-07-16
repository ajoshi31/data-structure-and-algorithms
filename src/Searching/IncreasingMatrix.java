package Searching;


public class IncreasingMatrix {
    public static void main(String args[]) {

        int[][] matrix2 = {
                {1, 3, 6, 10},
                {2, 5, 9, 11},
                {4, 7, 12, 13},
                {8, 14, 16, 17}
        };

        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20}
        };
        int a = 6;
        searchInMatrixUtil(matrix2, a);

    }

    private static void searchInMatrixUtil(int[][] matrix, int key) {
        boolean flag = false;
        int row = matrix.length;
        int column = matrix[0].length;
        int rowTracker = 0;
        int columnTracker = column - 1;
        while (rowTracker < row && columnTracker >= 0) {
            if (matrix[rowTracker][columnTracker] == key) {
                System.out.println("Element: " + key + " found at -> row: " + rowTracker + ", column: " + columnTracker);
                flag = true;
                break;
            }
            if (matrix[rowTracker][columnTracker] < key) {
                rowTracker++;
            } else {
                columnTracker--;
            }
        }
        if (!flag) {
            System.out.println("Element: " + key + " not Found");
        }
    }
}
