package july2021;

import java.io.*;
import java.util.*;

// 음수 사이클 존재하면 -1
// 아니면 1번 기준

public class BJ11657_G4_타임머신 {
    static int N, M;
    static long[] dist;
    static long[][] adj;
    static final int INF = 500 * 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new long[N + 1][N + 1];
        for (long[] arr : adj)
            Arrays.fill(arr, INF);
        ;
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[from][to] = Math.min(adj[from][to], weight);
        }

        if (!BellmanFord()) bw.write("-1");
        else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) bw.write("-1\n");
                else bw.write(dist[i] + "\n");
            }
        }

        br.close();
        bw.close();
    }

    public static boolean BellmanFord() {
        boolean updated = false;

        for (int n = 0; n < N - 1; n++) {
            updated = false;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i] == INF) continue; // 이 조건을 추가해야 60%에서 통과함!!!
                    if (dist[i] + adj[i][j] < dist[j]) {
                        updated = true;
                        dist[j] = Math.min(dist[i] + adj[i][j], dist[j]);
                    }
                }
            }
            if (!updated) break;
        }

        if (updated) {
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dist[i] + adj[i][j] < dist[j]) return false;
        }

        return true;
    }
}
