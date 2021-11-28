package november2021;

import java.io.*;
import java.util.*;

public class BJ11909_G5_배열탈출 {
    static int N;
    static int[][] map, cost;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        cost = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int j = 2; j <= N; j++)
            cost[1][j] = getCost(1, j - 1, 1, j) + cost[1][j - 1];

        for (int i = 2; i <= N; i++)
            cost[i][1] = getCost(i - 1, 1, i, 1) + cost[i - 1][1];

        for (int i = 2; i <= N; i++) {
            for (int j = 2; j <= N; j++) {
                cost[i][j] = Math.min(getCost(i - 1, j, i, j) + cost[i - 1][j],
                        getCost(i, j - 1, i, j) + cost[i][j - 1]);
            }
        }

//        for (int[] col : cost)
//            System.out.println(Arrays.toString(col));

        bw.write(String.valueOf(cost[N][N]));
        br.close();
        bw.close();
    }

    public static int getCost(int px, int py, int x, int y) {
        if (map[px][py] > map[x][y]) return 0;
        else return map[x][y] - map[px][py] + 1;
    }
}
