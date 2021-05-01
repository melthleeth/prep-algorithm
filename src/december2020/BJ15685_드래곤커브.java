package december2020;
import java.util.*;
import java.io.*;

public class BJ15685_드래곤커브 {
	static int N;
	static DragonCurve[] dc;

	public static void main(String[] args) throws IOException {
		input();
		solve();

	}
	
	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		dc = new DragonCurve[N + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			dc[i].x = Integer.parseInt(st.nextToken());
			dc[i].y = Integer.parseInt(st.nextToken());
			dc[i].d = Integer.parseInt(st.nextToken());
			dc[i].g = Integer.parseInt(st.nextToken());
		}
		br.close();
	}
	
	public static void solve() {
		
	}
	
	
	static class DragonCurve {
		int x;
		int y;
		int d;
		int g;
		
		public DragonCurve(int x, int y, int d, int g) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.g = g;
		}
	}

}
