package december2021;

import java.io.*;
import java.util.*;

public class BJ17266_S5_어두운굴다리 {
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
