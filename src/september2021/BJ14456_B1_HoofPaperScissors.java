package september2021;

import java.io.*;
import java.util.*;

public class BJ14456_B1_HoofPaperScissors {
    static int N, ans;
    static int[][][] result = new int[4][4][6];
    static int[][] pool = new int[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow1 = Integer.parseInt(st.nextToken());
            int cow2 = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 6; j++) result[cow1][cow2][j]++;
        }
        for (int i = 0; i < 6; i++) {
            int hoof = pool[i][0];
            int scissor = pool[i][1];
            int paper = pool[i][2];
            ans = Math.max(ans, result[hoof][scissor][i] + result[scissor][paper][i] + result[paper][hoof][i]);
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
