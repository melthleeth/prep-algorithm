package july2021;

import java.io.*;
import java.util.*;

public class BJ16198_S1_에너지모으기 {
    static int N;
    static long ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        solve(0, 0);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    // for문 안에 left, right 찾기를 해야함
    // 백트래킹 form으로 가기
    public static void solve(int cnt, long sum) {
        if (cnt == N - 2) {
            ans = Math.max(sum, ans);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (visited[i]) continue;

            int left = i, right = i;
            while (left-- > 0) {
                if (!visited[left]) break;
            }

            while (right++ < N - 1) {
                if (!visited[right]) break;
            }

            visited[i] = true;
            solve(cnt + 1, sum + (arr[left] * arr[right]));
            visited[i] = false;
        }
    }
}
