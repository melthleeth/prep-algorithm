package october2021;

import java.io.*;
import java.util.*;
import java.awt.*;

//  도움이 된 글: https://devowen.com/300

public class BJ1202_G2_보석도둑 {
    static int N, K;
    static long ans;
    static PriorityQueue<Integer> bag = new PriorityQueue<>();
    static PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.y == o2.y) return o1.x - o2.x;
        return o2.y - o1.y;
    });
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
            if (o1.x == o2.x) return o2.y - o1.y;
            return o1.x - o2.x;
        });

//        for (Point g :gem)
//            System.out.println(g.x + ", " + g.y);

        int idx = 0;
        while (!bag.isEmpty()) {
            int limit = bag.poll();

//            System.out.println("bag = " + limit);
            while (idx < N && gem[idx].x <= limit) {
                pq.offer(new Point(gem[idx].x, gem[idx].y));
//                System.out.println(" - idx = " + idx);
                idx++;
            }

            if (!pq.isEmpty())
                ans += pq.poll().y;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
