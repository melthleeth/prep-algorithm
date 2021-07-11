package july2021;

import java.io.*;
import java.util.*;

public class BJ1865_G4_웜홀 {
    static int TC, N, M, W;
    static int[][] adj;
    static int[] dist;
    static final int INF = 2500 * 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            Arrays.fill(dist, INF);
            dist[0] = dist[1] = 0;
            adj = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++)
            Arrays.fill(adj[i], INF);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[from][to] = Math.min(adj[from][to], d);
                adj[to][from] = adj[from][to];
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                adj[from][to] = -d;
            }

            if (BellmanFord()) bw.write("YES\n");
            else bw.write("NO\n");
        }
        br.close();
        bw.close();
    }

    public static boolean BellmanFord() {
        // 1을 무조건 시작지점으로
        // |N-1|번 edge relaxation 수행
        // 더이상 업데이트가 일어나지 않으면 for loop를 끝내도 된다.
        boolean updated = false;
        for (int n = 0; n < N - 1; n++) {
            updated = false;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i] + adj[i][j] < dist[j]) {
                        dist[j] = dist[i] + adj[i][j];
                        updated = true;
                    }
                }
            }
            if (!updated) break;
        }

        if (updated) {
            for (int i = 1; i <= N; i++)
                for (int j = 1; j <= N; j++)
                    if (dist[i] + adj[i][j] < dist[j]) return true;
        }

        return false;
    }
}
