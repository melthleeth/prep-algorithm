package october2021;

import java.io.*;
import java.util.*;

public class BJ17472_G2_다리만들기2 {
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
