package december2020;
import java.util.*;
import java.io.*;

// 반례: https://www.acmicpc.net/board/view/55687
// 2020.12.27

public class BJ14500_테트로미노 {
	static int N, M, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		input();
		solve();
		System.out.println(ans);
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 4][M + 4];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= M; j++) 
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	public static void solve() {
		for (int i = 1; i <= N - 1; i++) {
			for (int j = 1; j <= M; j++) { 
				int temp = Math.max(R3C1(i, j), R2C1(i, j));
				ans = Math.max(ans, temp);
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M - 1; j++) {
				int temp = Math.max(R1C3(i, j), R1C2(i, j));
				ans = Math.max(ans, temp);
			}
		}
	}
	
	public static int R3C1(int x, int y) {
		int base = map[x][y] + map[x + 1][y] + map[x + 2][y];
		int maxValue = 0;
		
		for (int i = 0; i < 3; i++) {
			maxValue = Math.max(maxValue, base + map[x + i][y - 1]);
			maxValue = Math.max(maxValue, base + map[x + i][y + 1]);
		}
			maxValue = Math.max(maxValue, base + map[x + 3][y]);
		
		return maxValue;
	}
	
	public static int R2C1(int x, int y) {
		//System.out.println("[R2C1] x, y = " + x + ", " + y);
		int base = map[x][y] + map[x + 1][y];
		int maxValue = 0;
		
		int[] val = { map[x][y + 1] + map[x + 1][y + 1], 
				map[x + 1][y + 1] + map[x + 2][y + 1], 
				map[x + 2][y] + map[x + 3][y], 
				map[x + 1][y - 1] + map[x + 2][y - 1] };
		
		//System.out.println("base: " + base);
		//System.out.println(Arrays.toString(val));
		
		for (int i = 0; i < val.length; i++)
			maxValue = Math.max(maxValue, base + val[i]);
		return maxValue;
	}
	
	public static int R1C3(int x, int y) {
		int base = map[x][y] + map[x][y + 1] + map[x][y + 2];
		int maxValue = 0;
		
		for (int j = 0; j < 3; j++) {
			maxValue = Math.max(maxValue, base + map[x - 1][y + j]);
			maxValue = Math.max(maxValue, base + map[x + 1][y + j]);
		}
		maxValue = Math.max(maxValue, base + map[x][y + 3]);
		
		return maxValue;
	}
	
	public static int R1C2(int x, int y) {
//		System.out.println("[R1C2] x, y = " + x + ", " + y);
		int base = map[x][y] + map[x][y + 1];
		int maxValue = 0;
		
		int[] val = { map[x + 1][y - 1] + map[x + 1][y], map[x + 1][y + 1] + map[x + 1][y + 2] };
		
//		System.out.println("base: " + base);
//		System.out.println(Arrays.toString(val));
		
		for (int i = 0; i < val.length; i++)
			maxValue = Math.max(maxValue, base + val[i]);
		
		return maxValue;
	}

}
