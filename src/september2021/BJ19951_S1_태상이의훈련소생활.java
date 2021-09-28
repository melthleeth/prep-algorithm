package september2021;

import java.io.*;
import java.util.*;

public class BJ19951_S1_태상이의훈련소생활 {
    static int N, M;
    static int[] arr, roc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        roc = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            roc[start] += k;
            roc[end + 1] += -k;
        }

        int curr = 0;
        for (int i = 1; i <= N; i++) {
            if (roc[i] != 0) curr += roc[i];
            bw.write(arr[i] + curr + " ");
        }

        br.close();
        bw.close();
    }
}
