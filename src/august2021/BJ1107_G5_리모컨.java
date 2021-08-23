package august2021;

import java.io.*;
import java.util.*;

public class BJ1107_G5_리모컨 {
    static int N, M, res, ans;
    static boolean[] brokenBtn = new boolean[10];
    static Map<Integer, Boolean> visited = new HashMap<>();
    static final int UPPER_BOUND = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        ans = res = UPPER_BOUND;
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++)
                brokenBtn[Integer.parseInt(st.nextToken())] = true;
        }
        if (N == 100) bw.write(String.valueOf(0));
        else {
            solve();
            ans += Math.min(Math.abs(100 - res), Integer.toString(res).length());
            ans = Math.min(Math.abs(100 - N), ans);
            bw.write(String.valueOf(ans));
        }
        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<Num> q = new LinkedList<>();
        q.offer(new Num(N, 0));
        while (!q.isEmpty()) {
            int num = q.peek().num;
            int cnt = q.peek().cnt;
            q.poll();

            if (isPossibleToPress(num)) {
                if (Math.abs(num - N) <= Math.abs(res - N) && cnt <= ans && num < res) {
                    res = num;
                    ans = cnt;
                }
//                System.out.println("num, cnt = " + num + ", " + cnt);
                continue;
            }

            int nextNum = num + 1;
            if (nextNum == UPPER_BOUND) continue;
            if (visited.get(nextNum) == null) {
                visited.put(nextNum, true);
                q.offer(new Num(nextNum, cnt + 1));
            }

            if (num == 0) continue;
            nextNum = num - 1;
            if (visited.get(nextNum) == null) {
                visited.put(nextNum, true);
                q.offer(new Num(nextNum, cnt + 1));
            }
        }
    }

    public static boolean isPossibleToPress(int n) {
        String num = Integer.toString(n);
        for (int i = num.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(num.charAt(i));
            if (brokenBtn[digit]) return false;
        }
        return true;
    }

    static class Num {
        int num;
        int cnt;

        public Num(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
