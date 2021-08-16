package august2021;

import java.io.*;
import java.util.*;

public class BJ1002_S4_터렛 {
    static int T, x1, x2, y1, y2, r1, r2, ans;
    static double D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());

            D = Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0));
            if (D == 0) {
                if (r1 == r2) ans = -1;
                else ans = 0;
            } else if (D == r1 + r2 || D == Math.abs(r1 - r2)) ans = 1;
            else if (D < Math.abs(r1 - r2)) ans = 0;
            else if (D < r1 + r2) ans = 2;
            else if (D > r1 + r2) ans = 0;

            bw.write(String.valueOf(ans));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
