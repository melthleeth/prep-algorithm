package october2021;

import java.io.*;
import java.util.*;

public class Programmers_문자열압축 {
    static String s = "abcabcabcabcdededededede";

    public static void main(String[] args) {
        int len = s.length();
        int answer = len;

        for (int i = 1; i <= len / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int cnt = 1;
            int idx = 0;
            for (int j = i; j < len; j+= i) {
                if (j + i > len) {
                    idx = j;
                    break;
                }
                String next = s.substring(j, j + i);
//                System.out.println("prev, next = " + prev + ", " + next);
                if (prev.equals(next)) cnt++;
                else {
                    if (cnt > 1) sb.append(cnt);
                    sb.append(prev);
                    cnt = 1;
                }
                prev = next;
            }
            if (cnt > 1) sb.append(cnt);
            sb.append(prev);
            if (idx > 0) sb.append(s.substring(idx));

//            System.out.println(sb.toString() + ", " + sb.toString().length());
            answer = Math.min(answer, sb.toString().length());
        }
        System.out.println(answer);
    }
}
