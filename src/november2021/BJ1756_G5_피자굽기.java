package november2021;

import java.io.*;
import java.util.*;

public class BJ1756_G5_피자굽기 {
    static int D, N, pos;
    static int[] oven, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        oven = new int[D + 1];
        depth = new int[D + 1];
        depth[0] = Integer.MAX_VALUE;
        pos = D;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= D; i++) {
            oven[i] = Integer.parseInt(st.nextToken());
            depth[i] = Math.min(depth[i - 1], oven[i]);
        }

//        System.out.println(Arrays.toString(depth));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int pizza = Integer.parseInt(st.nextToken());

//            System.out.println("pos, pizza = " + pos + ", " + pizza);
            while (pizza > depth[pos] && pos > 0) {
                pos--;
            }
//            System.out.println("pos = " + pos);
            if (pos < 1) {
                pos = 0;
                break;
            }
            if (i == N - 1) break;
            pos--;
        }

        bw.write(String.valueOf(pos));
        br.close();
        bw.close();
    }
}
