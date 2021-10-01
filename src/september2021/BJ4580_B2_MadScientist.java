package september2021;

import java.io.*;
import java.util.*;

public class BJ4580_B2_MadScientist {
    static int K;
    static String input;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (!(input = br.readLine()).equals("0")) {
            st = new StringTokenizer(input);
            K = Integer.parseInt(st.nextToken());
            sum = new int[K + 1];

            for (int i = 1; i <= K; i++) {
                sum[i] = Integer.parseInt(st.nextToken());
                int cnt = sum[i] - sum[i - 1];
                for (int j = 0; j < cnt; j++)
                    bw.write(i + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
