package july2021;

import java.io.*;
import java.util.*;

public class BJ1939_G4_중량제한 {
    static int N, M, A, B, start, end;
    static ArrayList<Node> node[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
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
            end = Math.max(end, weight);
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        while (start <= end) {
            int mid = (start + end) / 2;
            if (BFS(mid)) start = mid + 1;
            else end = mid - 1;
        }
        bw.write(String.valueOf(end));
        br.close();
        bw.close();
    }

    public static boolean BFS(int limit) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        q.offer(A);
        visited[A] = true;

        while (!q.isEmpty()) {
            int front = q.poll();
            if (front == B) return true;

            for (int i = 0; i < node[front].size(); i++) {
                int to = node[front].get(i).to;
                int weight = node[front].get(i).weight;
                if (visited[to] || weight < limit) continue;
                visited[to] = true;
                q.offer(to);
            }

        }
        return false;
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
