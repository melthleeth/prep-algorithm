package March2021;
import java.util.*;
import java.io.*;

public class BJ1662_G5_압축 {
    // 33(562(71(9)))
    static Stack<Integer> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int startIdx = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                s.push(i);
            }else if (str.charAt(i) == ')') {
                startIdx = s.pop();
                String Q = str.substring(startIdx + 1, i);

            }
        }

    }
}
