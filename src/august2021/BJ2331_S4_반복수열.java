package august2021;

import java.io.*;
import java.util.*;

public class BJ2331_S4_반복수열 {
    static int A;
    static double P;
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int cnt = 0, prev = A;
        map.put(prev, cnt++);

        while (true) {
            int next = getNum(prev);
            if (map.get(next) == null) {
                map.put(next, cnt++);
                prev = next;
            } else {
                bw.write(String.valueOf(map.get(next)));
                break;
            }
        }

        br.close();
        bw.close();
    }

    public static int getNum(int num) {
        int res = 0;

        while (num > 0) {
            int n = (num % 10);
            res += Math.pow(n, P);
            num /= 10;
        }

        return res;
    }
}
