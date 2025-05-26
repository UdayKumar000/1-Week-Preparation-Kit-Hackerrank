import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
import java.util.*;
// import java.util.concurrent.*;
// import java.util.function.*;
// import java.util.regex.*;
import java.util.stream.*;
// import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        int rowCount = grid.size();
        int colCount = grid.get(0).length(); // get the number of columns safely

        // Step 1: Sort each row alphabetically
        char[][] sortedGrid = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            char[] row = grid.get(i).toCharArray();
            Arrays.sort(row); // sort the row alphabetically
            sortedGrid[i] = row;
        }

        // Step 2: Check each column
        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount - 1; row++) {
                if (sortedGrid[row][col] > sortedGrid[row + 1][col]) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

}

public class Problem1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
