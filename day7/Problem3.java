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
     * Complete the 'noPrefix' function below.
     *
     * The function accepts STRING_ARRAY words as parameter.
     */
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        // Returns true if there's a prefix conflict
        public boolean insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (!current.children.containsKey(c)) {
                    current.children.put(c, new TrieNode());
                }
                current = current.children.get(c);

                // Case 1: an existing word is a prefix of this word
                if (current.isEndOfWord) {
                    return true;
                }
            }

            // Case 2: this word is a prefix of existing word(s)
            if (!current.children.isEmpty()) {
                return true;
            }

            current.isEndOfWord = true;
            return false;
        }
    }

    public static void noPrefix(List<String> words) {
        Trie trie = new Trie();

        for (String word : words) {
            if (trie.insert(word)) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
        }

        System.out.println("GOOD SET");
    }

}

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> words = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        Result.noPrefix(words);

        bufferedReader.close();
    }
}
