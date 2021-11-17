package november2021;

import java.io.*;
import java.util.*;
import java.awt.*;

public class BJ1890_S2_점프 {
    static int N, ans;
    static int[][] arr, cnt;
    static int[] px = new int[]{1, 0};
    static int[] py = new int[]{0, 1};
    static Queue<Point> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        cnt = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }
        q.offer(new Point(0, 0));

        while(!q.isEmpty()) {

        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
