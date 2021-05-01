package may2021;

/*
도무지 이해가 안되서 풀이도 여러개 봤는데 대체 왜 틀린지 모르겠다.
이 풀이로 맞긴 했는데 다시 봐야할 것 같다. 
 */

import java.util.*;
import java.io.*;

public class BJ11060_S2_점프점프 {
	static int N;
	static int[] ans, num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		ans = new int[N];
		num = new int[N];
		
		Arrays.fill(ans, -1);
		ans[0] = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 
			num[i] = Integer.parseInt(st.nextToken());
			
		for (int i = 0; i < N - 1; i++) {	
			if (ans[i] == -1) continue;
			
			for (int j = 1; i + j < N && j <= num[i]; j++) {
				if (ans[i + j] > ans[i] + 1 || ans[i + j] == -1)
					ans[i + j] = ans[i] + 1;
			}

		}
//		System.out.println(Arrays.toString(ans));
		bw.write(String.valueOf(ans[N - 1]));
		br.close();
		bw.close();
	}

}
