package august2021;

import java.util.*;
import java.io.*;

// 33(562(71(9)))
// 4(23(123)52(87))
// hint:String을 저장하려 하지 말고 길이만 저장하라
// 문제 발생: 3(3(3(2(2)2(2)))) - 같은 depth의 괄호를 처리할 수 없음

public class BJ1662_G5_압축 {
    static String str;
    static Stack<Integer> s = new Stack<>();
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        str = br.readLine();
        pos = new int[str.length()];

        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '(') s.push(i);
            else if (str.charAt(i) == ')') pos[s.pop()] = i;
        }

        bw.write(String.valueOf(solve(0, str.length())));
        br.close();
        bw.close();
    }

    public static int solve(int start, int end) {
        int len = 0;
        for (int i = start; i < end; i++){
            if (str.charAt(i) == '(') {
                int ret = str.charAt(i - 1) - '0';
                len += ret * solve(i + 1, pos[i]) - 1;
                i = pos[i];
            }
            else len++;
        }
        return len;
    }
}
