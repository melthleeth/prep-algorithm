package december2021;

import java.io.*;
import java.util.*;

public class BJ2056_G4_작업 {
    static int N, maxValue;
    static int[] inDegree, times, node;
    static TreeSet<Integer>[] set;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        inDegree = new int[N + 1];
        times = new int[N + 1];
        node = new int[N + 1];

        set = new TreeSet[N + 1];
        for (int i = 1; i <= N; i++)
            set[i] = new TreeSet<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken());
            node[i] = times[i];

            int cnt = Integer.parseInt(st.nextToken());

            if (cnt == 0) {
                q.offer(i);
                continue;
            }

            inDegree[i] = cnt;

            for (int j = 0; j < cnt; j++) {
                int from = Integer.parseInt(st.nextToken());
                set[from].add(i);
            }
        }

        while (!q.isEmpty()) {
            int from = q.poll();

            for (int to : set[from]) {
                node[to] = Math.max(node[to], node[from] + times[to]);
                inDegree[to]--;
                if (inDegree[to] == 0) {
                    q.offer(to);
                }
            }
        }

        for (int time : node)
            maxValue = Math.max(maxValue, time);

        bw.write(String.valueOf(maxValue));
        br.close();
        bw.close();
    }
}
