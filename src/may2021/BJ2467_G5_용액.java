package may2021;

import java.io.*;
import java.util.*;

public class BJ2467_G5_용액 {
	static int N, left, right, leftValue, rightValue;
	static long sum, current;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		left = 0;
		right = N - 1;
		sum = Long.MAX_VALUE;
		
		while (left < right) {
			current = arr[left] + arr[right];
			System.out.println("left: " + arr[left] + ", right: " + arr[right] + ", sum: " + sum + ", current: " + current);
			
			if (Math.abs(current) < Math.abs(sum)) {
				sum = current;
				leftValue = arr[left];
				rightValue = arr[right];
			} 
			
			if (current < 0) left++;
			else if (current > 0) right--;
			else {
				left++;
				right--;
			}
		}
		
		bw.write(leftValue + " " + rightValue);
		br.close();
		bw.close();
	}

}
