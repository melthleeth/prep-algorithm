package september2021;

import java.io.*;
import java.util.*;

public class BJ20282_B2_GameShow {
    static int N, curr, ans = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            curr += Integer.parseInt(br.readLine());
            ans = Math.max(curr + 100, ans);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
