package december2021;

import java.io.*;
import java.util.*;

public class BJ2252_G3_줄세우기 {
    static int N, M;
    static int[] indegree;
    static TreeSet<Integer>[] set;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int[N + 1];
        set = new TreeSet[N + 1];
        for (int i = 0; i <= N; i++)
            set[i] = new TreeSet<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            set[from].add(to);
            indegree[to]++;
        }

        for (int i = 1; i <= N; i++)
            if (indegree[i] == 0)
                pq.offer(i);

        while (!pq.isEmpty()) {
            int from = pq.poll();
            bw.write(from + " ");

            for (int to : set[from]) {
                indegree[to]--;
                if (indegree[to] == 0) pq.offer(to);
            }
        }

        br.close();
        bw.close();
    }
}
