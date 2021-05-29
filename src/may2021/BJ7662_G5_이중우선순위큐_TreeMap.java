package may2021;

import java.io.*;
import java.util.*;

public class BJ7662_G5_이중우선순위큐_TreeMap {
	static int T, K, SIZE;
	static TreeMap<Long, Integer> map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		
		for (int index = 0; index < T; index++) {
			K = Integer.parseInt(br.readLine());
			map = new TreeMap<>();
			
			SIZE = 0;
			
			for (int i = 0; i < K; i++) {
				String[] op = br.readLine().split(" ");
				
				switch(op[0].charAt(0)) {
				case 'I':
					long num = Integer.parseInt(op[1]);
					if (map.get(num) != null) map.put(num, map.get(num) + 1);
					else map.put(num, 1);
					SIZE++;
					break;
				case 'D':
					if (SIZE > 0) {
						if (Integer.parseInt(op[1]) == -1) {
							if (map.firstEntry().getValue() == 1) map.pollFirstEntry();
							else {
								long key = map.firstKey();
								int value = map.get(key);
								map.put(key, value - 1); 
							}
						}
						else {
							if (map.lastEntry().getValue() == 1) map.pollLastEntry();
							else {
								long key = map.lastKey();
								int value = map.get(key);
								map.put(key, value - 1); 
							}
						}
						
						SIZE--;
					}
					break;
				}
//				for (Map.Entry<Long, Integer> map: map.entrySet())
//					System.out.println(map.getKey() + ", " + map.getValue());
//				System.out.println("----");
				
			}
			if (SIZE == 0) bw.write("EMPTY\n");
			else {
				bw.write(map.lastKey() + " " + map.firstKey() + "\n");
			}
			
		}
		br.close();
		bw.close();
	}
}
