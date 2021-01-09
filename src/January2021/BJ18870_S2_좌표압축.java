package January2021;

import java.io.*;
import java.util.*;

public class BJ18870_S2_좌표압축 {
	static int N, idx;
	static int[] arr;
	static Set<Integer> s = new TreeSet<>();
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			s.add(num);
			arr[i] = num;
		}
		s.forEach(e -> map.put(e, idx++));
		for (int i = 0; i < N; i++)
			bw.write(map.get(arr[i]) + " ");
		
		br.close();
		bw.close();
	}

}
