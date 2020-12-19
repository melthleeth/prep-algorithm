package december2020;
import java.util.*;
import java.io.*;

// 2020.12.14

public class BJ15683_감시 {
	static final int CAM = 10;
	static int N, M, ans;
	static ArrayList<CCTV> cctv = new ArrayList<>();
	static int[][] map;
	static boolean[][] visited = new boolean[10][5];
	static int[] pos_x = { 0, -1, 0, 1 };
	static int[] pos_y = { 1, 0, -1, 0 };
	static Set<Integer> result = new TreeSet<>();
	
	public static void main(String[] args) throws IOException {
		input();
		solve(0);
		System.out.println(ans);
//		for (int res : result)
//			System.out.print(res + ", ");
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		ans = N * M;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (1 <= map[i][j] && map[i][j] <= 5)
					cctv.add(new CCTV(i, j, map[i][j], getDirection(map[i][j])));
			}
		}
		br.close();
	}
	
	public static void solve(int depth) {
		if (depth == cctv.size()) {
			//print();
			ans = Math.min(ans, getDeadGround());
			return;
		}
		
		for (int i = 0; i < cctv.get(depth).n; i++) {
			if (visited[depth][i]) continue;
			visited[depth][i] = true;
			install(cctv.get(depth).x, cctv.get(depth).y, cctv.get(depth).cam, i, CAM);
			solve(depth + 1);
			visited[depth][i] = false;
			install(cctv.get(depth).x, cctv.get(depth).y, cctv.get(depth).cam, i, -CAM);
		}
	}
	
	public static int getDeadGround() {
		int sum = 0;
		
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= M; j++)
				if (map[i][j] == 0) sum++;

		//System.out.println("Dead ground: " + sum);
		result.add(sum);
		return sum;
	}
	
	public static void print() {
		System.out.println("result: ");
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				System.out.printf("%3d", map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// cctv 설치
	public static void install(int x, int y, int cam, int d, int status) {
		//System.out.println("[x, y, d] = " + x + ", " + y + ", " + d + ", [cam, status] = " + cam + ", " + status);
		changeStatus(x, y, d, status);
		if (cam == 3 || cam == 4 || cam == 5)
			changeStatus(x, y, d + 1, status);
		if (cam == 2 || cam == 4 || cam == 5)
			changeStatus(x, y, d + 2, status);
		if (cam == 5)
			changeStatus(x, y, d + 3, status);
		
		//print();
	}
	
	public static void changeStatus(int x, int y, int d, int status) {
		d %= 4;
		// p: prev, n: next
		int px = x, py = y, nx, ny;
		while(true) {
			nx = px + pos_x[d];
			ny = py + pos_y[d];
			
			if (!isIn(nx, ny)) break;
			
			map[nx][ny] += status;
			px = nx;
			py = ny;
		}
	}
	
	
	
	public static boolean isIn(int x, int y) {
		if (x < 1 || x > N || y < 1 || y > M || map[x][y] == 6)
			return false;
		
		return true;
	}
	
	public static int getDirection(int d) {
		int direction = 0;
		
		switch(d) {
		case 1:
		case 3:
		case 4:
			direction = 4;
			break;
		case 2:
			direction = 2;
			break;
		case 5:
			direction = 1;
			break;
		}
		
		return direction;
	}
	
	static class CCTV {
		int x;
		int y;
		int cam;
		int n;
		
		public CCTV(int x, int y, int cam, int n) {
			this.x = x;
			this.y = y;
			this.cam = cam;
			this.n = n;
		}
		
		
	}

	static String src = "6 6\r\n" + 
			"1 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0\r\n" + 
			"0 0 1 0 0 0\r\n" + 
			"0 0 0 1 0 0\r\n" + 
			"0 0 0 0 1 0\r\n" + 
			"0 0 0 0 0 1";
}
