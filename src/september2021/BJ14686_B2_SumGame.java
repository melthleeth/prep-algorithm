package september2021;

import java.io.*;
import java.util.*;

public class BJ14686_B2_SumGame {
    static int N, ans, semaphore;
    static int[] swift;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        swift = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            swift[i] = Integer.parseInt(st.nextToken());
            swift[i] += swift[i - 1];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            semaphore += Integer.parseInt(st.nextToken());
            if (semaphore == swift[i]) ans = i;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
