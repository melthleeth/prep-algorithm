package december2021;

import java.io.*;
import java.util.*;

public class BJ2110_S1_공유기설치 {
    static int N, C, ans;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for (int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());

        Arrays.sort(house);

        int start = house[0];
        int end = house[N - 1];
        int startIdx = 0;
        int endIdx = N - 1;
        ans = end - start;
        C -= 2;

        while (C-- > 0) {
            int midIdx = (startIdx + endIdx) / 2;
            int mid = (start + end) / 2;
        }
        // 모르겠....

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
