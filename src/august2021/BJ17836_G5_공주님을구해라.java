package august2021;

import java.io.*;
import java.util.*;

public class BJ17836_G5_공주님을구해라 {
    static int N, M, T, ans;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        solve();

        if (ans > 0) bw.write(String.valueOf(ans));
        else bw.write("Fail");
        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Warrior> q = new LinkedList<>();
        q.offer(new Warrior(0, 0, 0, 0));

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int sword = q.peek().sword;
            int cnt = q.peek().cnt;
            q.poll();

            if (cnt > T) break;
            if (x == N - 1 && y == M - 1) {
                ans = cnt;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];

                if (!isIn(nx, ny)) continue;
                if (map[nx][ny] == 2) {
                    visited[sword][nx][ny] = true;
                    map[nx][ny] = 0;
                    q.offer(new Warrior(nx, ny, 1, cnt + 1));
                } else if ((map[nx][ny] == 1 && sword == 1 && !visited[sword][nx][ny])
                        || (map[nx][ny] == 0 && !visited[sword][nx][ny])) {
                    visited[sword][nx][ny] = true;
                    q.offer(new Warrior(nx, ny, sword, cnt + 1));
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

    static class Warrior {
        int x;
        int y;
        int sword;
        int cnt;

        public Warrior(int x, int y, int sword, int cnt) {
            this.x = x;
            this.y = y;
            this.sword = sword;
            this.cnt = cnt;
        }
    }
}
