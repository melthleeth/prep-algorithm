package october2021;

import java.io.*;
import java.util.*;

public class BJ2208_G2_보석줍기 {
    static int N, M, ans;
    static int[] pSum, arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pSum = new int[N + 1];
        arr = new int[N + 1];
        sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            pSum[i] += pSum[i - 1] + arr[i];
        }

        sum[M] = pSum[M];
        for (int i = M + 1; i <= N; i++) {
            sum[i] = Math.max(sum[i - 1] + arr[i], pSum[i] - pSum[i - M]);
        }
        System.out.println(Arrays.toString(sum));
        Arrays.sort(sum);

        bw.write(String.valueOf(sum[N]));
        br.close();
        bw.close();
    }
}
