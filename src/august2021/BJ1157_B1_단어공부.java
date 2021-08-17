package august2021;

import java.io.*;
import java.util.*;

public class BJ1157_B1_단어공부 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toUpperCase(Locale.ROOT);
        int[] alpha = new int[26];
        int maxIdx = -1, maxCnt = -1;
        char c = 'A';

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'A';
            alpha[idx]++;
            maxCnt = Math.max(maxCnt, alpha[idx]);
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] == maxCnt) {
                if (maxIdx > -1) {
                    bw.write("?");
                    maxIdx = -1;
                    break;
                } else maxIdx = i;
            }
        }
        if (maxIdx > -1) bw.write(('A' + maxIdx));
        br.close();
        bw.close();
    }
}
