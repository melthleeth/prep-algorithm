package december2020;

import java.util.*;
import java.io.*;

// 이미 정답 제출한 사람은 continue
// 2020.12.08

public class BJ15595_정답비율계산하기 {
	static int N;
	static double ans, pass, failed;
	static Map<String, Integer> countMap = new HashMap<>();
	static Map<String, Boolean> passMap = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		br = new BufferedReader(new StringReader(src));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			String id = st.nextToken();
			if (countMap.get(id) == null) {
				countMap.put(id, 0);
				passMap.put(id, false);
			}
			if (id.equals("megalusion")) continue;
			
			int result = Integer.parseInt(st.nextToken());
			
			if (result == 4) {
				//System.out.println("id, failed: " + id + ", " + countMap.get(id));
				if (passMap.get(id)) continue;
				
				passMap.replace(id, true);
				pass++;
				failed += countMap.get(id);
				countMap.replace(id, 0);
			}
			else {
				int val = countMap.get(id);
				countMap.replace(id, val + 1);
			}
			
		}
		//System.out.println("pass, failed: " + pass + ", " + failed);
		if (pass == 0) ans = 0;
		else ans = (pass / (pass + failed)) * 100;
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	static String src = "24\r\n" + 
			"7884922 megalusion 4 2180 0 88 1141\r\n" + 
			"7884988 megalusion 4 9424 124 3 1395\r\n" + 
			"7885291 junodeveloper 4 2144 0 88 1146\r\n" + 
			"7885327 doju 4 1312 0 49 756\r\n" + 
			"7886288 moonrabbit2 4 2372 0 88 1247\r\n" + 
			"7886486 koosaga 11 0 0 84 1452\r\n" + 
			"7886490 koosaga 4 2300 0 84 1423\r\n" + 
			"7886858 yclock 4 2224 0 49 911\r\n" + 
			"7888812 seok9311 6 1116 0 1 1049\r\n" + 
			"7888907 seok9311 6 1116 0 1 1050\r\n" + 
			"7888917 seok9311 7 1116 1000 1 888\r\n" + 
			"7889119 seok9311 6 1116 508 1 1033\r\n" + 
			"7889125 seok9311 6 1116 0 1 1052\r\n" + 
			"7889184 seok9311 4 1120 0 1 2245\r\n" + 
			"7895033 jinsub8682 4 9576 120 3 1326\r\n" + 
			"7898896 khj94811 4 1988 0 88 1585\r\n" + 
			"7901927 rkm0959 4 2424 0 88 2318\r\n" + 
			"7908183 woong10sae 6 2068 0 88 1454\r\n" + 
			"7908251 woong10sae 6 2860 4 88 1610\r\n" + 
			"7908353 woong10sae 4 2044 0 88 829\r\n" + 
			"7931699 y305205 6 29656 64 28 340\r\n" + 
			"7931803 y305205 6 29656 68 28 341\r\n" + 
			"7945503 chogahui05 4 1384 0 0 361848\r\n" + 
			"7951273 subinium 4 1116 0 49 527";
}
