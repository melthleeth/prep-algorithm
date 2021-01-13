package January2021;
import java.io.*;
import java.util.*;

public class BJ16234_인구이동 {
	static int N, L, R, move, sum;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };
	static int[][] map, temp;
	static boolean[][] visited;
	static boolean flag;
	static Queue<Coord> candidate = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N + 2][N + 2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		while(true) {
			flag = false;
			visited = new boolean[N + 2][N + 2];
			temp = new int[N + 2][N + 2];
			for (int[] row : temp)
				Arrays.fill(row, -1);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						visited[i][j] = true;
						solve(i, j);
						
						if (candidate.size() > 1) {
							flag = true;
							movePeople();
						}
						candidate.clear();
					}
				}
			}
			
			if (!flag) break;
			migrate();
			move++;
			
//			print();
		}
		
		System.out.println(move);
		br.close();
	}
	
	public static void print() {
		for (int[] row : map) {
			for (int col : row) {
				System.out.printf("%3d", col);
			}
			System.out.println();
		}
	}
	
	public static void movePeople() {
		int avg = sum / candidate.size();

//		System.out.println("sum: " + sum);
//		System.out.println("avg: " + avg);
		
		while(!candidate.isEmpty()) {
			int x = candidate.peek().x;
			int y = candidate.peek().y;
			candidate.poll();
			
			temp[x][y] = avg;
		}
	}
	
	public static void migrate() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (temp[i][j] == -1) continue;
				map[i][j] = temp[i][j];
			}
		}
	}
	
	public static void solve(int i, int j) {
		Queue<Coord> q = new LinkedList<>();
		
		q.offer(new Coord(i, j));
		candidate.offer(new Coord(i, j));
		sum = map[i][j];
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = x + pos_x[d];
				int ny = y + pos_y[d];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				
				int diff = Math.abs(map[nx][ny] - map[x][y]);
				if (diff < L || diff > R) continue;
				
				visited[nx][ny] = true;
				q.offer(new Coord(nx, ny));
				sum += map[nx][ny];
				candidate.offer(new Coord(nx, ny));
			}
		}
	}
	
	static class Coord {
		int x;
		int y;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
