package july2021;

import java.io.*;
import java.util.*;

public class BJ15684_G4_사다리조작 {
    static int N, M, H, ans = -1; // H: row, N: column
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = i + 1;
            map[x][y + 1] = i + 1;
        }

        if (result()) ans = 0;

        for (int i = 1; i <= 3; i++) {
            if (ans > -1) break;
            installLadder(0, i);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void installLadder(int cnt, int L) {
        if (cnt == L) {
            if (result()) ans = L;
            return;
        }

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] != 0 || map[i][j + 1] != 0) continue;
                map[i][j] = (M + 1) + cnt;
                map[i][j + 1] = (M + 1) + cnt;
                installLadder(cnt + 1, L);
                map[i][j] = 0;
                map[i][j + 1] = 0;
            }
        }
    }

    // i -> i로 가는지 체크
    public static boolean result() {
        for (int j = 1; j <= N; j++)
            if (!explore(j)) return false;
        return true;
    }

    // 한 세로선에 대해 내려가는 동작 수행
    public static boolean explore(int start) {
        int x = 0;
        int y = start;

        while (x < H) {
            if (map[x + 1][y] > 0) {
                int ladderIdx = map[x + 1][y];
                if (y > 1 && map[x + 1][y - 1] == ladderIdx) y--;
                else if (y < N && map[x + 1][y + 1] == ladderIdx) y++;
            }
            x++;
        }

        if (y == start) return true;
        return false;
    }
}
