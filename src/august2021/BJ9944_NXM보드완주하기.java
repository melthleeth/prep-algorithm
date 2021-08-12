package august2021;

import java.io.*;
import java.util.*;

public class BJ9944_NXM보드완주하기 {
    static int N, M, ans = 1000001, emptySpace;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;
    static int[][] footstep;
    static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int idx = 1;
        String str = "";
        while ((str = br.readLine()) != null) {

            st = new StringTokenizer(str);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            emptySpace = 0;
            ans = MAX;

            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();

                for (int j = 0; j < M; j++)
                    if (map[i][j] == '.') emptySpace++;
            }

//            System.out.println("empty spaces: " + emptySpace);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == '*') continue;
                    footstep = new int[N][M];
                    footstep[i][j] = 1;
                    visited = new boolean[N][M];
                    visited[i][j] = true;
                    solve(i, j, 1, 0);
                }
            }
            if (ans == MAX) ans = -1;
            bw.write("Case " + idx++ + ": " + ans);
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    public static void solve(int x, int y, int cnt, int move) {
//        System.out.println("-- cnt = " + cnt + ", move = " + move);
        if (move > ans) return;
        if (cnt == emptySpace) {
            ans = Math.min(move, ans);
//            System.out.println("ans = " + ans + ", move = " + move);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + px[d];
            int ny = y + py[d];
            if (!isIn(nx, ny) || visited[nx][ny]) continue;

            int sx = nx;
            int sy = ny;
            int scnt = cnt;
            while (isIn(nx, ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                footstep[nx][ny] = scnt + 1;
                nx += px[d];
                ny += py[d];
                scnt++;
            }
            nx -= px[d];
            ny -= py[d];
//            System.out.println(d + " -> (" + nx + ", " + ny + "), cnt = " + scnt + ", move = " + (move + 1));
//            print("Visit");
            solve(nx, ny, scnt, move + 1);

            while (isIn(nx, ny) && visited[nx][ny]) {
                visited[nx][ny] = false;
                footstep[nx][ny] = 0;
                if (nx == sx && ny == sy) break;
                nx -= px[d];
                ny -= py[d];
            }
//            print("-- After");
        }
    }

    public static void print(String str) {
        System.out.println(str);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (footstep[i][j] > 0) System.out.print(footstep[i][j] + " ");
                else System.out.print(footstep[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M || map[x][y] == '*') return false;
        return true;
    }
}
