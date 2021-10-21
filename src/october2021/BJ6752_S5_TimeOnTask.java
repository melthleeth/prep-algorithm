package october2021;

import java.io.*;
import java.util.*;

// 실수 주의!!!!!

public class BJ6752_S5_TimeOnTask {
    static int T, C, ans;
    static int[] chore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        chore = new int[C + 1];

        for (int i = 1; i <= C; i++)
            chore[i] = Integer.parseInt(br.readLine());

        Arrays.sort(chore);

        for (int i = 1; i <= C; i++) {
            chore[i] += chore[i - 1];
            if (chore[i] > T) break;
            ans = i;
        }
        System.out.println(ans);
        br.close();
    }
}
