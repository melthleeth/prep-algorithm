package March2021;

import java.util.*;
import java.io.*;

// 33(562(71(9)))
// hint:String을 저장하려 하지 말고 길이만 저장하라
// 문제 발생: 3(3(3(2(2)2(2)))) - 같은 depth의 괄호를 처리할 수 없음

public class BJ1662_G5_압축 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();



        int mid = 0, Qlen;
        while (str.contains(")")) {
            int end = str.indexOf(')');
            int start = end - 1;
            while (str.charAt(start) != '(') {
                start--;
            }
            System.out.println("start, end = " + start + ", " + end);
            if (mid == 0) Qlen = str.substring(start + 1, end).length();
            else Qlen = str.substring(start + 1, mid).length() + Integer.parseInt(str.substring(mid, end));

            int ret = str.charAt(start - 1) - '0';
            int strLen = Qlen * ret;
            str = replace(Integer.toString(strLen), start, end);
            mid = start - 1;
            System.out.println("mid = " + mid + ", str = " + str);
        }
        int ans = str.substring(0, mid).length() + Integer.parseInt(str.substring(mid));

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static String replace(String Q, int start, int end) {
        return str.substring(0, start - 1) + Q + str.substring(end + 1);
    }
}
