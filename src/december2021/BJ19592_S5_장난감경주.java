package december2021;

import java.io.*;
import java.util.*;

public class BJ19592_S5_장난감경주 {
    static int T, N, Y, ans, myVelocity, maxVelocity;
    static double X;
    static int[] V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            V = new int[N];
            ans = Y + 1;
            myVelocity = 0;
            maxVelocity = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N - 1; i++) {
                V[i] = Integer.parseInt(st.nextToken());
                maxVelocity = Math.max(maxVelocity, V[i]);
            }
            myVelocity = Integer.parseInt(st.nextToken());

            if (myVelocity > maxVelocity) ans = 0;
            else {
                int start = 1;
                int end = Y;

                while (start <= end) {
                    int mid = (start + end) / 2;

                    if ((X - mid) / myVelocity + 1 >= X / maxVelocity) start = mid + 1;
                    else {
                        ans = Math.min(ans, mid);
                        end = mid - 1;
                    }
                }
            }
            if (ans == Y + 1) ans = -1;

            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
