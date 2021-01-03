package January2021;
import java.util.*;
import java.io.*;

// 2021.01.03 예전에 많이 어려워했던 문제이다. N의 범위가 20까지밖에 안되기 때문에 2중 for문 (= 브루트포스) 돌려도 된다. ==> 시간초과 나는데요? 아니 i + 1을 해야지 idx + 1을 넣으면 어떻하냐..

public class BJ15661_S1_링크와스타트 {
	static int N, ans = (int)1e4;
	static boolean[] visited;
	static int[][] skills;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		skills = new int[N + 2][N + 2];
		visited = new boolean[N + 2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				skills[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 1);
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	public static void solve(int depth, int idx) {
		if (depth == N >> 1) {
			int sum = 0;
			for (int i = 1; i <= depth; i++) {
				for (int j = i + 1; j <= depth; j++) {
					if (visited[i] && visited[j]) sum += skills[i][j] + skills[j][i];
					else if (!visited[i] && !visited[j]) sum -= skills[i][j] + skills[j][i];
				}
			}
			sum = Math.abs(sum);
			ans = Math.min(ans, sum);
			
			return;
		}
		
		for (int i = idx; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			solve(depth + 1, i + 1);
			visited[i] = false;
		}
	}

}
