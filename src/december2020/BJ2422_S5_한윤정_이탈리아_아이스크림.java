package december2020;
import java.util.*;
import java.io.*;

public class BJ2422_S5_한윤정_이탈리아_아이스크림 {
	static int N, M, ans;
	static boolean[][] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N + 1][N + 1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}
		
		for (int i = 1; i <= N - 2; i++) {
			for (int j = i + 1; j <= N - 1; j++) {
				if (map[i][j]) continue;
				for (int k = j + 1; k <= N; k++) {
					if (map[i][k] || map[j][k]) continue;
					//System.out.println(i + " " + j + " " + k);
					ans++;
				}
			}
		}
		
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}