package october2021;

import java.io.*;
import java.util.*;

public class BJ5568_S5_카드놓기 {
    static int N, K;
    static int[] arr, nums;
    static boolean[] visited;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        nums = new int[K];
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        solve(0);
//        System.out.println(set);
        bw.write(String.valueOf(set.size()));
        br.close();
        bw.close();
    }

    public static void solve(int cnt) {
        if (cnt == K) {
            String num = "";
            for (int i : nums)
                num += i;
            set.add(num);

            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            nums[cnt] = arr[i];
            visited[i] = true;
            solve(cnt + 1);
            visited[i] = false;
        }
    }
}
