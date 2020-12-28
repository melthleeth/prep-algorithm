package december2020;
import java.util.*;
import java.io.*;

public class BJ2596_B2_비밀편지 {
	static int N;
	static String[] alphabet = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		for (int i = 1; i <= N; i++) {
			String temp = str.substring(6 * (i - 1), 6 * i);
			char next = '0';
			for (int j = 0; j < alphabet.length; j++) {
				if (verify(temp, j)) next = (char)('A' + j);
			}
			
			if (next == '0') {
				sb = new StringBuilder(String.valueOf(i));
				break;
			} else sb.append(next);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static boolean verify(String strip, int num) {
		int eq = 0;
		for (int i = 0; i < 6; i++)
			if (strip.charAt(i) != alphabet[num].charAt(i)) eq++;
		
		if (eq <= 1) return true;
		else return false;
	}

}
