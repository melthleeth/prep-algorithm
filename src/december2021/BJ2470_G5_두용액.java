package december2021;

import java.io.*;
import java.util.*;

public class BJ2470_G5_두용액 {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
