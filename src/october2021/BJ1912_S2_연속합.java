package october2021;

import java.io.*;
import java.util.*;

public class BJ1912_S2_연속합 {
    static int N;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sum = new int[N + 1];
        sum[0] = -2001;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum[i] = Math.max(sum[i - 1] + num, num);
        }
        Arrays.sort(sum);
        bw.write(String.valueOf(sum[N]));
        br.close();
        bw.close();
    }

}
