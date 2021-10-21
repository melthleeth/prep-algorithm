package october2021;

import java.io.*;

// 10011001100110010110011111111111111111111101 SUBMARINE

public class BJ2671_G5_잠수함식별 {

    public static void main(String[] args) throws IOException {
        String ans = "SUBMARINE";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String str = input;

        while (true) {
            String next = str.replaceFirst("(100+1+)$", "");
            if (next.equals(str))
                next = next.replaceFirst("01$", "");
            if (next.equals(str)) break;
            str = next;
        }

        if (str.equals(input) || !str.isEmpty()) ans = "NOISE";

        bw.write(ans);
        br.close();
        bw.close();
    }
}
