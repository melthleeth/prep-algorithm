package october2021;

import java.io.*;
import java.util.*;

public class BJ1063_S4_킹 {
    static int N;
    static Coord king, stone;
    static Queue<Coord> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        String coord = st.nextToken();
        int y = coord.charAt(0) - 'A' + 1;
        int x = coord.charAt(1) - '0';
        king = new Coord(x, y);

        coord = st.nextToken();
        y = coord.charAt(0) - 'A' + 1;
        x = coord.charAt(1) - '0';
        stone = new Coord(x, y);

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            q.offer(getCoord(br.readLine()));
        }

        solve();

        bw.write(CoordToStr(king) + "\n" + CoordToStr(stone));
        br.close();
        bw.close();
    }

    public static void solve() {
        while (!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

//            System.out.println("king = " + king.x + ", " + king.y);
//            System.out.println("stone = " + stone.x + ", " + stone.y);

            int kx = x + king.x;
            int ky = y + king.y;

            if (!isIn(kx, ky)) continue;
            if (kx == stone.x && ky == stone.y) {
                if (isIn(x + stone.x, y + stone.y)) {
                    king.x = kx;
                    king.y = ky;
                    stone.x += x;
                    stone.y += y;
                }
            } else if (kx != stone.x && ky != stone.y) {
                king.x = kx;
                king.y = ky;
            }

        }
    }

    public static boolean isIn(int x, int y) {
        if (x < 1 || x > 8 || y < 1 || y > 8) return false;
        return true;
    }

    public static Coord getCoord(String str) {
        if (str.equals("R")) return new Coord(0, 1);
        else if (str.equals("L")) return new Coord(0, -1);
        else if (str.equals("B")) return new Coord(-1, 0);
        else if (str.equals("T")) return new Coord(1, 0);
        else if (str.equals("RT")) return new Coord(1, 1);
        else if (str.equals("LT")) return new Coord(1, -1);
        else if (str.equals("RB")) return new Coord(-1, 1);
        else return new Coord(-1, -1);
    }

    public static String CoordToStr(Coord c) {
//        System.out.println("x, y = " + c.x + ", " + c.y);
        StringBuilder sb = new StringBuilder();
        sb.append((char) ('A' + c.y - 1));
        sb.append(c.x);

        return sb.toString();
    }

    static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
