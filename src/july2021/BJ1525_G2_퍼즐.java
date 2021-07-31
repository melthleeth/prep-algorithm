package july2021;

import java.io.*;
import java.util.*;

// hint: 2차원 배열로 저장하지 말고 linear한 값으로 저장하기
public class BJ1525_G2_퍼즐 {
    static int ans = Integer.MAX_VALUE;
    static int[] px = new int[]{1, 0, -1, 0};
    static int[] py = new int[]{0, 1, 0, -1};
    static StringBuilder init = new StringBuilder();
    static Map<String, Integer> visited = new HashMap<>();
    static final String ANS = "123456780";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++)
                init.append(st.nextToken());
        }
        solve();

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    public static void solve() {
        Queue<String> q = new LinkedList<>();
        visited.put(init.toString(), 0);
        q.offer(init.toString());

        while (!q.isEmpty()) {
            String str = q.poll();

            if (str.equals(ANS)) break;

            int pos = str.indexOf("0");
            int x = pos / 3;
            int y = pos % 3;
            for (int d = 0; d < 4; d++) {
                int nx = x + px[d];
                int ny = y + py[d];

                if (!isIn(nx, ny)) continue;
                int idx = nx * 3 + ny;
                char target = str.charAt(idx);
                String nextStr = str;
                nextStr = nextStr.replace('0', target);
                nextStr = replace(nextStr, idx, '0');
                if (visited.get(nextStr) != null) continue;
                visited.put(nextStr, visited.get(str) + 1);
                q.offer(nextStr);
            }
        }
        if (visited.get(ANS) == null) ans = -1;
        else ans = visited.get(ANS);
    }

    public static String replace(String str, int idx, char c) {
        return str.substring(0, idx) + c + str.substring(idx + 1);
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) return false;
        return true;
    }
}
