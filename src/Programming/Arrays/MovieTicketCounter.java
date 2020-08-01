/*
There are n people standing in line to buy show tickets.Due to high demand, the venue sells tickets according to the following rules:

The person at the head of the line can buy exactly one ticket and must then exit the line.
if a person needs to purchase additional tickets,they must re-enter the end of the line and wait to be sold their next ticket(assume exit and re-entry takes zero seconds).
Each ticket sale takes exactly one second.
We express initial line of n people as an array, tickets = [tickets0, tickets1 ... ticketsN-1], where ticketsi denotes the number of tickets person i wishes to buy. If Jesse is standing at a position p in this line, find out how much time it would take for him to buy all tickets. Complete the waiting time function in the editor below. It has two parameters:

An array, tickets, of n positive integers describing initial sequence of people standing in line. Each ticketsi describes number of tickets that a person waiting at initial place.
An integer p, denoting Jesse's position in tickets.

Sample Input 5 2 6 3 4 5 2 Sample Output 12 Sample Input 4 5 5 2 3 3 Sample Output 11
 */

package Programming.Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MovieTicketCounter {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int length = Integer.parseInt(input);
        input = br.readLine();
        int position = Integer.parseInt(input);
        input = br.readLine();
        String[] str = input.trim().split("\\s+");
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int result = movieTicketUtil(arr, length, position);
        System.out.println(result);

    }

    private static int movieTicketUtil(int[] input, int length, int position) {

        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (position >= i) {
                if (input[position] >= input[i]) {
                    sum = sum + input[i];
                } else {
                    sum = sum + input[position];
                }
            } else {
                if (input[position] >= input[i]) {
                    sum = sum + input[i] - 1;
                } else {
                    sum = sum + input[position];
                }
            }
            System.out.println(sum);
        }
        return sum;
    }

}
