import java.io.*;
import java.util.*;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt(); // Number of queries

        Stack<Integer> enqueueStack = new Stack<>();
        Stack<Integer> dequeueStack = new Stack<>();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int x = sc.nextInt();
                enqueueStack.push(x);
            } else if (type == 2) {
                if (dequeueStack.isEmpty()) {
                    while (!enqueueStack.isEmpty()) {
                        dequeueStack.push(enqueueStack.pop());
                    }
                }
                if (!dequeueStack.isEmpty()) {
                    dequeueStack.pop();
                }
            } else if (type == 3) {
                if (dequeueStack.isEmpty()) {
                    while (!enqueueStack.isEmpty()) {
                        dequeueStack.push(enqueueStack.pop());
                    }
                }
                if (!dequeueStack.isEmpty()) {
                    System.out.println(dequeueStack.peek());
                }
            }
        }

        sc.close();
    }
}
