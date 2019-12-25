/*
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such
 * that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 */

package BackTracking;

public class NQueenProblem {

    public static void main(String[] args) {

        // Pass the n queens and return as the list of possible positions
        int[] nQueens = {4, 5, 6, 7};
        for (int queen : nQueens) {
            NQueenProblem s = new NQueenProblem();
            Position[] positions = s.nQueenSolution(queen);
            System.out.println("The possible location for the " + queen + " queen is: ");
            for (Position position : positions) {
                System.out.println(position.row + ", " + position.col);
            }
        }
    }

    private boolean isSafe(Position[] positions, int row, int col) {
        //Check if this row and col is not under attack from any previous queen. The position will just run till row
        for (int i = 0; i < row; i++) {
            if (positions[i].col == col || positions[i].row - positions[i].col == row - col ||
                    positions[i].row + positions[i].col == row + col) {
                return false;
            }
        }
        return true;
    }

    private boolean nQueenUtil(int N, int row, Position[] positions) {
        // All the queens has been placed or checked
        if (row == N) {
            return true;
        }

        // Now check for the each columns if theere exist the safe place if not move to next column
        for (int col = 0; col < N; col++) {
            if (isSafe(positions, row, col)) {
                positions[row] = new Position(row, col); // This overwrites the previous row with new column if it is safe
                if (nQueenUtil(N, row + 1, positions)) { // go to the next queen as it was success for present row
                    return true; // it cannot return false on if condition as we have to move to next for loop
                }
            }
        }
        return false;
    }

    private Position[] nQueenSolution(int nQueens) {
        // Initialise the position array for nQueens each row is equivalent to the index
        // and we need to pass the valid column to each row can have only one column
        Position[] positions = new Position[nQueens];
        boolean hasSolution = nQueenUtil(nQueens, 0, positions);

        if (hasSolution) {
            return positions;
        } else {
            return new Position[0];
        }
    }
}

/**
 * Position class to hold the row and column in position array
 */
class Position {
    int row, col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
