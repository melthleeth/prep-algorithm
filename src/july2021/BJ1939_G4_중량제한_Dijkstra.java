package july2021;

import java.io.*;
import java.util.*;

public class BJ1939_G4_중량제한_Dijkstra {
    static int N, M, A, B;
    static int[] dist;
    static ArrayList<Node> node[];
    static final int INF = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        node = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            node[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            node[from].add(new Node(to, weight));
            node[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Dijkstra();

        bw.write(String.valueOf(dist[B]));
        br.close();
        bw.close();
    }

    public static void Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o2.weight - o1.weight));
        pq.offer(new Node(A, INF));
        dist[A] = INF;
        while (!pq.isEmpty()) {
            int from = pq.peek().to;
            int weight = pq.peek().weight;
            pq.poll();
            if (dist[from] > weight) continue; // 이미 중량이 크면 update할 필요가 없으므로

            for (int i = 0; i < node[from].size(); i++) {
                int to = node[from].get(i).to;
                int weightTo = Math.min(weight, node[from].get(i).weight);
                if (weightTo > dist[to]) {
                    dist[to] = weightTo;
                    pq.offer(new Node(to, weightTo));
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
