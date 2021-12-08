package december2021;

import java.io.*;
import java.util.*;

public class BJ4158_S5_CD {
    static int N, M, ans;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            ans = 0;
            set = new HashSet<>();

            if (N == 0 & M == 0) break;

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(br.readLine());
                set.add(num);
            }

            for (int i = 0; i < M; i++) {
                int num = Integer.parseInt(br.readLine());
                if (set.contains(num)) ans++;
            }

            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
