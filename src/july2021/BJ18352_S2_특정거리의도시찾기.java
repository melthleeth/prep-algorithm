package july2021;
import java.util.*;
import java.io.*;

public class BJ18352_S2_특정거리의도시찾기 {
    // 단방향 그래프
    // 오름차순으로 출력, 하나도 없으면 -1
    static int N, M, K, X; // 도시(vertex) 개수, 도로(edge) 개수, 거리정보, 출발점
    static int[] dist;
    static ArrayList<Integer>[] city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, 333333);
        dist[0] = dist[X] = 0;
        city = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            city[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            city[from].add(to);

            if (from == X) dist[to] = 1;
        }

        solve();
        print();
        br.close();
    }

    public static void solve() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(X);
        boolean[] visited = new boolean[N + 1];
        visited[X] = true;

        while(!q.isEmpty()) {
            int front = q.poll();

            for (int i = 0; i < city[front].size(); i++) {
                int node = city[front].get(i);
                if (visited[node]) continue;
                visited[node] = true;
                dist[node] = Math.min(dist[front] + 1, dist[node]);
                q.offer(node);
            }
        }
    }

    public static void print() {
        boolean flag = false;
//        System.out.println(Arrays.toString(dist));
        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                flag = true;
                System.out.println(i);
            }
        }
        if (!flag) System.out.println(-1);
    }
}
