package july2021;

import java.io.*;
import java.util.*;

public class BJ11404_G4_플로이드 {
    static int M, N;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            Arrays.fill(dist[i], 100 * 100000);

        for (int i = 1; i <= N; i++)
            dist[i][i] = 0;

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            dist[from][to] = Math.min(d, dist[from][to]);
        }

        for (int via = 1; via <= N; via++) {
            for (int from = 1; from <= N; from++) {
                for (int to = 1; to <= N; to++) {
                    dist[from][to] = Math.min(dist[from][via] + dist[via][to], dist[from][to]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] == 100 * 100000) dist[i][j] = 0;
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
