package october2021;

import java.io.*;
import java.util.*;

public class BJ1181_S5_단어정렬 {
    static int N;
    static PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.length() == o2.length()) return o1.compareTo(o2);
        return o1.length() - o2.length();
    });
    static Set<String> set = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(br.readLine());
        }

        String prev = pq.peek();
        bw.write(prev);
        bw.newLine();
        while (!pq.isEmpty()) {
            String next = pq.poll();
            if (prev.equals(next)) continue;
            bw.write(next);
            bw.newLine();
            prev = next;
        }
        br.close();
        bw.close();
    }
}
