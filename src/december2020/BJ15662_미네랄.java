package december2020;
import java.util.*;
import java.io.*;

// 2020.12.20
// 반례모음: https://www.acmicpc.net/board/view/51662
public class BJ15662_미네랄 {
	static int R, C, N;
	static List<Mineral> mineral;
	static char[][] map;
	static boolean[][] visited;
	static int[] order;
	static int[] pos_r = { 1, 0, -1, 0 };
	static int[] pos_c = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		input();
		solve();
		//System.out.println("answer: ");
		print();
	}
	
	public static void print() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}
	
	public static void print_visited() {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (visited[r][c]) System.out.print("O");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//br = new BufferedReader(new StringReader(src));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			char[] temp = br.readLine().toCharArray();
		
			for (int c = 0; c < C; c++)
				map[r][c] = temp[c];
		}
		
		N = Integer.parseInt(br.readLine());
		order = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++)
			order[n] = Integer.parseInt(st.nextToken());
	}
	
	public static void solve() {
		for (int n = 0; n < N; n++) {
			int bar = R - order[n];
//			System.out.println("bar: " + bar); // test
			
			if ((n + 2) % 2 == 0) {
//				System.out.println(n + ") 오른쪽으로"); // test
				loop:
					for (int c = 0; c < C; c++) {
						int r = bar;
						//for (int r = 0; r <= bar; r++) {
							if (map[r][c] == 'x') {
								//System.out.println("broken mineral [r, c] = " + r + ", " + c); // test
								map[r][c] = '.';
								for (int d = 0; d < 4; d++) {
									int nr = r + pos_r[d];
									int nc = c + pos_c[d];
									
									if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 'x') continue;
									
									mineral = new ArrayList<>();
									if (BFS(nr, nc)) moveCluster(nr, nc);
								}
								break loop;
							}
						//}
					}
			}
			else {
//				System.out.println(n + ") 왼쪽으로"); // test
				loop:
					for (int c = C - 1; c >= 0; c--) {
						int r = bar;
						//for (int r = 0; r <= bar; r++) {
							if (map[r][c] == 'x') {
//								System.out.println("broken mineral [r, c] = " + r + ", " + c);// test
								map[r][c] = '.';
								for (int d = 0; d < 4; d++) {
									int nr = r + pos_r[d];
									int nc = c + pos_c[d];
									
									if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 'x') continue;
									
									mineral = new ArrayList<>();
									if (BFS(nr, nc)) moveCluster(nr, nc);
									//print();
								}
								break loop;
							}
						//}
					}
			}
			//print();
		}
	}
	
	public static boolean BFS(int r, int c) {
		//System.out.println("BFS [r, c] = " + r + ", " + c); // test
		visited = new boolean[R][C];
		boolean cluster = true;
		Queue<Mineral> q = new LinkedList<>();
		mineral.add(new Mineral(r, c));
		q.offer(new Mineral(r, c));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = x + pos_r[d];
				int nc = y + pos_c[d];
				
				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != 'x' || visited[nr][nc]) continue;
				if (nr == R - 1) cluster = false;
				
				visited[nr][nc] = true;
				q.offer(new Mineral(nr, nc));
				mineral.add(new Mineral(nr, nc));
			}
		}
		
//		System.out.println("mineral: ");
//		for (Mineral m : mineral)
//			System.out.print("[" + m.x + ", " + m.y + "] ");
//		System.out.println();
		
//		print_visited(); // test
//		System.out.println("cluster? " + cluster); // test
		return cluster;
	}
	
	public static void moveCluster(int r, int c) {
//		System.out.println("moveCluster [r, c] = " + r + ", " + c); // test
		Collections.sort(mineral, new Comparator<Mineral>() {

			@Override
			public int compare(Mineral o1, Mineral o2) {
				if (o1.y == o2.y)
					return Integer.compare(o1.x, o2.x) * (-1);
				return Integer.compare(o1.y, o2.y);
			}
			
		});
		
		// test
//		System.out.println("mineral: ");
//		for (Mineral m : mineral)
//			System.out.print("[" + m.x + ", " + m.y + "] ");
//		System.out.println();
		
		// 클러스터 밑부분 정보 뽑기
		List<Mineral> bottom = new ArrayList<>();
		bottom.add(new Mineral(mineral.get(0).x, mineral.get(0).y));
		
		int temp = mineral.get(0).y;
		for (int i = 0; i < mineral.size(); i++) {
			if (mineral.get(i).y > temp) {
				temp++;
				bottom.add(new Mineral(mineral.get(i).x, mineral.get(i).y));
			}
		}
		
		// test
//		System.out.println("bottom: ");
//		for (Mineral b : bottom)
//			System.out.print("[" + b.x + ", " + b.y + "] ");
//		System.out.println();
		
		// bottom 정보로 얼마나 내려갈 수 있는지 보기
		int cnt = 0;
		for (int i = 1; i < R; i++) {
			boolean flag = true;
			for (int b = 0; b < bottom.size(); b++) {
				int x = bottom.get(b).x;
				int y = bottom.get(b).y;
				//System.out.print("[" + (x + i) + ", " + y + "] ");
				if (x + i >= R || map[x + i][y] == 'x') flag = false;
			}
			if (!flag) break; 
			cnt++;
		}
//		System.out.println("cnt: " + cnt);
		
		// 내려갈 수 있는 칸만큼 한방에 내리기
		for (int i = 0; i < mineral.size(); i++) {
			int x = mineral.get(i).x;
			int y = mineral.get(i).y;
			
			map[x][y] = '.';
			map[x + cnt][y] = 'x';
		}
	}
	
	static class Mineral {
		int x;
		int y;
		
		public Mineral(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static String src = "8 8\r\n" + 
			"........\r\n" + 
			"........\r\n" + 
			"...x.xx.\r\n" + 
			"...xxx..\r\n" + 
			"..xxx...\r\n" + 
			"..x.xxx.\r\n" + 
			"..x...x.\r\n" + 
			".xxx..x.\r\n" + 
			"5\r\n" + 
			"6 6 4 3 1";
}
