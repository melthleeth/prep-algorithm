package july2021;

import java.io.*;
import java.util.*;

public class BJ1525_G2_퍼즐 {
    static int ans;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static int[][] map = new int[4][4];
    static Queue<Coord> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) q.offer(new Coord(i, j, 0));
            }
        }
        solve();

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void solve() {
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int cnt = q.peek().cnt;

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];
                if (!isIn(nx, ny)) continue;
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 1 || x > 3 || y < 1 || y > 3) return false;
        return true;
    }

    public static boolean isMatch() {
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++)
                if (map[i][j] != (i - 1) * 3 + j) return false;

        return true;
    }

    static class Coord {
        int x;
        int y;
        int cnt;

        public Coord(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
