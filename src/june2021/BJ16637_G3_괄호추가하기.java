package june2021;

import java.io.*;
import java.util.*;

public class BJ16637_G3_괄호추가하기 {
	static int N, maxValue = Integer.MIN_VALUE;
	static int[] num;
	static char[] op;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split("");
		num = new int[N];
		op = new char[N];
		
		int idx = 0;
		for (int i = 0; i < N; i += 2)
			num[idx++] = Integer.parseInt(input[i]);
		
		idx = 0;
		for (int i = 1; i < N; i += 2)
			op[idx++] = input[i].charAt(0);

		solve(num[0], 0);

		bw.write(String.valueOf(maxValue));
		br.close();
		bw.close();
	}

	public static void solve(int sum, int idx) {
		if (idx == N / 2 - 1) {
			maxValue = Math.max(maxValue, calculate(sum, num[idx + 1], op[idx]));
			return;
		} else if (idx == N / 2) {
			maxValue = Math.max(maxValue, sum);
			return;
		}
		
		if (idx < N / 2 - 1) {
//			System.out.println(sum + " " + op[idx] + " " + num[idx + 1] + ", " + (idx + 1));
			solve(calculate(sum, num[idx + 1], op[idx]), idx + 1);
//			System.out.println(sum + " " + op[idx] + " " + calculate(num[idx + 1], num[idx + 2], op[idx + 1]) + ", " + (idx + 2));
			solve(calculate(sum, calculate(num[idx + 1], num[idx + 2], op[idx + 1]), op[idx]), idx + 2);
		}
	}
	
	public static int calculate(int x, int y, char op) {
		if (op == '+') return x + y;
		else if (op == '-') return x - y;
		else return x * y;
	}

}
