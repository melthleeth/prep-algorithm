package october2021;

import java.io.*;
import java.util.*;

public class BJ3020_G5_개똥벌레 {
    static int N, H, ans;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[2][H + 2];

        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());

            if (i % 2 == 0) arr[0][val]++;
            else arr[1][H - val + 1]++;
        }

        // even
        for (int i = H; i > 0; i--) {
            if (arr[0][i] > 0) arr[0][i] += arr[0][i + 1];
            else arr[0][i] = arr[0][i + 1];
        }

        // odd
        for (int i = 1; i <= H; i++) {
            if (arr[1][i] > 0) arr[1][i] += arr[1][i - 1];
            else arr[1][i] = arr[1][i - 1];
        }

        int minValue = N;
        for (int i = 1; i <= H; i++) {
            arr[0][i] += arr[1][i];
            minValue = Math.min(minValue, arr[0][i]);
        }

        for (int i = 1; i <= H; i++)
            if (arr[0][i] == minValue) ans++;

        bw.write(minValue + " " + ans);
        br.close();
        bw.close();
    }
}
