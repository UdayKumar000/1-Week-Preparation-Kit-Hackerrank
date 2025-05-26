import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
// import java.util.*;
// import java.util.concurrent.*;
// import java.util.function.*;
// import java.util.regex.*;
// import java.util.stream.*;
// import static java.util.stream.Collectors.joining;
// import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. STRING n
     * 2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Step 1: Get the sum of digits in n
        long initialSum = 0;
        for (char c : n.toCharArray()) {
            initialSum += c - '0';
        }

        // Step 2: Multiply the sum by k
        long total = initialSum * k;

        // Step 3: Recursively compute the super digit
        return computeSuperDigit(total);
    }

    // Helper function to compute super digit recursively
    private static int computeSuperDigit(long num) {
        if (num < 10) {
            return (int) num; // base case: single digit
        }

        long sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return computeSuperDigit(sum);
    }

}

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
