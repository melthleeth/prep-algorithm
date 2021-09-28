package september2021;

import java.io.*;
import java.util.*;

public class BJ15724_S1_주지수 {
    // 누적합 문제 - 근데 왜 내자마자 틀리냐? - long 썼는데도 틀려 - 아 점화식 잘못세움;; 바보냐
    static int N, M, K;
    static long[][] arr, sum;
    static Queue<Coord> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new long[N + 1][M + 1];
        sum = new long[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = arr[i][j] + sum[i][j - 1];
            }
        }

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                sum[i][j] += sum[i - 1][j];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            q.offer(new Coord(sx, sy, ex, ey));
        }

        while (!q.isEmpty()) {
            Coord coord = q.poll();
            bw.write(String.valueOf(
                    sum[coord.ex][coord.ey]
                            - (sum[coord.ex][coord.sy - 1] + sum[coord.sx - 1][coord.ey])
                            + sum[coord.sx - 1][coord.sy - 1]
            ));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    static class Coord {
        int sx;
        int sy;
        int ex;
        int ey;

        public Coord(int sx, int sy, int ex, int ey) {
            this.sx = sx;
            this.sy = sy;
            this.ex = ex;
            this.ey = ey;
        }
    }
}
