package july2021;

import java.io.*;
import java.util.*;

// 나이트 규칙: 두칸 간다음 양옆 아무곳
public class BJ1600_G4_말이되고픈원숭이 {
    static int K, W, H, ans = 50000;
    static int[] px = new int[]{1, 0, -1, 0, 1, 2, 2, 1, -1, -2, -2, -1}; // 0~3: 일반, 4~11: 나이트
    static int[] py = new int[]{0, 1, 0, -1, 2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[W][H];
        visited = new boolean[W][H][K + 1];

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < H; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        solve();
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Monkey> q = new LinkedList<>();
        q.offer(new Monkey(0, 0, K, 0));
        visited[0][0][K] = true;

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int k = q.peek().k;
            int cnt = q.peek().cnt;
            q.poll();

            if (x == W - 1 && y == H - 1) ans = Math.min(ans, cnt);

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];

                if (!isIn(nx, ny) || visited[nx][ny][k]) continue;
                visited[nx][ny][k] = true;
                q.offer(new Monkey(nx, ny, k, (cnt + 1)));
            }
            if (k > 0) {
                for (int d = 4; d < 12; d++) {
                    int nx = x + px[d];
                    int ny = y + py[d];

                    if (!isIn(nx, ny) || visited[nx][ny][k - 1]) continue;
                    visited[nx][ny][k - 1] = true;
                    q.offer(new Monkey(nx, ny, k - 1, (cnt + 1)));
                }
            }
        }
        if (ans == 50000) ans = -1;
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= W || y < 0 || y >= H || map[x][y] == 1) return false;
        return true;
    }

    static class Monkey {
        int x;
        int y;
        int k;
        int cnt;

        public Monkey(int x, int y, int k, int cnt) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }
}
