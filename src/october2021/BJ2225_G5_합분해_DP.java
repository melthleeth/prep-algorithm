package october2021;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2225_G5_합분해_DP {
    static int N, K;
    static int[][] dp = new int[201][201];
    static final int C = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int k = 0; k <= K; k++) dp[0][k] = 1;

        for (int n = 1; n <= N; n++)
            for (int k = 1; k <= K; k++)
                dp[n][k] += (dp[n][k - 1] + dp[n - 1][k]) % C;

        bw.write(String.valueOf(dp[N][K]));
        br.close();
        bw.close();
    }

}
