package october2021;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BJ2225_G5_합분해 {
    static int N, K;
    static String[][] factorial = new String[401][201];
    static String ans;
    static BigInteger C = new BigInteger("1000000000");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (String[] row : factorial)
            Arrays.fill(row, "");

        ans = new BigInteger(combination(N + K - 1, K - 1)).remainder(C).toString();

        bw.write(ans);
        br.close();
        bw.close();
    }

    public static String sum(String n1, String n2) {
        return new BigInteger(n1).add(new BigInteger(n2)).toString();
    }

    public static String combination(int n, int k) {
        if (n == k || k == 0) return "1";
        if (!factorial[n][k].isEmpty()) return factorial[n][k];
        return factorial[n][k] = sum(combination(n - 1, k - 1), combination(n - 1, k));
    }
}
