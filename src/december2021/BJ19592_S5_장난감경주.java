package december2021;

import java.io.*;
import java.util.*;

public class BJ19592_S5_장난감경주 {
    static int T, N, length, limit, V, ans;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            length = Integer.parseInt(st.nextToken());
            limit = Integer.parseInt(st.nextToken());

            time = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N - 1; i++) {
                double v = Integer.parseInt(st.nextToken());
                time[i] = (int) Math.ceil(length / v);
            }


        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
