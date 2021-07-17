package july2021;

import java.io.*;
import java.util.*;

public class BJ11286_S1_절댓값힙 {
    static int N;
    static PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (Math.abs(o1) == Math.abs(o2))
                return Integer.compare(o1, o2);
            return Integer.compare(Math.abs(o1), Math.abs(o2));
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (heap.isEmpty()) bw.write("0\n");
                else bw.write(heap.poll() + "\n");
            } else heap.offer(num);
        }

        br.close();
        bw.close();
    }
}
