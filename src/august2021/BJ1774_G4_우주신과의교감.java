package august2021;

import java.io.*;
import java.util.*;

public class BJ1774_G4_우주신과의교감 {
    static int N, M;
    static double ans;
    static Coord[] coord;
    static int[] root;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        coord = new Coord[N + 1];
        root = new int[N + 1];
        visited = new boolean[N + 1];

        makeSet();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coord[i] = new Coord(x, y);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            visited[a] = true;
            visited[b] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i]) {
                solve(i);
                break;
            }
        }

        bw.write(String.valueOf(String.format("%.2f", ans)));
        br.close();
        bw.close();
    }

    public static void makeSet() {
        for (int i = 1; i <= N; i++)
            root[i] = i;
    }

    public static int find(int x) {
        if (x == root[x]) return x;
        else return root[x] = find(root[x]);
    }

    public static void union(int a, int b) {
        int root1 = find(a);
        int root2 = find(b);

        if (root1 < root2) root[b] = a;
        else root[a] = b;

    }

    public static void solve(int start) {
        Queue<Coord> q = new LinkedList<>();
        q.offer(coord[start]);

        while (!q.isEmpty()) {


        }
    }

    public static double getDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2.0) + Math.pow(y2 - y1, 2.0));
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
