package october2021;

import java.io.*;
import java.util.*;
import java.awt.*;

// 질문: 벽 위치에 상관없이 가장 바깥쪽 칸이면 온도가 1 감소?

public class BJ23289_G1_온풍기안녕 {
    static int R, C, K, W, chocolate;
    static int[][] room;
    static Set<Point>[][] wall;
    static int[][] heatmap;
    static int[] dx = new int[]{0, 0, 0, -1, 1};
    static int[] dy = new int[]{0, 1, -1, 0, 0};
    static int[] wx = new int[]{-1, 0};
    static int[] wy = new int[]{0, 1};
    static Queue<Coord> diff = new LinkedList<>();
    static Set<Point> target = new HashSet<>();
    static Set<Coord> heater = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        room = new int[R + 2][C + 2];
        wall = new HashSet[R + 1][C + 1];
        for (int i = 1; i <= R; i++)
            for (int j = 1; j <= C; j++)
                wall[i][j] = new HashSet<>();

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= C; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) continue;
                if (val == 5) target.add(new Point(i, j));
                else heater.add(new Coord(i, j, val));
            }
        }
        heatmap = new int[R + 1][C + 1];
        W = Integer.parseInt(br.readLine());
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            wall[x][y].add(new Point(x + wx[t], y + wy[t]));
            wall[x + wx[t]][y + wy[t]].add(new Point(x, y));
        }

        initHeatmap();
        while (!researchTemperature()) {
//            System.out.println(chocolate);
            operateHeater();
//            print();
            adjustTemperature();
//            print();
            adjustSideAreaTemperature();
//            print();
            chocolate++;
            if (chocolate == 101) break;
        }

        bw.write(String.valueOf(chocolate));
        br.close();
        bw.close();
    }

    public static void print() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++)
                System.out.print(room[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void initHeatmap() {
        for (Coord c : heater)
            getHeaterwind(c.x, c.y, c.z);
    }

    public static void operateHeater() {
        for (int i = 1; i <= R; i++)
            for (int j = 1; j <= C; j++)
                room[i][j] += heatmap[i][j];
    }

    public static void getHeaterwind(int x, int y, int d) {
        int start = 0, end = 0, heat = 5;
        int[][] temp = new int[R + 1][C + 1];
        temp[x][y] = 5;

        if (d == 1 || d == 2) {
            start = x + dx[d];
            end = start;
        } else {
            start = y + dy[d];
            end = start;
        }

        if (d == 1) {
            for (int j = y + 1; j <= y + 5; j++) {
                if (j < 1 || j > C) break;
                for (int i = start; i <= end; i++) {
                    if (wall[i][j].contains(new Point(i, j - 1))) continue;
                    if (temp[i][j - 1] > 0) temp[i][j] = heat;
                    else {
                        if ((isIn(i - 1, j - 1) && !wall[i - 1][j - 1].contains(new Point(i, j - 1)) && temp[i - 1][j - 1] > 0)
                                || (isIn(i + 1, j - 1) && !wall[i + 1][j - 1].contains(new Point(i, j - 1)) && temp[i + 1][j - 1] > 0))
                            temp[i][j] = heat;
                    }
                }
                heat--;
                start--;
                if (start < 1) start = 1;
                end++;
                if (end > R) end = R;
            }
        } else if (d == 2) {
            for (int j = y - 1; j >= y - 5; j--) {
                if (j < 1 || j > C) break;
                for (int i = start; i <= end; i++) {
                    if (wall[i][j].contains(new Point(i, j + 1))) continue;
                    if (temp[i][j - dy[d]] > 0) temp[i][j] = heat;
                    else {
                        if ((isIn(i - 1, j + 1) && !wall[i - 1][j + 1].contains(new Point(i, j + 1)) && temp[i - 1][j + 1] > 0)
                                || (isIn(i + 1, j + 1) && !wall[i + 1][j + 1].contains(new Point(i, j + 1)) && temp[i + 1][j + 1] > 0))
                            temp[i][j] = heat;
                    }
                }
                heat--;
                start--;
                if (start < 1) start = 1;
                end++;
                if (end > R) end = R;
            }
        } else if (d == 3) {
            for (int i = x - 1; i >= x - 5; i--) {
                if (i < 1 || i > R) break;
                for (int j = start; j <= end; j++) {
                    if (wall[i][j].contains(new Point(i + 1, j))) continue;
                    if (temp[i - dx[d]][j] > 0) temp[i][j] = heat;
                    else {
                        if ((isIn(i + 1, j - 1) && !wall[i + 1][j - 1].contains(new Point(i + 1, j)) && temp[i + 1][j - 1] > 0)
                                || (isIn(i + 1, j + 1) && !wall[i + 1][j + 1].contains(new Point(i + 1, j)) && temp[i + 1][j + 1] > 0))
                            temp[i][j] = heat;
                    }
                }
                heat--;
                start--;
                if (start < 1) start = 1;
                end++;
                if (end > C) end = C;
            }
        } else {
            for (int i = x + 1; i <= x + 5; i++) {
                if (i < 1 || i > R) break;
                for (int j = start; j <= end; j++) {
                    if (wall[i][j].contains(new Point(i - 1, j))) continue;
                    if (temp[i - 1][j] > 0) temp[i][j] = heat;
                    else {
                        if ((isIn(i - 1, j - 1) && !wall[i - 1][j - 1].contains(new Point(i - 1, j)) && temp[i - 1][j - 1] > 0)
                                || (isIn(i - 1, j + 1) && !wall[i - 1][j + 1].contains(new Point(i - 1, j)) && temp[i - 1][j + 1] > 0))
                            temp[i][j] = heat;
                    }
                }
                heat--;
                start--;
                if (start < 1) start = 1;
                end++;
                if (end > C) end = C;
            }
        }
        temp[x][y] = 0;

        for (int i = 1; i <= R; i++)
            for (int j = 1; j <= C; j++)
                heatmap[i][j] += temp[i][j];

    }

    public static void adjustTemperature() {
        calculateDiff();
        adjustDiff();
    }

    public static void calculateDiff() {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                for (int d = 1; d <= 4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];

                    if (!isIn(x, y) || room[i][j] <= room[x][y] || wall[i][j].contains(new Point(x, y))) continue;
                    int diffValue = (room[i][j] - room[x][y]) / 4;
                    diff.offer(new Coord(i, j, -diffValue));
                    diff.offer(new Coord(x, y, diffValue));
                }
            }
        }
    }

    public static void adjustDiff() {
        while (!diff.isEmpty()) {
            Coord c = diff.poll();
            room[c.x][c.y] += c.z;
        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 1 || x > R || y < 1 || y > C) return false;
        return true;
    }

    public static boolean isInside(int x, int y) {
        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isIn(nx, ny) || room[nx][ny] > 0) cnt++;
        }

        if (cnt == 4) return true;
        return false;
    }

    public static void adjustSideAreaTemperature() {
        int sr = 1, er = R, sc = 1, ec = C;
        boolean[][] visited = new boolean[R + 1][C + 1];

        for (int j = 1; j <= C; j++) {
            if (room[0][j] > 0 && !visited[0][j]) {
                room[0][j]--;
                visited[0][j] = true;
            }
            if (room[er][j] > 0 && !visited[er][j]) {
                room[er][j]--;
                visited[er][j] = true;
            }
        }

        for (int i = 1; i <= R; i++) {
            if (room[i][sc] > 0 && !visited[i][sc]) {
                room[i][sc]--;
                visited[i][sc] = true;
            }
            if (room[i][ec] > 0 && !visited[i][sc]) {
                room[i][ec]--;
                visited[i][ec] = true;
            }
        }
    }

    public static boolean researchTemperature() {
        for (Point t : target)
            if (room[t.x][t.y] < K) return false;
        return true;
    }

    static class Coord {
        int x;
        int y;
        int z;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
