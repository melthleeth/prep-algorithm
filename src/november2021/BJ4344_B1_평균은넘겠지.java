package november2021;

import java.io.*;
import java.util.*;

public class BJ4344_B1_평균은넘겠지 {
    static int C, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        C = Integer.parseInt(br.readLine());

        while (C-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] score = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                score[i] = Integer.parseInt(st.nextToken());
                score[0] += score[i];
            }
            double avg = score[0] / N;

            for (int i = 1; i <= N; i++)
                if (score[i] > avg) cnt++;

            bw.write(String.format("%.3f", (double)(cnt * 100) / N) + "%\n");
        }

        br.close();
        bw.close();
    }
}
