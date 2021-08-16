package august2021;

import java.io.*;
import java.util.*;

public class BJ10809_B2_알파벳찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (alpha[idx] > -1) alpha[idx] = Math.min(alpha[idx], i);
            else alpha[idx] = i;
        }

        for (int i = 0; i < 26; i++)
            bw.write(alpha[i] + " ");

        br.close();
        bw.close();
    }
}
