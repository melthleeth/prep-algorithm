package august2021;

import java.io.*;
import java.util.*;

public class BJ1150_D4_백업 {
    static int N, K, ans;
    static int[] dist, left, right;
    static boolean[] visited;
    static PriorityQueue<Company> pq = new PriorityQueue<>((o1, o2) -> (o1.d - o2.d));
    static final int INF = 1000000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 2];
        dist = new int[N + 2];
        left = new int[N + 2];
        right = new int[N + 2];

        // 양 끝: 1, N + 1
        // dist[N] = N - 1 ~ N 사이의 거리
        dist[1] = dist[N + 1] = INF;
        right[1] = 2;
        left[N + 1] = N;
        // init
        pq.offer(new Company(INF, 1));
        pq.offer(new Company(INF, N + 1));

        int prev = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            int next = Integer.parseInt(br.readLine());
            int d = next - prev;
            left[i] = i - 1;
            right[i] = i + 1;
            dist[i] = d;
            pq.offer(new Company(d, i));
            prev = next;
        }

        while (K-- > 0) {
            while(visited[pq.peek().idx]) {
                pq.poll();
            }
            int d = pq.peek().d;
            int idx = pq.peek().idx;
            pq.poll();

            ans += d;
            visited[left[idx]] = true;
            visited[right[idx]] = true;
            dist[idx] = dist[left[idx]] + dist[right[idx]] - dist[idx];
            pq.offer(new Company(dist[idx], idx));

            // 현재 위치 left, right는 그 다음 idx를 바라보게 하고
            left[idx] = left[left[idx]];
            right[idx] = right[right[idx]];
            // d를 더했기 때문에 왼쪽의 right idx는 idx로 땡겨주고
            right[left[idx]] = idx;
            // 오른쪽의 left idx는 idx로 줄여준다.
            left[right[idx]] = idx;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    static class Company {
        int d;
        int idx;

        public Company(int d, int idx) {
            this.d = d;
            this.idx = idx;
        }
    }
}
