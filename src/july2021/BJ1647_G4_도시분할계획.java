package july2021;

import java.io.*;
import java.util.*;

public class BJ1647_G4_도시분할계획 {
    static int N, M, ans;
    static int[] root;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++)
            root[i] = i;

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Node(v1, v2, weight));
        }

        kruskal();
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void kruskal() {
        int cnt = 0;
        while(!pq.isEmpty()) {
            int v1 = pq.peek().v1;
            int v2 = pq.peek().v2;
            int weight = pq.peek().weight;
            pq.poll();

            if (find(v1) == find(v2)) continue;
            cnt++;
            if (cnt == N - 1) break;
            union(v1, v2);
            ans += weight;
        }
    }

    public static int find(int v) {
        if (root[v] == v) return v;
        else return root[v] = find(root[v]);
    }

    public static void union(int v1, int v2) {
        int root1 = find(v1);
        int root2 = find(v2);

        if (root1 < root2) root[root2] = root1;
        else root[root1] = root2;
    }

    static class Node {
        int v1;
        int v2;
        int weight;

        public Node(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
    }
}
