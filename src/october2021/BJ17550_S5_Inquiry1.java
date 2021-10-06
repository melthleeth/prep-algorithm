package october2021;

import java.io.*;

public class BJ17550_S5_Inquiry1 {
    static int N;
    static long ans;
    static int[] sum;
    static long[] squareSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        squareSum = new long[N + 1];
        sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            sum[i] += num + sum[i - 1];
            squareSum[i] += (num * num) + squareSum[i - 1];
        }

        for (int i = 1; i <= N; i++)
            ans = Math.max(squareSum[i] * (sum[N] - sum[i]), ans);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
