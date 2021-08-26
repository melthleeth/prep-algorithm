package august2021;

import java.io.*;
import java.util.*;

public class BJ16225_D5_제271회웰노운컵 {
    static int N;
    static long ans;
    static ArrayList<Problem> arr = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> (o2 - o1));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st, st2;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            arr.add(new Problem(a, b));
        }

        arr.sort((o1, o2) -> (o1.b - o2.b));
        ans += arr.get(0).a;

        for (int i = 1; i < N - 1; i += 2) {
            pq.offer(arr.get(i).a);
            if (i + 1 < N - 1) pq.offer(arr.get(i + 1).a);
            ans += pq.poll();
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    static class Problem {
        int a;
        int b;

        public Problem(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
