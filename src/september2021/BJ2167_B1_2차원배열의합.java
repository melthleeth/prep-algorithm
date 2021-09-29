package september2021;

import java.io.*;
import java.util.*;

public class BJ2167_B1_2차원배열의합 {
    static int N, M, K;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                sum[i][j] += Integer.parseInt(st.nextToken());
                sum[i][j] += sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(sum[ex][ey] - (sum[sx - 1][ey] + sum[ex][sy - 1]) + sum[sx - 1][sy - 1]));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
