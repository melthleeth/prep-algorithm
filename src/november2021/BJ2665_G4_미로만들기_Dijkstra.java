package november2021;

import java.io.*;
import java.util.*;
import java.awt.*;

public class BJ2665_G4_미로만들기_Dijkstra {
    static int N;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static int[][] map;
    static boolean[][] visited;
    static int[][] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        cnt = new int[N][N];
        for (int[] col : cnt)
            Arrays.fill(col, 2500);
        cnt[0][0] = 0;

        for (int i = 0; i < N; i++) {
            String[] col = br.readLine().split("");

            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(col[j]);
        }

        solve();

//        for (int[] col : cnt)
//            System.out.println(Arrays.toString(col));

        bw.write(String.valueOf(cnt[N - 1][N - 1]));

        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point loc = q.poll();

            if (loc.x == N - 1 && loc.y == N - 1) continue;

            for (int d = 0; d < 4; d++) {
                int nx = loc.x + px[d];
                int ny = loc.y + py[d];

                if (!isIn(nx, ny)) continue;
                if (map[nx][ny] == 0) {
                    if (cnt[loc.x][loc.y] + 1 >= cnt[nx][ny]) continue;
                    cnt[nx][ny] = cnt[loc.x][loc.y] + 1;
                    q.offer(new Point(nx, ny));
                }
                else {
                    if (cnt[loc.x][loc.y] >= cnt[nx][ny]) continue;
                    cnt[nx][ny] = cnt[loc.x][loc.y];
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}
