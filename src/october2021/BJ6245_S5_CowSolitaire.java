package october2021;

import java.io.*;
import java.util.*;

public class BJ6245_S5_CowSolitaire {
    static int N;
    static int[][] arr, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        sum = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                char c = st.nextToken().charAt(0);

                if (c == 'T') arr[i][j] = 10;
                else if (c == 'J') arr[i][j] = 11;
                else if (c == 'Q') arr[i][j] = 12;
                else if (c == 'K') arr[i][j] = 13;
                else arr[i][j] = c - '0';

                arr[i][j] += arr[i][j - 1];
            }
        }

        for (int i = N; i > 0; i--) {
            for (int j = 1; j <= N; j++) {

            }
        }

        bw.write(String.valueOf(sum[0][N - 1]));
        br.close();
        bw.close();
    }
}
