package december2020;
import java.util.*;
import java.io.*;

//2020.12.29

public class BJ10815_S4_숫자카드 {
	static int N, M;
	static Map<Integer, Boolean> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, true);
		}
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.get(key) != null) bw.write("1 ");
			else bw.write("0 ");
		}
		
		br.close();
		bw.close();
	}

}
