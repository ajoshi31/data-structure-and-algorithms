package Programming.Arrays;

import org.junit.Test;

/**
 * Server receives a package of N incoming request, handling ith request will take the A[i] time.
 * Load balancer has to drop two acquired request and distribute the rest of them between three workers in such a way that
 * each worker receives the contiguous fragment of request to handle and finishes  handling them in exactly the same
 * moment as the other workers. No two worker should receive the same request to compete
 * The load balancer's distribution of request is performed by selecting two request that will be dropped and which
 * split the array into three contiguous parts that will be allocated to the worker, more precisely if request 2 and 5 are
 * chosen by the load balancer from a package of 9 request
 * 0th to 1st will be handled by -> worker 1
 * 3rd to 4th will be handled by -> worker 2
 * 6th to 8th will be handled by -> worker 3
 * <p>
 * Such a distribution will be correct if each worker receives request equalling the same total amount of handling time.
 * <p>
 * Write a function solution that, given an array A of n integers, representing the time of execution of consecutive tasks,
 * return true  if it is possible or the load balancer to choose two request that will  determine and even distribution of
 * request or false other wise
 * <p>
 * 1: Given A= [1,3,4,2,2,2,1,1,2];
 * Should return true at position 2,5 as distribution handling time is 4 second for each fragment
 * 2: A = [1,,1,1,1,1,1] should return false
 * 3: A = [1,2,1,2,...1,2] of length 20000 the function should return true as each will give 9999 execution time at
 * and its is broken at 6667 and 13337
 * <p>
 * N = RANGED AS [5, 10^5]
 * A[i] = [1,10^4]
 * <p>
 * The above question is just the extended version of equal sum sub array with dropping of the element
 */

public class LoadBalancingEqualSumSubArray {

    public static void main(String[] args) {

        int[] c = {1, 3, 1000, 2, 2, 502, 1, 1, 2};
        int[] B = {1, 1, 10000, 1, 1, 10000, 1, 1};
        int[] A = {1, 1, 2, 1, 1, 2, 1, 1};
        int[] C = {1, 1, 1, 1, 1, 1, 1, 1};
        boolean value = LoadBalancingEqualSumSubArrayUtil(C);
        System.out.println(value);
    }

    private static boolean LoadBalancingEqualSumSubArrayUtil(int[] input) {

        int sum = 0;
        for (int item : input) {
            sum = sum + item;
        }
        int left = 0;
        int right = input.length - 1;
        int sumLeft = 0, sumRight = 0, sumMiddle = 0;
        while (left < right) {
            if ((sumLeft + input[left]) * 3 < sum) {
                sumLeft += input[left];
                left++;
            } else if ((sumRight + input[right]) * 3 < sum) {
                sumRight += input[right];
                right--;
            } else {
                if (sumLeft == sumRight) {
                    left++;
                    right--;
                    break;
                } else {
                    return false;
                }
            }
        }

        for (int i = left; i <= right; i++) {
            sumMiddle += input[i];
        }

        return sumMiddle == sumRight;
    }


}

