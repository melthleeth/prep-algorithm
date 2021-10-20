package october2021;

import java.io.*;
import java.util.*;

public class BJ2669_B1_직사각형네개의합집합의면적구하기 {
    static int ans;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr = new boolean[101][101];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int x = sx; x < ex; x++)
                for (int y = sy; y < ey; y++)
                    arr[x][y] = true;
        }

        for (int i = 1; i <= 100; i++)
            for (int j = 1; j <= 100; j++)
                if (arr[i][j]) ans++;

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
