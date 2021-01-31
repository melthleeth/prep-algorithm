package January2021;

import java.util.*;
import java.io.*;

public class BJ14719_G5_빗물 {
    static int H, W, max, sum;
    static int[] rain, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        rain = new int[W];
        answer = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            rain[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < W; i++) {
            max = Math.max(rain[i], max);
            answer[i] = max - rain[i];
        }
        max = 0;
        for (int i = W - 1; i >= 0; i--) {
            max = Math.max(rain[i], max);
            answer[i] = Math.min(answer[i], max - rain[i]);
        }

//        System.out.println(Arrays.toString(answer));

        for (int ans : answer)
            sum += ans;

        System.out.println(sum);
    }
}
