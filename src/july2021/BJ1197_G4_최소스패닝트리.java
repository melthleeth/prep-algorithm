package july2021;

import java.io.*;
import java.util.*;

// visited 배열로 체크하는건 V * (V - 1) < 400MB 여서 메모리 초과.
// 그래서 kruskal 쓸거면 union-find를 써야함

public class BJ1197_G4_최소스패닝트리 {
    static int V, E;
    static long ans;
    static int[] root;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // make set
        root = new int[V + 1];
        for (int i = 1; i <= V; i++)
            root[i] = i;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            pq.offer(new Node(from, to, weight));
        }

        Kruskal();
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void Kruskal() {
        while (!pq.isEmpty()) {
            int from = pq.peek().from;
            int to = pq.peek().to;
            int weight = pq.peek().weight;
            pq.poll();

            if (find(from) == find(to)) continue;
            ans += weight;
            union(from, to);
        }
    }

    public static int find(int n) {
        if (n == root[n]) return n;
        else return root[n] = find(root[n]);
    }

    public static void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);
        if (root1 < root2) root[root2] = root1;
        else root[root1] = root2;
    }

    static class Node {
        int from;
        int to;
        int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
