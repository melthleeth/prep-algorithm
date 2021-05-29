package may2021;

import java.io.*;
import java.util.*;

public class BJ7662_G5_이중우선순위큐 {
	static int T, K, SIZE;
	static PriorityQueue<Numbers> pqAsc, pqDesc;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		
		for (int index = 0; index < T; index++) {
			K = Integer.parseInt(br.readLine());
			pqAsc = new PriorityQueue<>(new Comparator<Numbers>() {

				@Override
				public int compare(Numbers o1, Numbers o2) {
					return Long.compare(o1.val, o2.val);
				}
				
			});
			pqDesc = new PriorityQueue<>(new Comparator<Numbers>() {

				@Override
				public int compare(Numbers o1, Numbers o2) {
					return Long.compare(o2.val, o1.val);
				}
				
			});
			visited = new boolean[1000001];
			SIZE = 0;
			
			for (int i = 0; i < K; i++) {
				String[] op = br.readLine().split(" ");
				
				switch(op[0].charAt(0)) {
				case 'I':
					long num = Integer.parseInt(op[1]);
					
					pqAsc.offer(new Numbers(num, i));
					pqDesc.offer(new Numbers(num, i));
					visited[i] = true;
					SIZE++;
					
					break;
				case 'D':
					if (SIZE > 0) {
						if (Integer.parseInt(op[1]) == 1) {
							while(!visited[pqDesc.peek().idx]) pqDesc.poll();
							
							visited[pqDesc.peek().idx] = false;
							pqDesc.poll();
						}
						else {
							while(!visited[pqAsc.peek().idx]) pqAsc.poll();
							
							visited[pqAsc.peek().idx] = false;
							pqAsc.poll();
						}
						
						SIZE--;
					}
					break;
				}
//				System.out.println(pqAsc + " / " + pqDesc + " / " + SIZE);
			}
			if (SIZE == 0) bw.write("EMPTY\n");
			else {
				while(!visited[pqDesc.peek().idx]) pqDesc.poll();
				while(!visited[pqAsc.peek().idx]) pqAsc.poll();
				
				bw.write(pqDesc.peek().val + " " + pqAsc.peek().val + "\n");
			}
			
		}
		br.close();
		bw.close();
	}
	
	static class Numbers {
		long val;
		int idx;
		
		public Numbers(long val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}

}
