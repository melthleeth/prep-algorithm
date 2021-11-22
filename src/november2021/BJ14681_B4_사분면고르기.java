package november2021;

import java.io.*;

public class BJ14681_B4_사분면고르기 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x > 0) {
            if (y > 0) ans = 1;
            else ans = 4;
        } else {
            if (y > 0) ans = 2;
            else ans = 3;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
