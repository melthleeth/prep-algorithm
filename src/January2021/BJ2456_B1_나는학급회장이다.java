package January2021;
import java.io.*;
import java.util.*;

public class BJ2456_B1_나는학급회장이다 {
	static int N, maxScore, maxThree;
	static final int SUM = 0;
	static int[][] score;
	static boolean undefined;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		score = new int[3][4];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());
			int s3 = Integer.parseInt(st.nextToken());
			
			score[0][SUM] += s1;
			score[0][s1]++;
			score[1][SUM] += s2;
			score[1][s2]++;
			score[2][SUM] += s3;
			score[2][s3]++;
		}
		
		maxScore = Math.max(score[0][SUM], score[1][SUM]);
		maxScore = Math.max(score[1][SUM], score[2][SUM]);
		
		maxThree = Math.max(score[0][3], score[1][3]);
		maxThree = Math.max(score[1][3], score[2][3]);
		
		PriorityQueue<Poll> pq = new PriorityQueue<>(new Comparator<Poll>() {

			@Override
			public int compare(Poll o1, Poll o2) {
				if (o1.total == o2.total) {
					if (o1.three == o2.three) {
						if (o1.two == o2.two) {
							if (maxThree == o1.three)
								undefined = true;
							return 1;
						}
						return Integer.compare(o1.two, o2.two) * -1;
					}
					return Integer.compare(o1.three, o2.three) * -1;
				}
				return Integer.compare(o1.total, o2.total) * -1;
			}
			
		});
		
		for (int i = 0; i < 3; i++)
			pq.offer(new Poll((i + 1), score[i][3], score[i][2], score[i][1], score[i][SUM]));
		
		if (undefined) System.out.println("0 " + maxScore + "\n");
		else System.out.println(pq.peek().idx + " " + pq.peek().total);

	}
	
	static class Poll {
		int idx;
		int three;
		int two;
		int one;
		int total;
		
		public Poll(int idx, int three, int two, int one, int total) {
			this.idx = idx;
			this.three = three;
			this.two = two;
			this.one = one;
			this.total = total;
		}
		
	}

}
