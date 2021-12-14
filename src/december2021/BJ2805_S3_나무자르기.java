package december2021;

import java.io.*;
import java.util.*;

public class BJ2805_S3_나무자르기 {
    static int N, M, ans;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];
        int start = 1, mid = 0, end = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            end = Math.max(end, tree[i]);
        }

        while(start <= end) {
            mid = (start + end) / 2;
            long sum = getSum(mid);

            if (sum >= M) {
                start = mid + 1;
                ans = Math.max(ans, mid);
            }
            else end = mid - 1;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static long getSum(int height) {
        long sum = 0l;

        for (int t : tree) {
            int left = t - height > 0 ? t - height : 0;
            sum += left;
        }

        return sum;
    }
}
