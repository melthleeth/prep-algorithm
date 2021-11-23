package november2021;

import java.io.*;
import java.util.*;

public class BJ2665_G4_미로만들기 {
    static int N;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] col = br.readLine().split("");

            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(col[j]);
        }

        bw.write(String.valueOf(solve()));
        br.close();
        bw.close();
    }

    public static int solve() {
        PriorityQueue<Location> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
        pq.offer(new Location(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Location loc = pq.poll();

            if (loc.x == N - 1 && loc.y == N - 1) return loc.cnt;

            for (int d = 0; d < 4; d++) {
                int nx = loc.x + px[d];
                int ny = loc.y + py[d];

                if (!isIn(nx, ny) || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (map[nx][ny] == 0)
                    pq.offer(new Location(nx, ny, loc.cnt + 1));
                else
                    pq.offer(new Location(nx, ny, loc.cnt));
            }
        }
        return 0;
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }

    static class Location {
        int x;
        int y;
        int cnt;

        public Location(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
