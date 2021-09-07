package september2021;

import java.io.*;
import java.util.*;

public class BJ5213_G2_과외맨_X {
    static int N, ans;
    static int[][] map, tileIdx, visited;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static Stack<Integer> route = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N * 2];
        tileIdx = new int[N][N * 2];
        visited = new int[N][N * 2];
        ans = N * N;

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

        bw.write(ans + "\n");
        while (!route.isEmpty()) bw.write(route.pop() + " ");

        br.close();
        bw.close();
    }

    public static void getRoute(int sx, int sy) {
        PriorityQueue<Tile> q = new PriorityQueue<>((o1, o2) -> (o2.idx - o1.idx));
        Set<Integer> isDuplicated = new HashSet<>();
        ans = visited[sx][sy];
        boolean[] check = new boolean[ans + 1];
        check[ans] = true;
        isDuplicated.add(tileIdx[sx][sy]);
        q.offer(new Tile(sx, sy, visited[sx][sy]));
        visited[sx][sy] = 0;
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int idx = q.peek().idx;
//            System.out.println("x, y, idx = " + x + ", " + y + ", " + idx);
            q.poll();

            if (x == 0 && y == 1) break;

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];
                if (!isIn(nx, ny) || visited[nx][ny] == 0) continue;
                int nIdx = visited[nx][ny];
                if (idx == nIdx && (d == 0 || d == 2)) continue;
//                System.out.println("nx, ny, idx = " + nx + ", " + ny + ", " + nIdx);
                if (idx - nIdx == 1 || (idx == nIdx && (d == 1 || d == 3))) {
                    if (check[nIdx] && idx != nIdx) continue;
                    check[nIdx] = true;
                    q.offer(new Tile(nx, ny, nIdx));
                    if (!isDuplicated.contains(tileIdx[nx][ny])) {
//                        System.out.println("# nx, ny, idx = " + nx + ", " + ny + ", " + nIdx);
                        isDuplicated.add(tileIdx[nx][ny]);
                        route.push(tileIdx[nx][ny]);
                    }
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    public static void solve() {
        Queue<Tile> q = new LinkedList<>();
        q.offer(new Tile(0, 1, 1, 1));
        visited[0][0] = 1;
        visited[0][1] = 1;
        int maxTileIdx = 0, ex = 0, ey = 0;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int idx = q.peek().idx;
            int cnt = q.peek().cnt;
            q.poll();

//            System.out.println("x, y, idx, cnt = " + x + ", " + y + ", " + idx + ", " + cnt);

            if (tileIdx[x][y] > maxTileIdx) {
                maxTileIdx = tileIdx[x][y];
                ex = x;
                ey = y;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];
//                System.out.println("nx, ny = " + nx + ", " + ny);
//            System.out.println("nx & 1, ny & 1 = " + (nx & 1) + ", " + (ny & 1));

                if (!isIn(nx, ny) || visited[nx][ny] != 0 || tileIdx[nx][ny] == 0) continue;

                if (d == 1 && (((x & 1) == 0 && (y & 1) == 0) || ((x & 1) == 1 && (y & 1) == 1))) {
//                    System.out.println("case 1");
                    visited[nx][ny] = cnt;
                    q.offer(new Tile(nx, ny, idx, cnt));
                } else if (d == 3 && (((x & 1) == 0 && (y & 1) == 1) || ((x & 1) == 1 && (y & 1) == 0))) {
//                    System.out.println("case 2");
                    visited[nx][ny] = cnt;
                    q.offer(new Tile(nx, ny, idx, cnt));
                } else if (map[x][y] == map[nx][ny]) {
//                    System.out.println("case 3");
                    visited[nx][ny] = cnt + 1;
                    q.offer(new Tile(nx, ny, tileIdx[nx][ny], cnt + 1));
                }
            }
        }
//        print();
        route.push(tileIdx[ex][ey]);
        getRoute(ex, ey);
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N; j++)
                System.out.printf("%4d", visited[i][j]);
            System.out.println();
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= 2 * N) return false;
        return true;
    }

    static class Tile {
        int x;
        int y;
        int idx;
        int cnt;

        public Tile(int x, int y, int idx) {
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

        public Tile(int x, int y, int idx, int cnt) {
            this(x, y, idx);
            this.cnt = cnt;
        }
    }
}
