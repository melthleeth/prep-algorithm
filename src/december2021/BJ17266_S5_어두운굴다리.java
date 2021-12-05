package december2021;

import java.io.*;
import java.util.*;

public class BJ17266_S5_어두운굴다리 {
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int prev = Integer.parseInt(st.nextToken());
        ans = prev;
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            ans = Math.max(ans, (int)Math.ceil((next - prev) / 2.0));
            prev = next;
        }
        ans = Math.max(ans, N - prev);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
