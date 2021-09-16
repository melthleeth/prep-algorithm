package september2021;

import java.io.*;

public class BJ7682_G5_틱택토 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        while (!(str = br.readLine()).equals("end")) {

            String ans = isValid(str) ? "valid" : "invalid";
            bw.write(ans);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static boolean isValid(String str) {
        int cntO = 0, cntX = 0, ansO = 0, ansX = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'O') cntO++;
            else if (str.charAt(i) == 'X') cntX++;
        }

        if (cntX - cntO != 1 && cntX - cntO != 0) return false;

        for (int i = 0; i < 9; i += 3) {
            if (str.charAt(i) == '.') continue;
            if (str.charAt(i) == str.charAt(i + 1) && str.charAt(i + 1) == str.charAt(i + 2)) {
                if (str.charAt(i) == 'X') ansX++;
                else ansO++;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (str.charAt(j) == '.') continue;
            if (str.charAt(j) == str.charAt(j + 3) && str.charAt(j + 3) == str.charAt(j + 6)) {
                if (str.charAt(j) == 'X') ansX++;
                else ansO++;
            }
        }

        if (str.charAt(4) != '.') {
            if ((str.charAt(4) == str.charAt(0) && str.charAt(4) == str.charAt(8))
                    || (str.charAt(4) == str.charAt(2) && str.charAt(4) == str.charAt(6))) {
                if (str.charAt(4) == 'X') ansX++;
                else ansO++;
            }
        }

        if (ansX > 0) {
            if (ansO > 0) return false;
            if (cntX - cntO == 1) return true;
            else return false;
        }
        if (ansO > 0) {
            if (cntX - cntO == 0) return true;
            else return false;
        }
        if (cntX + cntO == 9) return true;
        return false;
    }
}
