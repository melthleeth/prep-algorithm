package september2021;

import java.io.*;

public class BJ11059_B2_크리문자열 {
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int N = str.length();
        for (int i = 0; i < N; i++) {
            int len = 1;
            while(true) {
                if (i + len * 2 > N) break;

                String s1 = str.substring(i, i + len);
                String s2 = str.substring(i + len, i + len * 2);
                if (getSum(s1) == getSum(s2)) ans = Math.max(ans, len * 2);

                len++;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static int getSum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
            sum += str.charAt(i) - '0';

        return sum;
    }
}
