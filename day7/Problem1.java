import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int Q = scanner.nextInt();
        scanner.nextLine();

        StringBuilder S = new StringBuilder();
        Stack<String> history = new Stack<>();

        for (int i = 0; i < Q; i++) {
            String[] input = scanner.nextLine().split(" ");
            int op = Integer.parseInt(input[0]);

            switch (op) {
                case 1: // append
                    history.push(S.toString());  // save current state
                    S.append(input[1]);
                    break;

                case 2: // delete
                    int k = Integer.parseInt(input[1]);
                    history.push(S.toString());  // save current state
                    S.delete(S.length() - k, S.length());
                    break;

                case 3: // print
                    int idx = Integer.parseInt(input[1]) - 1;
                    System.out.println(S.charAt(idx));
                    break;

                case 4: // undo
                    if (!history.isEmpty()) {
                        S = new StringBuilder(history.pop());
                    }
                    break;
            }
        }

        scanner.close();a
    }
}
