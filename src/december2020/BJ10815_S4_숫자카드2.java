package december2020;
import java.util.*;
import java.io.*;

// 2020.12.29

public class BJ10815_S4_숫자카드2 {
	static int N, M;
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (map.get(num) == null) map.put(num, 1);
			else map.replace(num, map.get(num) + 1);
		}
		
		//map.entrySet().stream().forEach(e -> System.out.println(e));
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if (map.get(key) != null) bw.write(map.get(key) + " ");
			else bw.write("0 ");
		}
		
		br.close();
		bw.close();
	}

}
