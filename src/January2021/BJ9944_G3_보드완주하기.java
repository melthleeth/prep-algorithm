package January2021;

import java.util.*;
import java.io.*;

// 2021.01.03 N, M <= 30
// 돌아가는 부분에서 문제가 생긴 것 같거든..? 아침에 고치자ㅠ 

public class BJ9944_G3_보드완주하기 {
	static int N, M, ans = (int)1e6, total;
	static int[][] board;
	static boolean[][] visited;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				if (temp[j - 1] == '.') {
					board[i][j] =  1;
					total++;
				} else board[i][j] = 0;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (board[i][j] == 1) {
					System.out.println("-- start: " + i + ", " + j);
					visited = new boolean[N + 2][M + 2];
					visited[i][j] = true;
					solve(i, j, 0);
				}
			}
		}
		bw.write("Case : " + ans + "\n");
		br.close();
		bw.close();
	}
	
	public static void print(String str) {
		System.out.println(str);
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (visited[i][j]) System.out.print("O");
				else System.out.print("X"); 
			}
			System.out.println();
		}
	}
	
	public static void solve(int x, int y, int move) {
		System.out.println("[x, y, move] = " + x + ", " + y + ", " + move);
		
		if (move > ans) return;
		if (!hasSpace(x, y) && getSpace() == total) {
			System.out.println("move: " + move);
			ans = Math.min(ans, move);
		}
		
		for (int d = 0; d < 4; d++) {
			int nx = x + pos_x[d];
			int ny = y + pos_y[d];
			
			if (!isIn(nx, ny) || visited[nx][ny]) continue;
			
			while(isIn(nx, ny)) {
				System.out.println("[move] nx, ny = " + nx + ", " + ny);
				visited[nx][ny] = true;
				nx += pos_x[d];
				ny += pos_y[d];
			}
			move++;
			print("go to " + d);
			nx -= pos_x[d];
			ny -= pos_y[d];
			solve(nx, ny, move);
			while(isIn(nx, ny)) {
				System.out.println("[remove] nx, ny = " + nx + ", " + ny);
				visited[nx][ny] = false;
				nx -= pos_x[d];
				ny -= pos_y[d];
			}
			move--;
			print("back to " + (d + 2) % 4);
		}
	}
	
	public static boolean isIn(int nx, int ny) {
		if (nx < 1 || nx > N || ny < 1 || ny > M || board[nx][ny] == 0) return false;
		return true;
	}
	
	public static boolean hasSpace(int x, int y) {
		for (int d = 0; d < 4; d++)
			if (board[x + pos_x[d]][y + pos_y[d]] == 0) return false;
		
		return true;
	}
	
	public static int getSpace() {
		int sum = 0;
		
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				if (visited[i][j]) sum++;
		
		return sum;
	}

}
