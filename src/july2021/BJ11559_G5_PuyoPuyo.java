package july2021;

import java.io.*;
import java.util.*;

public class BJ11559_G5_PuyoPuyo {
    static char[][] map = new char[14][8];
    static int ans;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static Queue<Coord> puyos, willBePopped;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= 12; i++){
            char[] arr = br.readLine().toCharArray();

            for (int j = 1; j <= 6; j++)
                map[i][j] = arr[j - 1];
        }

        while (true) {
            if (!puyoPuyo()) break;
            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static boolean puyoPuyo() {
        puyos = new LinkedList<>();
        willBePopped = new LinkedList<>();
        visited = new boolean[14][8];

        getPuyo();

        int size = puyos.size();
        for (int i = 0; i < size; i++) {
            int x = puyos.peek().x;
            int y = puyos.peek().y;
            puyos.poll();
            if (visited[x][y]) continue;
            visited[x][y] = true;
            BFS(x, y);
        }

        if (willBePopped.isEmpty()) return false;
        else {
            visited = new boolean[14][8];
            while(!willBePopped.isEmpty()) {
                int x = willBePopped.peek().x;
                int y = willBePopped.peek().y;
                willBePopped.poll();

                visited[x][y] = true;
//                System.out.println("pop: " + map[x][y]);
                popPuyo(x, y);
            }
//            print();
            arrangeMap();
//            print();
        }
        return true;
    }

    public static void print() {
        for (int i = 1; i <= 12; i++){
            for (int j = 1; j <= 6; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void arrangeMap() {
        for (int j = 1; j <= 6; j++) {
            for (int i = 12; i >= 1; i--) {
                if (map[i][j] == '.') {
                    int baseLine = i;
                    for (int h = baseLine - 1; h >= 1; h--) {
                        if (map[h][j] != '.') {
                            map[i--][j] = map[h][j];
                            map[h][j] = '.';
                        }
                    }
                }
            }
        }
    }

    public static void popPuyo(int x, int y) {
        char color = map[x][y];
        map[x][y] = '.';
        Queue<Coord> q = new LinkedList<>();
        q.offer(new Coord(x, y));

        while(!q.isEmpty()) {
            int a = q.peek().x;
            int b = q.peek().y;
            q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = a + px[d];
                int ny = b + py[d];
                if (map[nx][ny] != color || visited[nx][ny]) continue;
//                System.out.println("map[" + nx + "][" + ny + "] = " + map[nx][ny]);
                visited[nx][ny] = true;
                map[nx][ny] = '.';
                q.offer(new Coord(nx, ny));
            }
        }
    }

    public static void BFS(int x, int y) {
        int cnt = 1;
        char color = map[x][y];
        Queue<Coord> q = new LinkedList<>();
        q.offer(new Coord(x, y));

        while(!q.isEmpty()) {
            int a = q.peek().x;
            int b = q.peek().y;
            q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = a + px[d];
                int ny = b + py[d];

                if (map[nx][ny] != color || visited[nx][ny]) continue;
                cnt++;
                visited[nx][ny] = true;
                q.offer(new Coord(nx, ny));
            }
        }
//        System.out.println("map[" + x + "][" + y + "] = " + map[x][y] + ", cnt = " + cnt);
        if (cnt >= 4) willBePopped.offer(new Coord(x, y));
    }

    public static void getPuyo() {
        for (int i = 1; i <= 12; i++)
            for (int j = 1; j <= 6; j++)
                if (map[i][j] != '.') puyos.offer(new Coord(i, j));
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
