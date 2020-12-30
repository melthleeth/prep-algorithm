package december2020;
import java.util.*;
import java.io.*;

// 2020.12.30
/*
반례: 무조건 앞자리에 큰 수를 넣는게 아니다
10
ABB
BB
BB
BB
BB
BB
BB
BB
BB
BB
*/

public class BJ1339_G4_단어수학 {
	static int N, ans;
	static ArrayList<Integer> val = new ArrayList<>();
	static Map<Character, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			int len = str.length();
			for (int j = 0; j < len; j++) {
				char c = str.charAt(j);
				int value = (int)Math.pow(10.0, len - j - 1);
				if (map.get(c) == null) map.put(c, value);
				else map.replace(c, map.get(c) + value);
			}
		}
		
		//map.entrySet().stream().forEach(e -> System.out.println(e));
		
		for (Character key : map.keySet())
			val.add(map.get(key));
		
		Collections.sort(val, Collections.reverseOrder());
		int num = 9;
		for(int v : val)
			ans += (num--) * v;
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

}
