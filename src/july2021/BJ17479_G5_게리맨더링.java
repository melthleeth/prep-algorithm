package july2021;

import java.io.*;
import java.util.*;

public class BJ17479_G5_게리맨더링 {
    static int N, ans = -1;
    static int[] weight;
    static int[][] adj;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        weight = new int[N + 1];
        adj = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            weight[i] = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                adj[i][v] = 1;
            }
        }

        for (int i = 1; i <= N / 2; i++) {
            visited = new boolean[N + 1];
            divideConstituency(1,0, i);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static int isConnected(int depth, boolean status) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] checked = new boolean[N + 1];
        int cnt = 0, sum = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i] == status){
                q.offer(i);
                checked[i] = true;
                cnt++;
                sum += weight[i];
                break;
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int j = 1; j <= N; j++) {
                if (visited[j] != status || checked[j] || adj[v][j] == 0) continue;
                cnt++;
                sum += weight[j];
                checked[j] = true;
                q.offer(j);
            }
        }

        if (cnt == depth) return sum;
        return 0;
    }

    public static void divideConstituency(int start, int depth, int num) {
        if (depth == num) {
            int sum1 = isConnected(num, true);
            int sum2 = isConnected(N - num, false);

            if (sum1 > 0 && sum2 > 0) {
                if (ans == -1) ans = 10 * 100;
                ans = Math.min(ans, Math.abs(sum1 - sum2));
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            divideConstituency(i + 1,depth + 1, num);
            visited[i] = false;
        }
    }
}
