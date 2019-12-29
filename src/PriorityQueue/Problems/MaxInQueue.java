/**
 * HackerRank: Priority Queue
 * You have been given a sequence A of N digits. Each digit in this sequence ranges from 1 to  . You need to perform 2 types of operations on this list:
 * <p>
 * : Add(x): Add element x to the end of the list.
 * : Max(list): Find the maximum element in the current sequence.
 * For each query of type 2, you need to print the result of that operation.
 * <p>
 * Input Format
 * <p>
 * The first line consist of a single integer N denoting the size of the initial sequence. The next line consists of N space separated integers denoting the elements of the initial sequence. The next line contains a single integer q denoting the number of queries. The next q lines contains the details of the operation. The first integer type indicates the type of query. If typei ==1, it is followed by another integer x and you need to perform operation of type 1 else operations of type 2
 * <p>
 * Output Format
 * <p>
 * For each operation of the second type, print a single integer on a new line.
 * <p>
 * Constraints
 * 1 <= N <=  10^5
 * 1 <= a[i] <= 10^9
 * 1 <=  q   <= 10^4
 * <p>
 * 5
 * 1 2 3 4 5
 * 4
 * 1 1
 * 1 2
 * 1 3
 * 2
 **/


package PriorityQueue.Problems;

import java.util.Arrays;

public class MaxInQueue {
    public static void main(String args[]) {
        int N = 5;
        long[] A = {1, 20, 2, 30, 4};
        System.out.println(Arrays.toString(A));

        int[][] task = {
                {1, 10}, {1, 100}, {1, 500}, {2}, {3, 400}, {1, 1000}, {2}, {1, 600}, {2}
        };
        int q = task.length;
        buildHeap(A, N);

        for (int i = 0; i < q; i++) {
            if (task[i][0] == 1) {
                long[] newArray = new long[N + 1];
                System.arraycopy(A, 0, newArray, 0, N);
                A = newArray;
                swim(A, task[i][1], N);
                System.out.println("Added the element " + task[i][1]);
            } else if (task[i][0] == 2) {
                System.out.println(A[0]);
            } else {
                System.out.println("Invalid Task");
            }
        }
    }

    private static void buildHeap(long[] arr, int N) {
        for (int i = (N / 2) - 1; i >= 0; i--) {
            maxHeapify(arr, i, N);
        }
    }

    private static void maxHeapify(long[] arr, int i, int N) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;
        int max = -1;
        if (leftChild < N) {
            if (isMax(arr, leftChild, rightChild)) {
                max = leftChild;
            } else {
                max = rightChild;
            }
            if (isMax(arr, max, i)) {
                exchange(arr, max, i);
                maxHeapify(arr, max, N);
            }
        }

    }

    private static void swim(long[] arr, int val, int n) {
        arr[n] = val;
        while (n > 0 && arr[n] > arr[n / 2]) {
            exchange(arr, n / 2, n);
            n = n / 2;
        }
    }

    private static boolean isMax(long[] arr, int i, int j) {
        return arr[i] - arr[j] > 0;  // i is greater than j
    }

    private static void exchange(long[] pq, int i, int j) {
        long swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
