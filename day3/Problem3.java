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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
    if(k>26){
        k=k%26;
    }
    int l = s.length();
    StringBuilder res = new StringBuilder(l+5);
    for(int i=0;i<l;i++){
        if(s.charAt(i)<=122 && s.charAt(i)>=97){
            int aci = (int)s.charAt(i)+k;
        if(aci>122){
            System.out.println(aci%122);
            aci = 96 + aci%122 ;
        }
        res.insert(i,(char)aci);
        continue;
        }
        if(s.charAt(i)<=90 && s.charAt(i)>=65){
            int aci = (int)s.charAt(i)+k;
        if(aci>90){
            System.out.println(aci%122);
            aci = 64 + aci%90 ;
        }
        res.insert(i,(char)aci);
        continue;
        }
        
        res.insert(i,s.charAt(i));
        
        
    }
    return res.toString();
    }

}

public class Problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        // int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}





//   one more solution 


class CaesarCipher {

    public static String caesarCipher(String s, int k) {
        StringBuilder encrypted = new StringBuilder();
        k = k % 26; // Reduce extra rotations

        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                // rotate within 'a' to 'z'
                char ch = (char) (((c - 'a' + k) % 26) + 'a');
                encrypted.append(ch);
            } else if (Character.isUpperCase(c)) {
                // rotate within 'A' to 'Z'
                char ch = (char) (((c - 'A' + k) % 26) + 'A');
                encrypted.append(ch);
            } else {
                // leave symbols unchanged
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }
}

