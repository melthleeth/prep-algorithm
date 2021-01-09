package January2021;
import java.io.*;
import java.util.*;

public class BJ3055_G5_탈출 {
	static int R, C, startX, startY;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static char[][] map;
	static Queue<Coord> water = new LinkedList<>();
	static Queue<Coord> hedgehog = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R + 2][C + 2];
		visited = new boolean[R + 2][C + 2];
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					hedgehog.offer(new Coord(i, j, 0));
					visited[i][j] = true;
					map[i][j] = '.';
				}
				else if (map[i][j] == '*') {
					water.offer(new Coord(i, j));
					visited[i][j] = true;
				}
			}
		}
		solve();
		br.close();
	}
	
	public static void print(int x, int y) {
		System.out.println("x, y = " + x + ", " + y);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (i == x && j == y)
					System.out.print("S");
				else System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void solve() {
		while(!hedgehog.isEmpty()) {
			int size = water.size();
			for (int i = 0; i < size; i++) {
				int wx = water.peek().x;
				int wy = water.peek().y;
				water.poll();
				for (int d = 0; d < 4; d++) {	
					int nx = wx + pos_x[d];
					int ny = wy + pos_y[d];
					
					if (!isIn(nx, ny) || map[nx][ny] == 'D') continue;
					visited[nx][ny] = true;
					map[nx][ny] = '*';
					water.offer(new Coord(nx, ny));
				}
			}
			size = hedgehog.size();
			for (int i = 0; i < size; i++) {
				int x = hedgehog.peek().x;
				int y = hedgehog.peek().y;
				int t = hedgehog.peek().time;
				hedgehog.poll();
				
				//print(x, y);
				
				if (map[x][y] == 'D') {
					System.out.println(t);
					return;
				}
				
				for (int d = 0; d < 4; d++) {	
					int nx = x + pos_x[d];
					int ny = y + pos_y[d];
					
					if (!isIn(nx, ny)) continue;
					visited[nx][ny] = true;
					hedgehog.offer(new Coord(nx, ny, t + 1));
				}
			}
		}
		System.out.println("KAKTUS");
	}
	
	public static boolean isIn(int x, int y) {
		if (x < 0 || x >= R || y < 0 || y >= C || visited[x][y] || map[x][y] == '*' || map[x][y] == 'X') return false;
		
		return true;
	}
	
	static class Coord {
		int x;
		int y;
		int time;
		
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Coord(int x, int y, int time) {
			this(x, y);
			this.time = time;
		}
		
	}

}
