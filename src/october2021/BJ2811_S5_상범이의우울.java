package october2021;

import java.io.*;
import java.util.*;

public class BJ2811_S5_상범이의우울 {
    static int N, ans, maxValue, maxDepression;
    static int[] arr, cnt;
    static boolean[] flower;

    // 왜안되는지 알았어;;; boolean으로 체크해야해......하씨... 그래서 개수가 적게 나온거구나... 영어 끝나고 고치자 ㅠ
    // 그러면 1. 극한의 효율을 택해 2. 그냥 for문 냅다 돌려

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        cnt = new int[N + 1];
        flower = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int depression = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] < 0) depression++;
            else {
                cnt[i + 1] = depression;
                for (int j = i; j > i - depression * 2; j--) {
                    if (j < 0) break;
                    if (flower[j]) continue;
                    flower[j] = true;
                    ans++;
                }
                maxDepression = Math.max(maxDepression, depression);
                depression = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            if (cnt[i] == 0 || cnt[i] != maxDepression) continue;
            int addValue = 0;
            for (int j = i - cnt[i] * 2 - 1; j >= i - cnt[i] * 3; j--) {
                if (j < 0) break;
                if (flower[j]) continue;
                addValue++;
            }
            maxValue = Math.max(maxValue, addValue);
        }

        bw.write(String.valueOf(ans + maxValue));
        br.close();
        bw.close();
    }
}
