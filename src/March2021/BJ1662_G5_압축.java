package March2021;
import java.util.*;
import java.io.*;

public class BJ1662_G5_압축 {
    static char[] arr;
    static Stack<Character> s = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        arr = br.readLine().toCharArray();
        for (char item : arr) {
            if (item == ')') {
                String temp = sb.toString();
                sb.setLength(0);

                String A = s.peek().toString();
                while(s.peek() != '(') s.pop();
                s.pop();

                int B = s.peek() - '0';
                s.pop();

                System.out.println();
            } else s.push(item);
        }

    }
}
