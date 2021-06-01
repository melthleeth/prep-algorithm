package may2021;

import java.io.*;
import java.util.*;

public class BJ1719_G4_택배 {
	static int n, m;
	static int[][] node, answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		node = new int[n + 1][n + 1];
		answer = new int[n + 1][n + 1];
		
		for (int[] arr : node)
			Arrays.fill(arr, 10000001);
		
		for (int i = 1; i <= n; i++)
			node[i][i] = 0;
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			node[from][to] = weight;
			node[to][from] = weight;
			answer[from][to] = to;
			answer[to][from] = from;
		}
		
		for (int via = 1; via <= n; via++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (i == j) continue;
					if (node[i][via] + node[via][j] < node[i][j]) {
						node[i][j] = node[i][via] + node[via][j];
						answer[i][j] = answer[i][via];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) bw.write("- ");
				else bw.write(answer[i][j] + " ");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}

}
