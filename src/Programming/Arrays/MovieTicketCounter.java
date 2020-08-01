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
        return 1;
    }

}
