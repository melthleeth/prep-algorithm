package october2021;

import java.io.*;
import java.util.*;

public class BJ2435_S5_기상청인턴신현수 {
    static int N, K, ans = -10001;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        sum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(st.nextToken());
            sum[i] += sum[i - 1];
        }
        for (int i = K; i <= N; i++)
            ans = Math.max(ans, sum[i] - sum[i - K]);


        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
