package july2021;
import java.io.*;
import java.util.*;

public class BJ14496_S1_그대그머가되어 {
    // 단방향 그래프가 아닌듯?
    // 간선간 거리 1인 다익스트라
    static int a, b, N, M;
    static int[] dist;
    static ArrayList<Integer> arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, 11111);
        dist[0] = dist[a] = 0;

        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
            arr[to].add(from);

            if (from == a) dist[to] = 1;
        }

        solve();
        if (dist[b] == 11111) dist[b] = -1;
        bw.write(String.valueOf(dist[b]));
        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        boolean[] visited = new boolean[N + 1];
        visited[a] = true;

        while(!q.isEmpty()) {
            int front = q.poll();

            for (int i = 0; i < arr[front].size(); i++) {
                int node = arr[front].get(i);
                if (visited[node]) continue;
                visited[node] = true;
                dist[node] = Math.min(dist[front] + 1, dist[node]);
                q.offer(node);
            }
        }
    }
}
