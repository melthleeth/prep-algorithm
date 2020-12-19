package december2020;
import java.util.*;
import java.io.*;

// 2020.12.12

public class BJ16236_아기상어 {
	static final int BABY_SHARK = 500;
	static int[][] sea;
	static int N, t, babySharkX, babySharkY, babyShark = 2, eaten;
	static boolean flag = false;
	static int[] pos_x = { 1, 0, -1, 0 };
	static int[] pos_y = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input();
		while (!flag) {
			solve();
			//print();
			//System.out.println("size, time: " + babyShark + ", " + t);
		}
		bw.write(String.valueOf(t));
		bw.close();
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new StringReader(src));

		N = Integer.parseInt(br.readLine());
		sea = new int[N + 2][N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					babySharkX = i;
					babySharkY = j;
				}
			}
		}
		br.close();
	}
	
	public static void print() {
		for (int[] row : sea) {
			for (int col : row)
				System.out.printf("%5d", col);
			System.out.println();
		}
	}

	public static void solve() {
		//System.out.println("size: " + babyShark + ", direction: " + babySharkX + ", " + babySharkY);
		
		boolean[][] visited = new boolean[N + 2][N + 2];
		Queue<Shark> q = new LinkedList<>();
		PriorityQueue<Shark> pq = new PriorityQueue<>(new Comparator<Shark>() {

			@Override
			public int compare(Shark o1, Shark o2) {
				if (o1.d == o2.d) {
					if (o1.x == o2.x)
						return Integer.compare(o1.y, o2.y);
					return Integer.compare(o1.x, o2.x);
				}
				return Integer.compare(o1.d, o2.d);
			}
			
		});
		
		q.offer(new Shark(babySharkX, babySharkY));
		//visited[babySharkX][babySharkX] = true;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.peek().d;
			q.poll();
			
			for (int dir = 0; dir < 4; dir++) {
				int x_next = x + pos_x[dir];
				int y_next = y + pos_y[dir];
				//System.out.println("다음좌표: " + x_next + ", " + y_next);
				
				if (x_next < 1 || x_next > N || y_next < 1 || y_next > N) {
					//System.out.println("ㄴ 범위 걸림");
					continue;
				}
				if (babyShark < sea[x_next][y_next] || visited[x_next][y_next]) {
					//System.out.println("ㄴ 크기, 방문체크 걸림");
					continue;
				}
//				if (sea[x_next][y_next] > babyShark) {
//					System.out.println("ㄴ 크기걸림, " + sea[x_next][y_next]);
//					continue;
//				}
//				if (visited[x_next][y_next]) {
//					System.out.println("ㄴ 방문체크 걸림, " + visited[x_next][y_next]);
//					continue;
//				}
				
				if (babyShark > sea[x_next][y_next] && sea[x_next][y_next] > 0) {
					pq.offer(new Shark(x_next, y_next, d + 1));
					//System.out.println("후보: " + x_next + ", " + y_next);
				}
				else
					q.offer(new Shark(x_next, y_next, d + 1));
				
				visited[x_next][y_next] = true;
			}
		}
		
		if (pq.isEmpty()) flag = true;
		else {
			eaten++;
			t += pq.peek().d;
			
			if (babyShark == eaten) {
				babyShark++;
				eaten = 0;
			}
			
			sea[babySharkX][babySharkY] = -1;
			babySharkX = pq.peek().x;
			babySharkY = pq.peek().y;
			sea[babySharkX][babySharkY] = BABY_SHARK;
			
			//System.out.println("먹은 물고기: " + pq.peek().x + ", " + pq.peek().y + ", d = " + pq.peek().d);
		}
	}

	static class Shark {
		int x;
		int y;
		int d;

		public Shark(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public Shark(int x, int y) {
			this(x, y, 0);
		}

	}

	static String src = "7\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 9";
}
