package may2021;

import java.io.*;
import java.util.*;

public class BJ121886_G5_돌그룹 {
	static int A, B, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(solve(A, B, C)));
		br.close();
		bw.close();
	}

	public static int solve(int a, int b, int c) {
		Queue<Numbers> q = new LinkedList<>();
		HashMap<Numbers, Boolean> visited = new HashMap<>();

		visited.put(new Numbers(a, b, c), true);

		q.offer(new Numbers(Math.max(a, b), Math.min(a, b), c));
		q.offer(new Numbers(Math.max(b, c), Math.min(b, c), a));
		q.offer(new Numbers(Math.max(c, a), Math.min(c, a), b));

		while (!q.isEmpty()) {
			int[] arr = { q.peek().x, q.peek().y, q.peek().z };
			q.poll();
			
			Numbers num = new Numbers(arr[0], arr[1], arr[2]);
//			if (visited.get(new Numbers(arr[0], arr[1], arr[2])) != null) continue;

//			System.out.println("#arr " + Arrays.toString(arr));

			if (arr[0] == arr[1] && arr[1] == arr[2])
				return 1;

			for (int i = 3; i < 6; i++) {
				if (arr[i % 3] == arr[(i + 1) % 3]) continue;

				int nx = Math.max(arr[i % 3], arr[(i + 1) % 3]);
				int ny = Math.min(arr[i % 3], arr[(i + 1) % 3]);

				int x = nx - ny;
				int y = ny + ny;
				int z = arr[(i + 2) % 3];
//				System.out.println(x + ", " + y + ", " + z);
//				num = new Numbers(x, y, z);
//				System.out.println("visited? " + visited.get(num));
				if (visited.get(new Numbers(x, y, z)) == null) {
					q.offer(new Numbers(x, y, z));
					visited.put(new Numbers(x, y, z), true);
//					System.out.println(visited.get(num));
				}

			}
		}

		return 0;
	}


	static class Numbers {
		int x;
		int y;
		int z;

		public Numbers(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		@Override
		public int hashCode() {
			return this.x * 1000000 + this.y * 1000 + this.z;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (this.getClass() != obj.getClass()) return false;
			
			Numbers num = (Numbers) obj;
			if (this.x != num.x || this.y != num.y || this.z != num.z) return false;
			return true;
		}
	}
}
