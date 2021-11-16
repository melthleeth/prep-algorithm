package september2021;

import java.io.*;
import java.util.*;

public class kakao_Q4 {
    static int[] answer = new int[11];
    static int maxScore = -1;

    public static void main(String[] args) throws IOException {
        int n = 10;
        int[] info = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3};
        // -------------
        int[] result = new int[info.length];
        solve(info, result, n, 0, 0);
        if (maxScore == -1) answer = new int[]{-1};
        System.out.println(Arrays.toString(answer));
    }

    public static long arrayToNumber(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) sb.insert(0, num);
        sb.insert(0, 1);

        return Long.parseLong(sb.toString());
    }

    public static void solve(int[] info, int[] result, int n, int cnt, int start) {
        if (cnt == n) {
            int apeachScore = 0, ryanScore = 0;

            for (int i = 0; i < 11; i++) {
                if (info[i] == 0 && result[i] == 0) continue;
                if (info[i] < result[i]) ryanScore += 10 - i;
                else apeachScore += 10 - i;
            }

            if (ryanScore > apeachScore && ryanScore - apeachScore >= maxScore) {
                System.out.println("apeachScore : ryanScore = " + apeachScore + " : " + ryanScore);
                System.out.println("result = " + Arrays.toString(result));
                maxScore = ryanScore - apeachScore;
                if (arrayToNumber(result) > arrayToNumber(answer))
                    answer = result.clone();
            }

            return;
        }

        System.out.println("start, cnt, result = " + start + ", " + cnt + ", " + Arrays.toString(result));
        for (int i = start; i < 11; i++) {
            if (info[i] + 1 + cnt > n) {
                if (i == 10) result[i] = n - cnt;
                else continue;
            }
            if (result[i] == 0) result[i] = info[i] + 1;
            solve(info, result, n, cnt + info[i] + 1, i + 1);
            result[i] = 0;
        }
    }
}
