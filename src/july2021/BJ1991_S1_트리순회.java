package july2021;

import java.io.*;
import java.util.*;

public class BJ1991_S1_트리순회 {
    static int N;
    static Tree[] tree;
    static boolean[] visited;
    static StringBuilder[] sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        tree = new Tree[N + 1];
        visited = new boolean[N + 1];
        sb = new StringBuilder[3];
        for (int i = 0; i < 3; i++)
            sb[i] = new StringBuilder();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            int idx = input.charAt(0) - 'A';
            tree[idx] = new Tree(input.charAt(2), input.charAt(4));
        }

        DFS('A');

        for (int i = 0; i < 3; i++)
            bw.write(sb[i].toString() + "\n");
        br.close();
        bw.close();
    }

    public static void DFS(char v) {
        int idx = v - 'A';
        visited[idx] = true;
        sb[0].append(v);

        if (tree[idx].left != '.' && !visited[tree[idx].left - 'A']) {
            DFS(tree[idx].left);
        }
        sb[1].append(v);
        if (tree[idx].right != '.' && !visited[tree[idx].right - 'A']) {
            DFS(tree[idx].right);
        }
        sb[2].append(v);
    }

    static class Tree {
        char left;
        char right;

        public Tree(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}
