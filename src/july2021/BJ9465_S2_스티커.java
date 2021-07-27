package july2021;

import java.io.*;
import java.util.*;

public class BJ9465_S2_스티커 {
    static int T, n, ans;
    static int[][] stickers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][n + 2];
            dp = new int[2][n + 2];
            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 2; j < n + 2; j++)
                    stickers[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 2; j < n + 2; j++) {
                for (int i = 0; i < 2; i++) {
                    int oppositeIdx = i == 0 ? 1 : 0;
//                    System.out.println("max: " + Math.max(dp[oppositeIdx][j - 2], dp[i][j - 2] + stickers[oppositeIdx][j - 1]));
                    dp[i][j] = stickers[i][j] + Math.max(dp[oppositeIdx][j - 2], dp[i][j - 2] + stickers[oppositeIdx][j - 1]);
                    dp[i][j] = Math.max(dp[i][j], dp[oppositeIdx][j - 1] + stickers[i][j]);
                }
//                System.out.println(Arrays.toString(dp[0]));
//                System.out.println(Arrays.toString(dp[1]));
//                System.out.println("---");
            }
//            System.out.println(Arrays.toString(dp[0]));
//            System.out.println(Arrays.toString(dp[1]));
            bw.write(Math.max(dp[0][n + 1], dp[1][n + 1]) + "\n");
        }
        br.close();
        bw.close();
    }
}
