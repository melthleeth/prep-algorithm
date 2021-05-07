package december2020;
import java.util.*;
import java.io.*;

// 2020.12.31 세그먼트 트리 연습

public class BJ1168_요세푸스문제2 {
	static int N, K;
	static int[] tree;
	static ArrayList<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mod = N - 1;
		N = Integer.parseInt(st.nextToken());	
		K = Integer.parseInt(st.nextToken());
		tree = new int[N * 4];
		ans.add(K);
		
		for (int i = 1; i < N; i++)
			update(1, N, 1, i, 1);
		
		update(1, N, 1, ans.get(ans.size() - 1), 0);
	}
	
	public static int getMid(int start, int end) {
		return (start + end) >> 1;
	}
	
	public static int update(int start, int end, int idx, int target, int val) {
		if (target < start || target > end) return tree[idx];
		if (start == end) return tree[idx] = val;
		
		int mid = getMid(start, end);
//		update(start, mid, idx * 2, target, val);
//		update(mid + 1, end, idx * 2 + 1, target, val);
//		tree[idx] = tree[idx * 2] + tree[idx * 2 + 1];
		return tree[idx] = update(start, mid, idx * 2, target, val) + update(mid + 1, end, idx * 2 + 1, target, val);
	}

}
