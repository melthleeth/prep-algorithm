package october2021;

import java.io.*;
import java.util.*;

public class BJ3584_G4_가장가까운공통조상 {
    static int T, N, ans;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            root = new int[N + 1];

            for (int i = 1; i <= N; i++)
                root[i] = i;

            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                root[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();
            set.add(a);
            while(root[a] != a) {
                set.add(root[a]);
                a = root[a];
            }
            while(true) {
                if (set.contains(root[b])) {
                    ans = root[b];
                    break;
                }
                b = root[b];
            }

            bw.write(String.valueOf(ans));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
