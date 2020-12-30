package december2020;

import java.util.*;
import java.io.*;

public class BJ2210_S2_숫자판점프 {
	static int[] num = new int[7];
	static int[][] map = new int[7][7];
	static int[][] visited;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };
	static Set<String> set = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				visited = new int[7][7];
				solve(i, j, 0, 0);
			}
		}
		//set.forEach(e -> System.out.print(e + ", "));
		System.out.println(set.size());
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 1; i <= 5; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= 5; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	public static void solve(int x, int y, int depth, int sum) {
		if (depth == 6) {
//			StringBuilder sb = new StringBuilder();
//			
//			for (int i = 0; i < 6; i++)
//				sb.append(String.valueOf(num[i]));
			
			//set.add(sb.toString());
			set.add(Integer.toString(sum));
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + pos_x[i];
			int ny = y + pos_y[i];
			
			num[depth] = map[x][y];
			if (nx < 1 || nx > 5 || ny < 1 || ny > 5 || visited[nx][ny] > 5) continue;
			visited[nx][ny]++;
			solve(nx, ny, depth + 1, (sum * 10) + map[x][y]);
			visited[nx][ny]--;
		}
	}

}
