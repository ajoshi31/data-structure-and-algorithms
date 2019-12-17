package TuringAlgoTest;

import DynamicProblems.MaxRectangleInHistogram;


public class MaxSizeTableInOffice {


    public static void main(String args[]) {
        int R = 4;
        int C = 4;

        int A[][] = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
        };
        System.out.print("Area of maximum rectangle is " +
                maxRectangle(R, C, A));

    }

    private static int maxRectangle(int R, int C, int A[][]) {

        int result = MaxRectangleInHistogram.maxRectArea(A[0]);

        for (int i = 1; i < C; i++) {

            for (int j = 0; j < R; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = A[i][j] + A[i - 1][j];
                }
                result = Math.max(result, MaxRectangleInHistogram.maxRectArea(A[i]));
            }

        }

        return result;
    }
}
