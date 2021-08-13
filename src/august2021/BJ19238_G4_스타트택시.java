package august2021;

import java.io.*;
import java.util.*;

public class BJ19238_G4_스타트택시 {
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
