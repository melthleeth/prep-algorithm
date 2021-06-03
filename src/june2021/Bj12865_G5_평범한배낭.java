package june2021;

import java.io.*;
import java.util.*;

public class Bj12865_G5_평범한배낭 {
	static int N, K, maxValue;
	static int[][] product;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		product = new int[N + 1][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			product[i][0] = Integer.parseInt(st.nextToken());
			product[i][1] = Integer.parseInt(st.nextToken());
		}
		
		bw.write(String.valueOf(maxValue));
		br.close();
		bw.close();
	}

}
