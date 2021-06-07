package june2021;

import java.io.*;
import java.util.*;

// 틀린 이유: dp[i - 1][j - W[i]] + V[i] 에서 dp[i][j - W[i]] + V[i] 라고 해서

public class Bj12865_G5_평범한배낭 {
	static int N, K, maxValue;
	static int[] W, V;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N + 1];
		V = new int[N + 1];
		dp = new int[N + 1][K + 1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int j = 1; j <= K; j++) {
			for (int i = 1; i <= N; i++) {
				if (j - W[i] >= 0)
					dp[i][j] = Math.max(dp[i - 1][j - W[i]] + V[i], dp[i - 1][j]);
				else
					dp[i][j] = dp[i - 1][j];
			} 
		}

//		for (int[] row : dp)
//			System.out.println(Arrays.toString(row));
		
		bw.write(String.valueOf(dp[N][K]));
		br.close();
		bw.close();
	}

}
