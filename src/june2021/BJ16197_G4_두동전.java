package june2021;

import java.util.*;
import java.io.*;

public class BJ16197_G4_두동전 {
    static int N, M;
    static int[] px = {1, 0, -1, 0};
    static int[] py = {0, 1, 0, -1};
    static char[][] map;
    static Queue<Coin> coin = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < M; j++)
                if (map[i][j] == 'o') coin.add(new Coin(i, j, 0));
        }

        explore();
        br.close();
    }

    public static void explore() {
        // visited check: 두 동전이 계속 같은 위치에 머무를 때
        Map<String, Boolean> visited = new HashMap<>();
        while (!coin.isEmpty()) {
            int[] x = new int[2];
            int[] y = new int[2];
            int[] cnt = new int[2];
            int[] dir = new int[2];

            for (int i = 0; i < 2; i++) {
                x[i] = coin.peek().x;
                y[i] = coin.peek().y;
                cnt[i] = coin.peek().cnt;
                dir[i] = coin.peek().d;
                coin.poll();
            }
//            System.out.println("cnt: " + Arrays.toString(cnt));
//            System.out.println("dir: " + Arrays.toString(dir));

            if (dir[0] != dir[1]) {
                if (cnt[0] <= 10) System.out.println(cnt[0]);
                else System.out.println(-1);

                return;
            }
            else {
                if (dir[0] == -1) continue;
                if (cnt[0] > 10) {
                    System.out.println(-1);
                    return;
                }
            }

            for (int d = 0; d < 4; d++) {
                StringBuilder sb = new StringBuilder();
                sb.append(x[0] + px[d]).append(y[0] + py[d]).append(x[1] + px[d]).append(y[1] + py[d]);
                if (visited.get(sb.toString()) != null) continue;
                visited.put(sb.toString(), true);

                for (int i = 0; i < 2; i++) {
                    int nx = x[i] + px[d];
                    int ny = y[i] + py[d];

                    if (!isIn(nx, ny)) {
//                        System.out.println("동전 탈출, " + x[i] + ", " + y[i] + "| d, cnt: " + d + ", " + (cnt[i] + 1));
                        coin.offer(new Coin(x[i], y[i], (cnt[i] + 1), -1));
                    }
                    else if (map[nx][ny] == '#') {
//                        System.out.println("벽 만남, " + x[i] + ", " + y[i] + "| d, cnt: " + d + ", " + (cnt[i] + 1));
                        coin.offer(new Coin(x[i], y[i], (cnt[i] + 1), d));
                    }
                    else {
//                        System.out.println("빈칸 or 동전 겹침, " + x[i] + ", " + y[i] + "| d, cnt: " + d + ", " + (cnt[i] + 1));
                        coin.offer(new Coin(nx, ny, (cnt[i] + 1), d));
                    }
                }

//                System.out.println("size: " + coin.size());
            }
        }
        System.out.println(-1);
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

    static class Coin {
        int x;
        int y;
        int cnt;
        int d;

        public Coin(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.d = 4;
        }

        public Coin(int x, int y, int cnt, int d) {
            this(x, y, cnt);
            this.d = d;
        }
    }

}
