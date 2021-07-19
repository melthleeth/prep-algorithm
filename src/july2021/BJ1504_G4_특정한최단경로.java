package july2021;

import java.io.*;
import java.util.*;

public class BJ1504_G4_특정한최단경로 {
    static int N, E, X, Y;
    static int[][] dist;
    static final int INF = 800 * 1000;
    static ArrayList<Node>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            arr[i] = new ArrayList<>();

        dist = new int[3][N + 1];
        for (int i = 0; i < 3; i++)
            Arrays.fill(dist[i], INF);

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr[from].add(new Node(to, weight));
            arr[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        solve(0, 1);
        solve(1, X);
        solve(2, Y);

        int ans1 = dist[0][X] + dist[1][Y] + dist[2][N];
        int ans2 = dist[0][Y] + dist[2][X] + dist[1][N];

        if (dist[0][X] != INF && dist[1][Y] != INF && dist[2][N] != INF) {
            if (dist[0][Y] != INF && dist[2][X] != INF && dist[1][N] != INF)
                bw.write(String.valueOf(Math.min(ans1, ans2)));
            else bw.write(String.valueOf(ans1));
        } else if (dist[0][Y] != INF && dist[2][X] != INF && dist[1][N] != INF) bw.write(ans2);
        else bw.write(String.valueOf(-1));

        br.close();
        bw.close();
    }

    public static void solve(int idx, int initNode) {
        dist[idx][initNode] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
        // weight 초기화
        for (int i = 0; i < arr[initNode].size(); i++) {
            Node node = arr[initNode].get(i);
            dist[idx][node.to] = node.weight;
            pq.offer(new Node(node.to, node.weight));
        }

        // Dijkstra
        while (!pq.isEmpty()) {
            int from = pq.peek().to;
            pq.poll();

            for (int i = 0; i < arr[from].size(); i++) {
                int to = arr[from].get(i).to;
                int weight = arr[from].get(i).weight;
                if (dist[idx][to] > dist[idx][from] + weight) {
                    dist[idx][to] = dist[idx][from] + weight;
                    pq.offer(new Node(to, weight));
                }
            }
        }
    }

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
