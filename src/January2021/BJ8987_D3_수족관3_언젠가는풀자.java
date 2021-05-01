package January2021;

import java.io.*;
import java.util.*;

public class BJ8987_D3_수족관3_언젠가는풀자 {
	static int N, K, upperBound = 1 << 18, height;
	static long ans;
	static long[] x = new long[1 << 18];
	static long[] y = new long[1 << 18];
	static Coord[] segTree = new Coord[1 << 19]; // left, right child라 2배 해줘야됨
	static PriorityQueue<Long> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		input();
		init();
		long depth = find(0, N - 1);
		pq.offer(depth);
		
		for (int i = 0; i < K; i++) {
			if (pq.isEmpty()) break;
			
			ans += pq.poll();
		}
		
		System.out.println(ans);
	}
	
	public static void input() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		System.out.println(upperBound);
		N = Integer.parseInt(br.readLine());
		N >>= 1; // = N / 2
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			br.readLine();
		}
		
		K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < segTree.length; i++)
			segTree[i] = new Coord(0, 0);
		
		br.close();
	}
	
	public static void init() {
		for (int i = 0; i < N; i++) {
			segTree[i | upperBound] = new Coord(y[i], i);
			System.out.println("segTree[" + (i | upperBound) + "] = " + segTree[i | upperBound].x + ", " + segTree[i | upperBound].y);
		}
		for (int i = upperBound - 1; i > 0; i--)
			segTree[i] = min(segTree[i << 1], segTree[i << 1 | 1]);
		
	}
	
	public static Coord min(Coord o1, Coord o2) {
		Coord temp = new Coord(0, 0);
		
		if (o1.x > o2.x) {
			temp.x = o2.x;
			temp.y = o2.y;
		} else {
			temp.x = o1.x;
			temp.y = o1.y;
		}
		
		return temp;
	}
	
	public static long find(int start, int end) { // 물이 제일 많이 빠지는 지점 찾기
		if (start >= end) return 0;
		
		int idx = query(start, end - 1); // 분할지점
		int prev = height;
		height = (int)y[idx];
		
		long child1 = find(start, idx), child2 = find(idx + 1, end);
		pq.offer(Math.min(child1, child2));
		height = prev;
		
		return Math.max(child1, child2) + (x[end] - x[start]) * (y[idx] - height);
	}
	
	public static int query(int left, int right) {
		left |= upperBound;
		right |= upperBound;
		Coord val = new Coord((long)1e18, (long)1e18);
		
		while (left <= right) {
			if ((left & 1) == 1) val = min(val, segTree[left++]);
			if ((~right & 1) == 1) val = min(val, segTree[right--]);
			
			left >>= 1;
			right >>= 1;
		}
		
		return (int)val.y;
	}
	
	static class Coord {
		long x;
		long y;
		
		public Coord(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}

}
