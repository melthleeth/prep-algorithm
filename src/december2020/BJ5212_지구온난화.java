package december2020;
import java.io.*;
import java.util.*;

import december2020.BJ15662_미네랄.Mineral;

//2020.12.21

public class BJ5212_지구온난화 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<Coord> arr = new ArrayList<>();
		char[][] map = new char[R + 2][C + 2];
		boolean[][] visited = new boolean[R + 2][C + 2];
		Queue<Coord> q = new LinkedList<>();
		int[] pos_x = { 1, 0, -1, 0 };
		int[] pos_y = { 0, 1, 0, -1 };
		
		for (int j = 0; j < C + 2; j++)
			map[0][j] = map[R + 1][j] = '.';
		
		for (int i = 1; i <= R; i++) {
			char[] temp = br.readLine().toCharArray();
			map[i][0] = map[i][C + 1] = '.';
			for (int j = 1; j <= C; j++) {
				map[i][j] = temp[j - 1];
				if (map[i][j] == 'X') q.offer(new Coord(i, j));
			}
		}
		
		visited[q.peek().x][q.peek().y] = true;
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			int cnt = 0;
			for (int d = 0; d < 4; d++) {
				int nx = x + pos_x[d];
				int ny = y + pos_y[d];
				
				if (map[nx][ny] == '.') cnt++;
				if (nx < 1 || nx > R || nx < 1 || ny > R || map[nx][ny] != 'X' || visited[nx][ny]) continue;

				visited[nx][ny] = true;
				q.offer(new Coord(nx, ny));
			}
			if (cnt >= 3) map[x][y] = 'O';
			else arr.add(new Coord(x, y));
		}
		
		Collections.sort(arr, new Comparator<Coord>() {

			@Override
			public int compare(Coord o1, Coord o2) {
				if (o1.x == o2.x)
					return Integer.compare(o1.y, o2.y);
				return Integer.compare(o1.x, o2.x);
			}
			
		});
		
		int xMin = arr.get(0).x, xMax = arr.get(arr.size() - 1).x;
		
		Collections.sort(arr, new Comparator<Coord>() {

			@Override
			public int compare(Coord o1, Coord o2) {
				if (o1.y == o2.y)
					return Integer.compare(o1.x, o2.x);
				return Integer.compare(o1.y, o2.y);
			}
			
		});
		
		int yMin = arr.get(0).y, yMax = arr.get(arr.size() - 1).y;
		
		for (int i = xMin; i <= xMax; i++) {
			for (int j = yMin; j <= yMax; j++) {
				if (map[i][j] == 'O') map[i][j] = '.';
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		
		br.close();
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
