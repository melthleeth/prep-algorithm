package January2021;

import java.util.*;
import java.io.*;

// 2021.01.03 아니 분명 맞게 풀었는데 왜 계속 틀리게 나오다가 갑자기 마지막에 잘나오냐고;;;;;;;

public class BJ8982_G3_수족관 {
	static int N, K, xPrev, hPrev, xNext, hNext, upperBound, ans;
	static int[] height = new int[40001];
	static int[] surface = new int[40001];
	static int[] holes;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(ans);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		br.readLine();
		for (int i = 0; i < N / 2 - 1; i++) {
			st = new StringTokenizer(br.readLine());
			xPrev = Integer.parseInt(st.nextToken());
			hPrev = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			xNext = Integer.parseInt(st.nextToken());
			hNext = Integer.parseInt(st.nextToken());
			
			for (int x = xPrev; x < xNext; x++) height[x] = hPrev;
		}
		br.readLine();
		upperBound = xNext;
		
		K = Integer.parseInt(br.readLine());
		holes = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			holes[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
	}
	
	public static void solve() {
		for (int x : holes) {
			int h = height[x];
			surface[x] = h;
			
			for (int i = x - 1; i >= 0; i--) {
				h = Math.min(h, height[i]);
				surface[i] = Math.max(surface[i], h);
			}
			h = height[x];
			for (int i = x + 1; i < upperBound; i++) {
				h = Math.min(h, height[i]);
				surface[i] = Math.max(surface[i], h);
			}
		}
//		
//		for (int i = 0; i < upperBound; i++)
//			System.out.printf("%3d", height[i]);
//		System.out.println();
//		for (int i = 0; i < upperBound; i++)
//			System.out.printf("%3d", surface[i]);
//		System.out.println();
		for (int i = 0; i < upperBound; i++)
			ans += height[i] - surface[i];
	}

}
