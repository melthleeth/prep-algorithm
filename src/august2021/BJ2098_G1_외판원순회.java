package august2021;

import java.io.*;
import java.util.*;

// 비트마스크, 그리고 남은 방문하지 않은 도시들을 방문하는 최소비용을 저장하는 배열이라니... 넘 어렵다 ㅠ 솔루션 보고 거의 베낌...
// 왜틀린거지 - visitedAll을 미리 저장해서 틀린느낌?;; (1 << N) - 1을 그대로 대입하니 맞았다...

public class BJ2098_G1_외판원순회 {
    static int N;
    static int[][] W;
    static int[][] dist;
    static final int INF = 1000000 * 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        dist = new int[N][(1 << N) - 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                W[i][j] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(travel(0, 1)));
        br.close();
        bw.close();
    }

    public static int travel(int current, int visited) {
        if (visited == (1 << N) - 1)
            return W[current][0] == 0 ? INF : W[current][0];

        if (dist[current][visited] != INF) return dist[current][visited];

        for (int i = 0; i < N; i++) {
            int next = 1 << i;
            if ((visited & next) != 0 || W[current][i] == 0) continue;
            dist[current][visited] = Math.min(dist[current][visited], travel(i, visited | next) + W[current][i]);
        }
        return dist[current][visited];
    }
}
