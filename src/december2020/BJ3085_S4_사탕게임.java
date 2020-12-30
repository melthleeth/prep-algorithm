package december2020;
import java.io.*;

// 2020.12.30

public class BJ3085_S4_사탕게임 {
	static int N, ans;
	static char[][] map;
	static boolean[][] visited;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = true;
				solve(i, j);
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	public static void solve(int x, int y) {
		for (int d = 0; d < 4; d++) {
			int nx = x + pos_x[d];
			int ny = y + pos_y[d];
			
			if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
			swap(x, y, nx, ny);
			ans = Math.max(ans, count(x, y, d));
			swap(x, y, nx, ny);
		}
	}
	
	public static void swap(int px, int py, int nx, int ny) {
		char temp = map[px][py];
		map[px][py] = map[nx][ny];
		map[nx][ny] = temp;
	}
	
	public static int count(int x, int y, int d) {
		int cnt = Math.max(getRowCount(x), getColCount(y));
		
		switch(d) {
			case 0:
				cnt = Math.max(cnt, getRowCount(x + 1));
				break;
			case 1:
				cnt = Math.max(cnt, getColCount(y + 1));
				break;
			case 2:
				cnt = Math.max(cnt, getRowCount(x - 1));
				break;
			case 3:
				cnt = Math.max(cnt, getColCount(y - 1));
				break;
		}
		
		return cnt;
	}
	
	public static int getRowCount(int row) {
		int cnt = 1;
		int maxValue = 0;
		for (int j = 0; j < N - 1; j++) {
			if (map[row][j] == map[row][j + 1]) cnt++;
			else cnt = 1;
			
			maxValue = Math.max(cnt, maxValue);
		}
		
		return maxValue;
	}
	
	public static int getColCount(int col) {
		int cnt = 1;
		int maxValue = 0;
		for (int i = 0; i < N - 1; i++) {
			if (map[i][col] == map[i + 1][col]) cnt++;
			else cnt = 1;
			
			maxValue = Math.max(cnt, maxValue);
		}
		
		return maxValue;
	}

}
