package july2021;

import java.io.*;
import java.util.*;

public class BJ1916_G5_최소비용구하기 {
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Node> node[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        dist = new int[N + 1];
        Arrays.fill(dist, 1000 * 100000);
        dist[0] = 0;
        node = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++)
            node[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node[from].add(new Node(to, weight));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        Dijkstra();

        bw.write(String.valueOf(dist[end]));
        br.close();
        bw.close();
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
        dist[start] = 0;

        // initialization
        for (int i = 0; i < node[start].size(); i++) {
            int to = node[start].get(i).to;
            int weight = node[start].get(i).weight;
            dist[to] = Math.min(weight, dist[to]);
            pq.offer(new Node(to, weight));
        }

        while (!pq.isEmpty()) {
            int from = pq.peek().to;
            int weight = pq.peek().weight;
            pq.poll();
            if (dist[from] < weight) continue; // adj matrix일땐 자동으로 됐었는데 ArrayList라 큰값 처리를 이렇게 해줘야 한다!

            for (int i = 0; i < node[from].size(); i++) {
                int to = node[from].get(i).to;
                weight = node[from].get(i).weight;

                if (dist[to] > dist[from] + weight) {
                    dist[to] = dist[from] + weight;
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
