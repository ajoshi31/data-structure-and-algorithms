package turing;

import java.util.Scanner;
import java.util.Stack;
import java.lang.*;

class wework {
    private static int biggestTable(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        return maxRectangle(R, C, grid);
    }

    private static int maxHist(int C, int row[]) {
        Stack<Integer> result = new Stack<>();
        int top_val = 0;
        int max_area = 0;
        int area = 0;
        int i = 0;
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i])
                result.push(i++);
            else {
                max_area = utilFunc(top_val, result, row, area, max_area, i);
            }
        }
        while (!result.empty()) {
            max_area = utilFunc(top_val, result, row, area, max_area, i);
        }
        return max_area;
    }

    private static int utilFunc(int top_val, Stack<Integer> result, int row[], int area, int max_area, int i) {
        top_val = row[result.peek()];
        result.pop();
        area = top_val * i;
        if (!result.empty())
            area = top_val * (i - result.peek() - 1);
        return Math.max(area, max_area);
    }

    private static int maxRectangle(int R, int C, int A[][]) {
        int result = maxHist(C, A[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++)
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];
            result = Math.max(result, maxHist(C, A[i]));
        }
        return result;
    }

    private static int[][] getMatrix() {
        Scanner sc = new Scanner(System.in);
        int rowsLen = sc.nextInt();
        int colsLen = sc.nextInt();
        int matrix[][] = new int[rowsLen][colsLen];
        int i;
        for (i = 0; i < rowsLen; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        return matrix;
    }

    public static void main(String args[]) {
        int result = wework.biggestTable(getMatrix());
        System.out.print(result);
    }
}


