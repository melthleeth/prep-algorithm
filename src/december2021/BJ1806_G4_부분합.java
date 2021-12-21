package december2021;

import java.io.*;
import java.util.*;

public class BJ1806_G4_부분합 {
    static int N, S, start, sum, ans = 111111;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];

            if (sum < S) continue;

            while (sum - arr[start] >= S) {
                sum -= arr[start];
                start++;
            }

            ans = Math.min(ans, i - start + 1);
        }

        if (ans == 111111) ans = 0;

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
