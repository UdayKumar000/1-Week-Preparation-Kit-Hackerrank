import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    static final int MOD = 1000000007;

    // Fast exponentiation modulo MOD
    private static long modPow(long base, int exp, int mod) {
        long result = 1;
        long cur = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * cur) % mod;
            }
            cur = (cur * cur) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static int legoBlocks(int n, int m) {
        long[] rowWays = new long[m + 1];
        rowWays[0] = 1;

        // Calculate number of ways to build a single row of width m
        for (int width = 1; width <= m; width++) {
            rowWays[width] = 0;
            for (int blockSize = 1; blockSize <= 4; blockSize++) {
                if (width - blockSize >= 0) {
                    rowWays[width] = (rowWays[width] + rowWays[width - blockSize]) % MOD;
                }
            }
        }

        // Calculate total ways to build a wall of height n
        long[] totalWays = new long[m + 1];
        for (int width = 1; width <= m; width++) {
            totalWays[width] = modPow(rowWays[width], n, MOD);
        }

        // DP to calculate number of solid walls (no vertical cracks spanning all rows)
        long[] solidWays = new long[m + 1];
        solidWays[0] = 0;
        solidWays[1] = totalWays[1];

        for (int width = 2; width <= m; width++) {
            long sum = 0;
            for (int i = 1; i < width; i++) {
                sum += solidWays[i] * totalWays[width - i];
                sum %= MOD;
            }
            solidWays[width] = totalWays[width] - sum;
            if (solidWays[width] < 0)
                solidWays[width] += MOD;
        }

        return (int) solidWays[m];
    }

}

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
