package july2021;

import java.io.*;
import java.util.*;

public class BJ4485_G4_녹색옷입은애가젤다지 {
    static int N;
    static int[][] map, dist;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static final int INF = 10 * 125;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int idx = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N + 2][N + 2];
            dist = new int[N + 2][N + 2];

            for (int i = 0; i < N + 2; i++)
                Arrays.fill(dist[i], INF);

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            Dijkstra();
            bw.write("Problem " + idx++ + ": " + dist[N][N] + "\n");
        }
        br.close();
        bw.close();
    }

    public static void Dijkstra() {
        Queue<Coord> q = new LinkedList<>();
        q.offer(new Coord(1, 1));
        dist[1][1] = map[1][1];

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for (int d = 0; d < 4; d++){
                int nx = x + px[d];
                int ny = y + py[d];

                if (!isIn(nx, ny)) continue;
                if(dist[nx][ny] > dist[x][y] + map[nx][ny]) {
                    dist[nx][ny] = Math.min(dist[nx][ny], dist[x][y] + map[nx][ny]);
                    q.offer(new Coord(nx, ny));
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > N) return false;
        return true;
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
