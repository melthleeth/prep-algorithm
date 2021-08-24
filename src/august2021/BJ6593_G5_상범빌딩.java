package august2021;

import java.io.*;
import java.util.*;

public class BJ6593_G5_상범빌딩 {
    static int L, R, C, ans;
    static Coord S, E;
    static String[][] building;
    static boolean[][][] visited;
    static int[] px = new int[]{1, 0, -1, 0, 0, 0};
    static int[] py = new int[]{0, 1, 0, -1, 0, 0};
    static int[] pz = new int[]{0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0) break;

            ans = 0;
            building = new String[L][R];
            visited = new boolean[L][R][C];
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    building[k][i] = br.readLine();
                    for (int j = 0; j < C; j++) {
                        if (building[k][i].charAt(j) == 'S') S = new Coord(i, j, k);
                        if (building[k][i].charAt(j) == 'E') E = new Coord(i, j, k);
                    }
                }
                br.readLine();
            }
            solve();
            if (ans > 0) bw.write("Escaped in " + ans + " minute(s).");
            else bw.write("Trapped!");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Coord> q = new LinkedList<>();
        q.offer(new Coord(S.x, S.y, S.z, 0));
        visited[S.z][S.x][S.y] = true;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int z = q.peek().z;
            int cnt = q.peek().cnt;
//            System.out.println(q.peek().toString());
            q.poll();


            if (x == E.x && y == E.y && z == E.z) {
                ans = cnt;
                break;
            }

            for (int d = 0; d < 6; d++) {
                int nx = x + px[d];
                int ny = y + py[d];
                int nz = z + pz[d];
//                System.out.println("nx=" + nx + ", ny=" + ny + ", nz=" + nz);

                if (!isIn(nx, ny, nz) || visited[nz][nx][ny] || building[nz][nx].charAt(ny) == '#') continue;
                visited[nz][nx][ny] = true;
                q.offer(new Coord(nx, ny, nz, cnt + 1));
            }
        }
    }

    public static boolean isIn(int x, int y, int z) {
        if (x < 0 || x >= R || y < 0 || y >= C || z < 0 || z >= L) return false;

        return true;
    }

    static class Coord {
        int x;
        int y;
        int z;
        int cnt;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Coord(int x, int y, int z, int cnt) {
            this(x, y, z);
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            return "x=" + x +
                    ", y=" + y +
                    ", z=" + z +
                    ", cnt=" + cnt;
        }
    }
}
