package TuringAlgoTest;

import java.util.Scanner;

public class MaximumOfficeWeWork {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        int i;
        for (i = 0; i < rows; i++) {
            String line = scanner.next();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        System.out.println(findMaxOffice(matrix, rows, cols));
    }

    private static int findMaxOffice(int[][] matrix, int rows, int column) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    traceOfficeSpace(matrix, i, j, rows, column);
                }
            }
        }
        return count;
    }

    private static void traceOfficeSpace(int[][] matrix, int i, int j, int rows, int columns) {
        if ((i >= 0) && (i < rows) && (j >= 0) && (j < columns)) {
            if (matrix[i][j] == 1) {
                matrix[i][j] = 0;
                traceOfficeSpace(matrix, i - 1, j, rows, columns);
                traceOfficeSpace(matrix, i + 1, j, rows, columns);
                traceOfficeSpace(matrix, i, j - 1, rows, columns);
                traceOfficeSpace(matrix, i, j + 1, rows, columns);
            }
        }
    }
}


