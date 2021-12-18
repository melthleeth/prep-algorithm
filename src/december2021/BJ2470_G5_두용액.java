package december2021;

import java.io.*;
import java.util.*;

public class BJ2470_G5_두용액 {
    static int N, ans = Integer.MAX_VALUE, startIdx, endIdx;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        endIdx = N - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum > 0) {
                if (sum < Math.abs(ans)) {
                    startIdx = start;
                    endIdx = end;
                    ans = sum;
                }
                end--;
            } else if (sum < 0) {
                if (-sum < Math.abs(ans)) {
                    startIdx = start;
                    endIdx = end;
                    ans = sum;
                }
                start++;
            } else {
                startIdx = start;
                endIdx = end;
                break;
            }
        }

        bw.write(arr[startIdx] + " " + arr[endIdx]);
        br.close();
        bw.close();
    }
}
