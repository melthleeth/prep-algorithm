package june2021;

import java.io.*;
import java.util.*;

public class BJ9466_G4_텀프로젝트 {
	static int T, n, cnt;
	static final int SIZE = 100010;
	static int[] arr;
	static boolean[] visited, finished;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			n = Integer.parseInt(br.readLine());
			cnt = 0;
			arr = new int[SIZE];
			visited = new boolean[SIZE];
			finished = new boolean[SIZE];
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= n; i++)
				if (!visited[i]) explore(i);


			bw.write((n - cnt) + "\n");
		}
		br.close();
		bw.close();
	}
	
	public static void explore(int n) {
		visited[n] = true;

		int next = arr[n];

		if (!visited[next]) explore(next);
		else if (!finished[next]) {
			for (int i = next; i != n; i = arr[i]) cnt++;
			cnt++;
		}
		finished[n] = true;
	}

}
