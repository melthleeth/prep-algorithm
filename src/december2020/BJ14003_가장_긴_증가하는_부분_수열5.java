package december2020;
import java.util.*;
import java.io.*;


public class BJ14003_가장_긴_증가하는_부분_수열5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int maxValue = 0;
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp[0] = arr[0];
		for (int i = 1; i < N; i++) {
			
			
		}
		
		bw.write(maxValue + "\n");
		
		br.close();
		bw.close();

	}

}
