package july2021;

import java.io.*;
import java.util.*;

public class BJ15684_G4_사다리조작 {
    static int N, M, H, ans = -1;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[N + 1][H + 1];
        visited = new boolean[N + 1][H + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = i + 1;
            map[x][y + 1] = i + 1;
        }

        for (int i = 1; i <= 3; i++) {
            installLadder(0, i);
            if (ans > -1) break;
        }
    }

    public static void installLadder(int cnt, int L) {
        if (cnt == L) {
            boolean flag = true;
            for (int i = 1; i <= N; i++) {
                if (!explore(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans = L;
            return;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < H; j++) {
                if (map[i][j] == 1 || visited[i][j]) continue;
                map[i][j] = 2;
                map[i][j + 1] = 2;
                installLadder(cnt + 1, L);
                map[i][j] = 0;
                map[i][j + 1] = 0;
            }
        }
    }

    // 한 세로선에 대해 내려가는 동작 수행
    public static boolean explore(int start) {
        boolean flag = false;
        int x = 0;
        int y = start;

        while (x <= N) {
            if (map[x + 1][y] == 0) x++;

            switch (map[x][y]) {
                case 0:
                    x++;
                    break;
                case 1:
                case 2:
                    if (y > 1 && (map[x + 1][y - 1] == 1 || map[x + 1][y - 1] == 2)) y--;
                    else if (y < N && (map[x + 1][y + 1] == 1 || map[x + 1][y + 1] == 2)) y++;
                    x++;
                    break;
            }
        }

        return flag;
    }
}
