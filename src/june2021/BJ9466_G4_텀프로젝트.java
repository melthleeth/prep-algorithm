package june2021;

import java.io.*;
import java.util.*;

public class BJ9466_G4_텀프로젝트 {
	static int T, n, sum;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			n = Integer.parseInt(br.readLine());
			sum = n;
			arr = new int[n + 1];
			visited = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			
			
			for (int i = 0; i < n; i++)
				if (!visited[i]) explore(i, i, 0);
			
			bw.write(sum + "\n");
		}
		br.close();
		bw.close();
	}
	
	public static void explore(int start, int n, int cnt) {
		if (visited[n]) {
			if (n == start)
				sum -= cnt;
			
			return;
		}
		
		visited[n] = true;
		explore(start, arr[n], cnt + 1);
//		visited[n] = false;
	}

}
