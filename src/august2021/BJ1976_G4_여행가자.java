package august2021;

import java.io.*;
import java.util.*;

// 다익스트라를 노드 갯수만큼 돌림 -> 경로 판단
public class BJ1976_G4_여행가자 {
    static int N, M;
    static String ans = "YES";
    static int[][] adj, dist;
    static int[] route;
    static Set<Integer> cities = new HashSet<>();
    static final int INF = 40000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        adj = new int[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        route = new int[M];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
                adj[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int city = Integer.parseInt(st.nextToken());
            cities.add(city);
            route[i] = city;
        }

        for (Integer city : cities) {
            Arrays.fill(dist[city], INF);
            Dijkstra(city);
        }

        for (int i = 0; i < M - 1; i++) {
            int from = route[i];
            int to = route[i + 1];

            if (dist[from][to] == INF) {
                ans = "NO";
                break;
            }
        }

        bw.write(ans);
        br.close();
        bw.close();
    }

    public static void Dijkstra(int idx) {
        dist[idx][idx] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);

        while(!q.isEmpty()) {
            int from = q.poll();

            for (int to = 1; to <= N; to++) {
                if (adj[from][to] == 0) continue;
                if (dist[idx][from] + adj[from][to] < dist[idx][to]) {
                    dist[idx][to] = dist[idx][from] + adj[from][to];
                    q.offer(to);
                }
            }
        }
    }
}
