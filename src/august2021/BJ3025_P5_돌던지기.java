package august2021;

import java.io.*;
import java.util.*;

public class BJ3025_P5_돌던지기 {
    static int R, C, N;
    static char[][] map;
    static BufferedWriter bw;
    static Stack<Coord>[] route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 1][C + 1];

        route = new Stack[C + 1];
        for (int i = 1; i <= C; i++)
            route[i] = new Stack<>();

        for (int i = 1; i <= R; i++) {
            char[] arr = br.readLine().toCharArray();

            for (int j = 1; j <= C; j++)
                map[i][j] = arr[j - 1];
        }

        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            int col = Integer.parseInt(br.readLine());
            stoneThrowing(col);
        }

        print();
        br.close();
        bw.close();
    }

    public static void stoneThrowing(int col) {
        while (!route[col].isEmpty()) {
            if (map[route[col].peek().x][route[col].peek().y] != '.') break;
            route[col].pop();
        }

        int x = 1, y = col;
        if (!route[col].isEmpty()) {
            x = route[col].peek().x;
            y = route[col].peek().y;
        }

        while (x <= R) {
            route[col].push(new Coord(x, y));

            if (x < R && map[x + 1][y] == 'X') break;
            else if (x < R && map[x + 1][y] == 'O') {
                if (y - 1 >= 1 && (map[x][y - 1] == '.' && map[x + 1][y - 1] == '.')) y--;
                else if (y + 1 <= C && (map[x][y + 1] == '.' && map[x + 1][y + 1] == '.')) y++;
                else break;
            }
            x++;
        }
        map[route[col].peek().x][route[col].peek().y] = 'O';
        route[col].pop();
    }

    public static void print() throws IOException {
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++)
                bw.write(String.valueOf(map[i][j]));
            bw.newLine();
        }
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