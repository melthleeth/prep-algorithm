package august2021;

import java.io.*;
import java.util.*;

public class BJ9019_G5_DSLR {
    static int T, A, B, ans;
    static Queue<DSLR> q;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            bw.write(String.valueOf(solve()));
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    public static String solve() {
        visited = new boolean[10001];
        q = new LinkedList<>();
        q.offer(new DSLR(A, ""));

        while(!q.isEmpty()) {
            int num = q.peek().num;
            String op = q.peek().op;
            q.poll();

            if (num == B) return op;

            int nextNum = D(num);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                q.offer(new DSLR(nextNum, op + "D"));
            }
            nextNum = S(num);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                q.offer(new DSLR(nextNum, op + "S"));
            }
            nextNum = L(num);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                q.offer(new DSLR(nextNum, op + "L"));
            }
            nextNum = R(num);
            if (!visited[nextNum]) {
                visited[nextNum] = true;
                q.offer(new DSLR(nextNum, op + "R"));
            }
        }

        return "";
    }

    public static int D(int num) {
        return (num * 2) % 10000;
    }

    public static int S (int num) {
        return (num + 9999) % 10000;
    }

    public static int L (int num) {
        int temp = num / 1000;
        return (num % 1000) * 10 + temp;
    }
    public static int R (int num) {
        int temp = num % 10;
        return (num / 10) + temp * 1000;
    }

    static class DSLR {
        int num;
        String op;

        public DSLR(int num, String op) {
            this.num = num;
            this.op = op;
        }
    }
}
