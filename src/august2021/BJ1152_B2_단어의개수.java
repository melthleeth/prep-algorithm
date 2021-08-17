package august2021;

import java.io.*;

public class BJ1152_B2_단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int size = str.length;

        for (String s : str)
            if (s == null || s.isEmpty()) size--;

        bw.write(String.valueOf(size));
        br.close();
        bw.close();
    }
}
