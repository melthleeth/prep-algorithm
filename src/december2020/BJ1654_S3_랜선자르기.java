package december2020;

import java.util.*;
import java.io.*;

// 2020.12.29 이분탐색 연습좀 해야할듯..!!

public class BJ1654_S3_랜선자르기 {
	static int K, N;
	static long ans;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(ans);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new long[K];
		for (int i = 0; i < K; i++)
			arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		br.close();
	}

	public static void solve() {
		long start = 1, end = arr[K - 1];
		
		while(start <= end) {
			long mid = (start + end) / 2;
			
			if (isSatisfied(mid)) {
				ans = Math.max(ans, mid);
				start = mid + 1;
			} else end = mid - 1;
		}
		
	}
	
	public static boolean isSatisfied(long cable) {
		int cnt = 0;
		
		for (long c : arr)
			cnt += c / cable;
		
		if (cnt >= N) return true;
		else return false;
	}

}
