package august2021;

import java.io.*;

public class BJ11718_B3_그대로출력하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
