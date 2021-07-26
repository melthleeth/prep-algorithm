package july2021;

import java.io.*;
import java.util.*;

public class BJ1629_S1_곱셈 {
    static long A, B, C, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long denominator = 1;
        while (B > 0) {
            if ((B & 1) == 1) denominator = (denominator % C) * (A % C);
            A = (A % C) * (A % C);
            B >>= 1;
//            System.out.println("A, B = " + A + ", " + B);
        }
        ans = denominator % C;
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}