package september2021;

import java.io.*;

public class BJ11059_B2_크리문자열_누적합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int ans = 0;
        int[] sum;
        String str = br.readLine();
        int N = str.length();
        sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = str.charAt(i - 1) - '0';
            sum[i] += sum[i - 1];
        }
        for (int i = 0; i < N; i++) {
            int len = 1;
            while(true) {
                if (i + len * 2 > N) break;

                int sum1 = sum[i + len] - sum[i];
                int sum2 = sum[i + len * 2] - sum[i + len];
                if (sum1 == sum2) ans = Math.max(ans, len * 2);

                len++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

}
