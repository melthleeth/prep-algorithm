package november2021;

import java.io.*;
import java.util.*;

public class BJ11497_S1_통나무건너뛰기 {
    static int T, N, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            ans = 0;
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            int lastValue = arr[N - 1];
            for (int i = 2; i < N; i += 2)
                ans = Math.max(ans, arr[i] - arr[i - 2]);

            for (int i = 3; i < N; i += 2)
                ans = Math.max(ans, arr[i] - arr[i - 2]);

            if (N >> 2 == 1)
                ans = Math.max(ans, arr[N - 1] - arr[N - 2]);

            bw.write(String.valueOf(ans));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
