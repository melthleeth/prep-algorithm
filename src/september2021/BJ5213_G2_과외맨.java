package september2021;

import java.io.*;
import java.util.*;

public class BJ5213_G2_과외맨 {
    static int N, ans;
    static int[][] map, tileIdx, visited;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N * 2];
        tileIdx = new int[N][N * 2];
        visited = new int[N][N * 2];

        int idx = 1;
        for (int i = 0; i < N; i++) {
            int start = (i & 1) == 0 ? 0 : 1;
            int end = (i & 1) == 0 ? 2 * N : 2 * N - 1;

            for (int j = start; j < end; j += 2) {
                st = new StringTokenizer(br.readLine());
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                map[i][j] = left;
                map[i][j + 1] = right;
                tileIdx[i][j] = idx;
                tileIdx[i][j + 1] = idx;
                idx++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Tile> q = new LinkedList<>();
        q.offer(new Tile(0, 1, 1, 1));
        visited[0][0] = 1;
        visited[0][1] = 1;

        while(!q.isEmpty()) {
          int x = q.peek().x;
          int y = q.peek().y;
          int idx = q.peek().idx;
          int cnt = q.peek().cnt;
          q.poll();

          if ((x & 1) == 0 && (y & 1) == 0) {
              if (isIn(x, y + 1)) {

              }
          }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= 2 * N || y < 0 || y >= 2 * N) return false;
        return true;
    }

    static class Tile {
        int x;
        int y;
        int idx;
        int cnt;

        public Tile(int x, int y, int idx, int cnt) {
            this.x = x;
            this.y = y;
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
