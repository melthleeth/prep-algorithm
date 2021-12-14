package december2021;

import java.io.*;
import java.util.*;

// 결국 솔루션 보고 풀었다... 무엇을 이분탐색할 기준으로 잡는지가 어렵네 ㅠ
public class BJ2110_S1_공유기설치 {
    static int N, C, ans;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++)
            houses[i] = Integer.parseInt(br.readLine());

        Arrays.sort(houses);

        // 집 사이의 거리가 기준
        int start = 1;
        int end = houses[N - 1] - houses[0];

        while (start <= end) {
            int mid = (start + end) / 2;
            int prev = houses[0];
            int cnt = 1; // 1인 이유는 [0]에는 무조건 설치하기 때문

            // 이분탐색으로 찾은 집 사이 거리가 공유기 몇 개로 충족되는지 찾기
            for (int house : houses) {
                if (house - prev >= mid) {
                    cnt++;
                    prev = house;
                }
            }

//            System.out.println(start + ", " + end + ") mid = " + mid + ", cnt = " + cnt);

            // 공유기 덜썼으면 (cnt < C) 거리가 너무 크다는 뜻이므로 end값을 조정한다.
            if (cnt < C) end = mid - 1;
            else { // 공유기를 다썼거나 더썼으면 거리값을 조금 더 높여본다.
                ans = Math.max(ans, mid);
                start = mid + 1;
            }
        } // while

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
