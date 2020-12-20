package december2020;
import java.util.*;
import java.io.*;

// 2020.12.20
// 반례: https://www.acmicpc.net/board/view/30219

public class BJ14890_경사로 {
	static int N, L, ans;
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		input();
		solve_horizontal();
		solve_vertical();
		System.out.println(ans);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void solve_horizontal() {
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			condition:
			for (int j = 0; j < N - 1; j++) {
				if (Math.abs(map[i][j] - map[i][j + 1]) > 1) {
					flag = false;
					break condition;
				}
				
				if (map[i][j] - 1 == map[i][j + 1]) {
					if (visited[i][j + 1]) {
						flag = false;
						break condition;
					}
					//System.out.println(j + ") " + map[i][j] + " -> " + map[i][j + 1]);
					visited[i][j + 1] = true;
					int val = map[i][j + 1];
					
					for (int k = j + 2; k <= j + L; k++) {
						if (k >= N || visited[i][k] || map[i][k] != val) {
							flag = false;
							break condition;
						}
						visited[i][k] = true;
					}
				} else if (map[i][j] + 1 == map[i][j + 1]) {
					if (visited[i][j]) {
						flag = false;
						break condition;
					}
					//System.out.println(j + ") " + map[i][j] + " <- " + map[i][j + 1]);
					visited[i][j] = true;
					int val = map[i][j];
					
					for (int k = j - 1; k >= j + 1 - L; k--) {
						if (k < 0 || visited[i][k] || map[i][k] != val) {
							flag = false;
							break condition;
						}
						visited[i][k] = true;
					}
				}
			}
			if (flag) {
				System.out.println("i: " + i);
				ans++;
			}
		}
	}
	
	public static void solve_vertical() {
		visited = new boolean[N][N];
		
		for (int y = 0; y < N; y++) {
			boolean flag = true;
			condition:
				for (int x = 0; x < N - 1; x++) {
					if (Math.abs(map[x][y] - map[x + 1][y]) > 1) {
						flag = false;
						break condition;
					}
					
					if (map[x][y] - 1 == map[x + 1][y]) {
						if (visited[x + 1][y]) {
							flag = false;
							break condition;
						}
						
						visited[x + 1][y] = true;
						int val = map[x + 1][y];
						
						for (int k = x + 2; k <= x + L; k++) {
							if (k >= N || visited[k][y] || map[k][y] != val) {
								flag = false;
								break condition;
							}
							visited[k][y] = true;
						}
					} else if (map[x][y] + 1 == map[x + 1][y]) {
						if (visited[x][y]) {
							flag = false;
							break condition;
						}
						visited[x][y] = true;
						int val = map[x][y];
						
						for (int k = x - 1; k >= x + 1 - L; k--) {
							if (k < 0 || visited[k][y] || map[k][y] != val) {
								flag = false;
								break condition;
							}
							visited[k][y] = true;
						}
					}
				}
			if (flag) {
				System.out.println("y: " + y);
				ans++;
			}
		}
	}
	
	static String src = "6 1\r\n" + 
			"3 3 3 3 3 3\r\n" + 
			"3 3 4 3 3 3\r\n" + 
			"2 3 3 3 3 3\r\n" + 
			"2 2 3 4 3 2\r\n" + 
			"2 3 3 4 3 2\r\n" + 
			"3 3 3 3 3 2";
}
