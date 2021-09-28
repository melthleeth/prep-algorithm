package september2021;

import java.io.*;
import java.util.*;

public class BJ11441_S3_합구하기 {
    static int N, M;
    static long[] sum;
    static Queue<Coord> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        sum = new long[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            q.offer(new Coord(start, end));
        }

        while(!q.isEmpty()) {
            Coord coord = q.poll();
            bw.write(String.valueOf(sum[coord.end] - sum[coord.start - 1]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    static class Coord {
        int start;
        int end;

        public Coord(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
