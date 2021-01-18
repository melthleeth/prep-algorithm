package January2021;

import java.io.*;
import java.util.*;

public class BJ2875_B2_대회or인턴 {
    static int M, N, K, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= K; i++) {
            int m = M - (K - i);
            int n = N - i;
            int val = m / 2;
            if (val <= n) ans = Math.max(ans, val);
            else ans = Math.max(ans, n);
        }

        System.out.println(ans);
        br.close();
    }
}
