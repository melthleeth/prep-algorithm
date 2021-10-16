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
        arr = new int[N][N];
        sum = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                char c = st.nextToken().charAt(0);

                if (c == 'A') arr[i][j] = 1;
                else if (c == 'T') arr[i][j] = 10;
                else if (c == 'J') arr[i][j] = 11;
                else if (c == 'Q') arr[i][j] = 12;
                else if (c == 'K') arr[i][j] = 13;
                else arr[i][j] = c - '0';
            }
        }

        for (int i = N - 2; i >= 0; i--)
            arr[i][0] += arr[i + 1][0];
        for (int j = 1; j < N; j++)
            arr[N - 1][j] += arr[N - 1][j - 1];

        for (int i = N - 2; i >= 0; i--) {
            for (int j = 1; j < N; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i][j - 1]);
            }
        }

//        for (int[] col : arr)
//            System.out.println(Arrays.toString(col));

        bw.write(String.valueOf(arr[0][N - 1]));
        br.close();
        bw.close();
    }
}
