package july2021;

import java.io.*;
import java.util.*;

public class BJ1927_S1_최소힙 {
    static int N;
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (maxHeap.isEmpty()) bw.write("0\n");
                else bw.write(maxHeap.poll() + "\n");
            } else maxHeap.offer(num);
        }

        br.close();
        bw.close();
    }
}
