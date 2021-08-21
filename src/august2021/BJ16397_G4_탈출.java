package august2021;

import java.io.*;
import java.util.*;

public class BJ16397_G4_탈출 {
    static int N, T, G, ans = 100000;
    static HashMap<Integer, Boolean> visited = new HashMap<>();
    static Queue<Num> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        visited.put(N, true);
        q.offer(new Num(N, 0));
        while (!q.isEmpty()) {
            int num = q.peek().num;
            int cnt = q.peek().cnt;
            q.poll();

            if (cnt > T) {
                ans = -1;
                break;
            }

//            System.out.println("# num, cnt: " + num + ", " + cnt);
            if (num == G) {
                ans = cnt;
                break;
            }

            // press A
            int next = num + 1;
//            System.out.println("A) next: " + next);
            if (next > 99999) continue; // 여기때문에 틀렸었다..
            if (visited.get(next) == null) {
                visited.put(next, true);
                q.offer(new Num(next, cnt + 1));
            }

            // press B
            if (num == 0) continue;
            next = num * 2;
            if (next > 99999) continue;
            int digit = Integer.toString(next).length();
            next -= (int) (Math.pow(10.0, digit - 1));
//            System.out.println("B) next: " + next);
            if (visited.get(next) == null) {
                visited.put(next, true);
                q.offer(new Num(next, cnt + 1));
            }

        }
        if (ans > -1 && ans < 100000) bw.write(String.valueOf(ans));
        else bw.write("ANG");
        br.close();
        bw.close();
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
