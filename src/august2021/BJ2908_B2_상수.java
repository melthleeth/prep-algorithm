package august2021;

import java.io.*;
import java.util.*;

public class BJ2908_B2_상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int ans = Math.max(transform(A), transform(B));
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static int transform(int num) {
        String temp = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        sb.append(temp.charAt(2)).append(temp.charAt(1)).append(temp.charAt(0));

//        int mid = (num / 10) % 10;
//        return (num % 10) * 100 + mid * 10 + num / 100;
        return Integer.parseInt(sb.toString());
    }
}
