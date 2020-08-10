package Programming.MathamaticsCoding;

import java.io.*;

public class LeastCommonPrimeDivisor {
    public static void main(String[] args) throws IOException {
        //  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //  PrintWriter wr = new PrintWriter(System.out);
        //  String[] arr_A1 = br.readLine().split(" ");
        //  long A = Long.parseLong(arr_A1[0]);
        //  long B = Long.parseLong(arr_A1[1]);
        long out_ = solve(101, 404);
        // long out_ = solve(4, 16);
        System.out.println(out_);

        //  wr.close();
        //  br.close();
    }

    static long solve(long A, long B) {
        long min = Math.min(A, B);
        long max = Math.max(A, B);

        for (long i = 2; i * i <= min; i += 2) {
            if (min % i == 0) {
                long a = min / i;
                if (max % i == 0) {
                    return i;
                } else if (max % a == 0) {
                    return a;
                }
            }

            if (i == 2) {
                i = 1;
            }
        }
        return (max % min == 0) ? min : -1;
    }

}






