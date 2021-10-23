package october2021;

import java.io.*;
import java.util.*;
import java.awt.*;

public class BJ1202_G2_보석도둑 {
    static int N, K;
    static long ans;
    static PriorityQueue<Integer> bag = new PriorityQueue<>(Comparator.comparingInt((Integer val) -> val).reversed());
    static Point[] gem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        gem = new Point[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            gem[i] = new Point(x, y);
        }

        for (int i = 0; i < K; i++)
            bag.offer(Integer.parseInt(br.readLine()));

        Arrays.sort(gem, (o1, o2) -> {
            if (o1.y == o2.y) return o1.x - o2.x;
            return o1.y - o2.y;
        });

        for (Point g : gem)
            System.out.println(g.x + ", " + g.y);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
