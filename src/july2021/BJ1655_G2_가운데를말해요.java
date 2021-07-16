package july2021;

import java.io.*;
import java.util.*;

//minHeap, maxHeap을 써야하는 상상도 못한 문제
public class BJ1655_G2_가운데를말해요 {
    static int N;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) maxHeap.offer(num);
            else minHeap.offer(num);

            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int toMin = maxHeap.poll();
                int toMax = minHeap.poll();
                maxHeap.offer(toMax);
                minHeap.offer(toMin);
            }
            bw.write(maxHeap.peek() + "\n");
        }
//        System.out.println("min " + Arrays.toString(minHeap.toArray()));
//        System.out.println("max " + Arrays.toString(maxHeap.toArray()));
        br.close();
        bw.close();
    }
}
