package july2021;

import java.io.*;
import java.util.*;

public class BJ16198_S1_에너지모으기 {
    static int N;
    static long maxValue, ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N - 1; i++) {
            visited = new boolean[N];
            visited[i] = true;
            solve(i, 0);
            ans = Math.max(ans, maxValue);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void solve(int n, long sum) {
        int left = n, right = n;

        while(left-- > 0) {
            if (!visited[left]) break;
        }

        while(right++ < N - 1) {
            if (!visited[right]) break;
        }
        System.out.println("left, right = " + arr[left] + ", " + arr[right]);
        if (left == 0 && right == N - 1) {
            System.out.println("끝: " + (sum + arr[left] * arr[right]));
            maxValue = Math.max(maxValue, sum + arr[left] * arr[right]);
            return;
        }

        visited[n] = true;
        if (left == 0) solve(right, (sum + arr[left] * arr[right]));
        else if (right == N - 1) solve(left, (sum + arr[left] * arr[right]));
        else {
            solve(left, (sum + arr[left] * arr[right]));
            solve(right, (sum + arr[left] * arr[right]));
        }
        visited[n] = false;
    }
}
