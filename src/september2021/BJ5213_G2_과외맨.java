package september2021;

import java.io.*;
import java.util.*;

public class BJ5213_G2_과외맨 {
    static int N;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[][] map, tileIdx;
    static boolean[][] visited;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static Stack<Integer> route = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N * 2];
        tileIdx = new int[N][N * 2 + 1];
        visited = new boolean[N][N * 2];

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

        solve();

        bw.write(ans.size() + "\n");
        for (Integer tileNum : ans)
            bw.write(tileNum + " ");

        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Tile> q = new LinkedList<>();
        int maxTileIdx = 0;
        ArrayList<Integer> initRoute = new ArrayList<>();
        initRoute.add(1);
        q.offer(new Tile(0, 0, initRoute));
        q.offer(new Tile(0, 1, initRoute));
        visited[0][0] = true;
        visited[0][1] = true;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            ArrayList<Integer> route = q.peek().route;
            q.poll();

            if (tileIdx[x][y] > maxTileIdx) {
                maxTileIdx = tileIdx[x][y];
                ans = route;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];

                if (!isIn(nx, ny) || visited[nx][ny] || tileIdx[nx][ny] == 0) continue;

                if (map[x][y] == map[nx][ny]) {
                    visited[nx][ny] = true;
                    ArrayList<Integer> nextRoute = new ArrayList<>();
                    nextRoute.addAll(route);
                    nextRoute.add(tileIdx[nx][ny]);
                    q.offer(new Tile(nx, ny, nextRoute));

                    for (int k = 1; k < 4; k += 2) {
                        int sideX = nx + px[k];
                        int sideY = ny + py[k];
                        if (tileIdx[sideX][sideY] == tileIdx[nx][ny]) {
                            visited[sideX][sideY] = true;
                            q.offer(new Tile(sideX, sideY, nextRoute));
                        }
                    }
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= 2 * N) return false;
        return true;
    }

    static class Tile {
        int x;
        int y;
        ArrayList<Integer> route;

        public Tile(int x, int y, ArrayList<Integer> route) {
            this.x = x;
            this.y = y;
            this.route = route;
        }
    }
}
