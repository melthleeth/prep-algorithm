package december2020;
import java.util.*;
import java.io.*;

// 2020.12.29 소인수분해를 해야 하는군.. 겁나틀림;;

public class BJ20302_민트초코 {
	static int N;
	static int[] prime = new int[100001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		boolean zero = false;
		
		int n = Integer.parseInt(temp[0]);
		if (n == 0) zero = true;
		else factorization(Math.abs(n), 1);
		
		int idx = 1;
		while(idx < temp.length) {
			String op = temp[idx++];
			int nextNum = Integer.parseInt(temp[idx++]);
			if (nextNum == 0) zero = true;
			if (op.equals("*")) factorization(Math.abs(nextNum), 1);
			else  factorization(Math.abs(nextNum), -1);
		}

		boolean flag = false;
		for (int i = 2; i < 100000; i++) {
			if (prime[i] < 0) {
				flag = true;
				break;
			}
		}

		if (zero || !flag) bw.write("mint chocolate");
		else bw.write("toothpaste");
		
		br.close();
		bw.close();
	}
	
	public static void factorization(int num, int op) {
		int bound = (int)Math.sqrt(num);
		for (int i = 2; i <= bound; i++) {
			while(num % i == 0) {
				num /= i;
				prime[i] += op;
			}
		}
		if (num > 1) prime[num] += op;
	}

}
