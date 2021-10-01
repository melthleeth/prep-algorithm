package september2021;

import java.io.*;
import java.util.*;

public class BJ6081_B2_HayExpenses {
    static int N, Q;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = Integer.parseInt(br.readLine());
            sum[i] += sum[i - 1];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(sum[end] - sum[start - 1]));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
