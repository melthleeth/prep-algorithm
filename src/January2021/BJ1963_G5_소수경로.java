package January2021;
import java.io.*;
import java.util.*;

// 2021.01.10 보고풀었지만 에라토스테네스의 체 신기하다

public class BJ1963_G5_소수경로 {
	static int T, ans, from, to;
	static final int MAX = 10001;
	static boolean[] primeNumber = new boolean[MAX];
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		init();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			ans = 0;
			visited = new int[MAX];
			
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			solve(from, to);
		}

	}
	
	// 에라토스테네스의 체 알아두자!!
	public static void init() {
		for (int i = 2; i < MAX; i++) {
			for (int j = 2; j < MAX; j++) {
				if (i * j >= 10000 || primeNumber[i * j]) continue;
				primeNumber[i * j] = true;
			}
		}
	}
	
	public static void solve(int from, int to) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(from);
		visited[from]++;
		
		while(!q.isEmpty()) {
			int currentNum = q.poll();
			
			if (currentNum == to) {
				System.out.println(visited[to] - 1);
				return;
			}
			
			for (int idx = 0; idx < 4; idx++) {
				for (int num = 0; num < 10; num++) {
					if (idx == 0 && num == 0) continue;
					char[] temp = Integer.toString(currentNum).toCharArray();
					temp[idx] = (char)(num + '0');
					StringBuilder sb = new StringBuilder();
					sb.append(temp[0]).append(temp[1]).append(temp[2]).append(temp[3]);
					int nextNum = Integer.parseInt(sb.toString());
					
					if (!primeNumber[nextNum]) {
						if (visited[nextNum] == 0 || visited[nextNum] > visited[currentNum] + 1) {
							q.offer(nextNum);
							visited[nextNum] = visited[currentNum] + 1;
						}
					}
					
				}
			}
		}
		System.out.println("Impossible");
	}

}
