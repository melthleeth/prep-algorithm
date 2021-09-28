package september2021;

import java.io.*;
import java.util.*;


public class BJ16019_B2_AreWeThereYet {
    static int[] arr = new int[5];
    static int[][] sum = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 5; j++) {
                sum[i][j] += sum[i][j - 1] + arr[j - 1];
                sum[j][i] = sum[i][j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                bw.write(sum[i][j] + " ");
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
