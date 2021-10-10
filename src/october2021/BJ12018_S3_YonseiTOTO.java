package october2021;

import java.io.*;
import java.util.*;

public class BJ12018_S3_YonseiTOTO {
    static int ans, sum, N, M;
    static int[] val;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        val = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            if (P < L) val[i] = 1;
            else {
                int[] arr = new int[P];
                for (int p = 0; p < P; p++)
                    arr[p] = Integer.parseInt(st.nextToken());
                Arrays.sort(arr);
                val[i] = arr[P - L];
            }
        }

        Arrays.sort(val);
        for (int mileage : val) {
            if (sum + mileage > M) break;
            sum += mileage;
            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
