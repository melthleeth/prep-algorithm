package october2021;

import java.awt.*;
import java.io.*;
import java.util.*;

// 문제 잘못이해해서 한참 걸린 문제;;;

public class BJ14466_G4_소가길을건너간이유6 {
    static int N, K, R, ans;
    static Set<Point>[][] road;
    static Point[] cow;
    static boolean[][] visited;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        road = new HashSet[N + 1][N + 1];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                road[i][j] = new HashSet<>();
        cow = new Point[K];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            road[sx][sy].add(new Point(ex, ey));
            road[ex][ey].add(new Point(sx, sy));
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cow[k] = new Point(x, y);
        }

        for (int i = 0; i < K; i++) {
            visited = new boolean[N + 1][N + 1];
            solve(cow[i]);
            for (int j = i + 1; j < K; j++)
                if (!visited[cow[j].x][cow[j].y]) ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void print() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                System.out.print(visited[i][j] ? "O" : "X");
            System.out.println();
        }
        System.out.println();
    }

    public static void solve(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.offer(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];
//                System.out.println("nx, ny, contains? " + nx + ", " + ny + ", " + road[x][y].contains(new Coord(nx, ny)));
                if (!isIn(nx, ny) || visited[nx][ny] || road[x][y].contains(new Point(nx, ny))) continue;
                visited[nx][ny] = true;
                q.offer(new Point(nx, ny));
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 1 || x > N || y < 1 || y > N) return false;
        return true;
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(x, y);
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj) return true;
//            if (obj == null || getClass() != obj.getClass()) return false;
//            Coord coord = (Coord) obj;
//            return x == coord.x && y == coord.y;
//        }
//
//        @Override
//        public String toString() {
//            return "(" + x + ", " + y + ") ";
//        }
    }
}
