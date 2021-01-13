package January2021;
import java.io.*;
import java.util.*;

public class BJ10026_G5_적록색약 {
	static int N, area, area2;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N + 2][N + 2];
		for (int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		visited = new boolean[N + 2][N + 2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					solve(i, j, map[i][j]);
					area++;
				}
			}
		}
		visited = new boolean[N + 2][N + 2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					solve2(i, j, map[i][j]);
					area2++;
				}
			}
		}
		
		System.out.println(area + " " + area2);
		br.close();
	}
	public static void solve(int i, int j, char color) {
		Queue<Coord> q = new LinkedList<>();
		q.offer(new Coord(i, j));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = x + pos_x[d];
				int ny = y + pos_y[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] != color) continue;
				visited[nx][ny] = true;
				q.offer(new Coord(nx, ny));
			}
		}
	}
	
	public static void solve2(int i, int j, char color) {
		Queue<Coord> q = new LinkedList<>();
		q.offer(new Coord(i, j));
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nx = x + pos_x[d];
				int ny = y + pos_y[d];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) continue;
				if (color == 'B' && map[nx][ny] != color) continue;
				if ((color == 'G' || color == 'R') && map[nx][ny] == 'B') continue;
				
				visited[nx][ny] = true;
				q.offer(new Coord(nx, ny));
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
