package January2021;
import java.util.*;
import java.io.*;

// 2021.01.04

public class BJ2999_B1_비밀이메일 {
	static String str;
	static int N, R, C, len;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		int len = str.length();
		N = (int)Math.sqrt(len);
		
		for (int i = N; i > 0; i--) {
			if (len % i > 0) continue;
			R = i;
			C = len / R;
			break;
		}
		
		System.out.println("R, C = " + R + ", " + C);
		
		for (int r = 0; r < R; r++) 
			for (int c = 0; c < C; c++)
				sb.append(str.charAt(r + c * R));
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

}
