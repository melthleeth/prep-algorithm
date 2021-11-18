package november2021;

import java.io.*;
import java.util.*;
import java.awt.*;

public class BJ1890_S2_점프 {
    static int N;
    static int[][] arr;
    static long[][] cnt;
    static int[] px = new int[]{1, 0};
    static int[] py = new int[]{0, 1};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        q.offer(new Point(0, 0));

        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            if (arr[x][y] == 0) continue;

            for (int d = 0; d < 2; d++) {
                int nx = x + px[d] * arr[x][y];
                int ny = y + py[d] * arr[x][y];

                if (!isIn(nx, ny)) continue;
                if (cnt[nx][ny] == 0)
                    cnt[nx][ny]++;
                else
                    cnt[nx][ny] += cnt[x][y];
                if (cnt[nx][ny] == 1)
                    q.offer(new Point(nx, ny));

            }
        }
        for (long[] col : cnt)
            System.out.println(Arrays.toString(col));

        bw.write(String.valueOf(cnt[N - 1][N - 1]));
        br.close();
        bw.close();
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}
