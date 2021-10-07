package october2021;

import java.io.*;
import java.util.*;

// 전형적인 union find! SWEA에서 풀어본 기억이 남

public class BJ1717_G4_집합의표현 {
    static int N, M;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];
        for (int i = 1; i <= N; i++)
            root[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (op == 0) union(a, b);
            else {
                if (find(a) == find(b)) bw.write("YES\n");
                else bw.write("NO\n");
            }
        }

        br.close();
        bw.close();
    }

    public static int find(int node) {
        if (root[node] == node) return node;
        return root[node] = find(root[node]);
    }

    public static void union(int n1, int n2) {
        int root1 = find(n1);
        int root2 = find(n2);

        if (root1 < root2) root[root2] = root1;
        else root[root1] = root2;
    }
}
