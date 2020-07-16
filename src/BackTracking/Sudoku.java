package BackTracking;

import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {

        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };
        int N = board.length;
        if (solveSudoku(board, N)) {
            // print solution
            printSudokuBoard(board, N);
        } else {
            System.out.println("No solution");
        }
    }

    private static void printSudokuBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(board[i]) + "\n");
        }
    }

    private static boolean solveSudoku(int[][] board, int N) {
        //Condition for the end condition to exit
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // no empty space left
        if (isEmpty) {
            return true;
        }
        // Constraints
        for (int i = 1; i <= N; i++) {
            if (validChoiceOfNumber(board, row, col, i)) {
                board[row][col] = i;
                if (solveSudoku(board, N)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    private static boolean validChoiceOfNumber(int[][] board, int row, int column, int num) {
        int sqrt = (int) Math.sqrt(board.length);
        return rowCheck(board, row, num) && columnCheck(board, column, num) &&
                blockCheck(board, (row - row % sqrt), (column - column % sqrt), num, sqrt);
    }

    private static boolean columnCheck(int[][] board, int col, int num) {
        for (int[] aBoard : board) {
            if (aBoard[col] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean rowCheck(int[][] board, int row, int num) {
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }
        return true;
    }

    private static boolean blockCheck(int[][] board, int row, int column, int num, int sqrt) {
        for (int i = row; i < (row + sqrt); i++) {
            for (int j = column; j < (column + sqrt); j++)
                if (board[i][j] == num) {
                    return false;
                }
        }
        return true;
    }
}
