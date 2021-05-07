package January2021;
import java.io.*;
import java.util.*;

public class BJ10157_S5_자리배정 {
	static int R, C, K, x, y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		
		if (K > R * C) System.out.println(String.valueOf(0));
		else { // 진짜 이게 최선이야? ㅇㅇ
			int cnt = 0;
			
			
		}
	}

}
