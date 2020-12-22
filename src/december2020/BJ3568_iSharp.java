package december2020;

import java.util.*;
import java.io.*;

public class BJ3568_iSharp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");

        StringBuilder[] sb = new StringBuilder[str.length + 1];
        for (int i = 0; i < str.length + 1; i++)
            sb[i] = new StringBuilder();

        for (int i = 1; i < str.length - 1; i++) {
            sb[i].append(str[0]);

            // 순서: & [] *
            Stack<String> s = new Stack<>();
            String varName = "";
            for (int j = 0; j < str[i].length(); j++){
                char c = str[i].charAt(j);
                if (c == '*' || c == '[' || c == '&'){

                } else varName = str[i].substring(0, str[i].length() - 1);
            }

            sb[i].append(" " + varName + ";\n");
        }

        for (StringBuilder sbr : sb)
            bw.write(sbr.toString());

        br.close();
        bw.close();
    }
}
