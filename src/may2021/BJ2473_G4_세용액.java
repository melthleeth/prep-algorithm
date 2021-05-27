package may2021;

import java.io.*;
import java.util.*;

public class BJ2473_G4_세용액 {
	static int N, left, right, third;
	static long sum, current, leftValue, rightValue, thirdValue;
	static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new long[N];

		for (int i = 0; i < N; i++)
			arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		sum = Long.MAX_VALUE;
		
		for (int k = 0; k < N - 2; k++) {
			left = k + 1;
			right = N - 1;
			
			while (left < right) {
				current = arr[k] + arr[left] + arr[right];
//				System.out.println("left: " + arr[left] + ", right: " + arr[right] + ", mid: " + arr[mid] + ", sum: " + sum + ", current: " + current);
				
				if (Math.abs(current) < Math.abs(sum)) {
					sum = current;
					leftValue = arr[left];
					rightValue = arr[right];
					thirdValue = arr[k];
				} 
				
				if (current < 0) left++;
				else if (current > 0) right--;
				else {
					left++;
					right--;
				}
			}
		}
		
		bw.write(thirdValue + " " + leftValue + " " + rightValue);
		br.close();
		bw.close();
	}

}
