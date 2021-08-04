package august2021;

import java.io.*;
import java.util.*;

public class BJ2098_G1_외판원순회 {
    static int N, ans;
    static int[][] W;
    static final int INF = 1000000 * 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];


        for (int i = 0; i < N; i++) {
            Arrays.fill(W[i], INF);
            W[i][i] = 0;
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
