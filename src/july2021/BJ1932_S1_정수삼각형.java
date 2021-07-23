package july2021;

import java.io.*;
import java.util.*;

public class BJ1932_S1_정수삼각형 {
    static int N, ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= i; j++)
                arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i - 1][j]);

        for (int val : arr[N])
            ans = Math.max(val, ans);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
