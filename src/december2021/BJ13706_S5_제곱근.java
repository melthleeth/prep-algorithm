package december2021;

import java.io.*;
import java.math.*;

public class BJ13706_S5_제곱근 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger N = new BigInteger(br.readLine());
        BigInteger start = new BigInteger("1");
        BigInteger end = N;
        BigInteger mid;

        while (true) {
            mid = start.add(end);
            mid = mid.divide(new BigInteger("2"));

            int result = (mid.multiply(mid)).compareTo(N);
            if (result == 0) break;
            else if (result == 1) end = mid.subtract(new BigInteger("1"));
            else start = mid.add(new BigInteger("1"));
        }

        bw.write(mid.toString());
        br.close();
        bw.close();
    }
}
