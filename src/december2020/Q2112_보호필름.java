package december2020;
import java.util.*;
import java.io.*;

/*
2020.12.02
부분집합 + 탐색

10            
6 8 3         
0 0 1 0 1 0 0 1
0 1 0 0 0 1 1 1
0 1 1 1 0 0 0 0
1 1 1 1 0 0 0 1
0 1 1 0 1 0 0 1
1 0 1 0 1 1 0 1
6 8 3         
1 1 1 1 0 0 1 0
0 0 1 1 0 1 0 1
1 1 1 1 0 0 1 0
1 1 1 0 0 1 1 0
1 1 0 1 1 1 1 0
1 1 1 0 0 1 1 0
*/

public class Q2112_보호필름 {
	static int T, D, W, K, ans, minValue;
	static int[][] film;
	static boolean[] selected, color;
	static int[] order;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int index = 1; index <= T; index++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			selected = new boolean[D + 1];
			ans = 0;
			minValue = D + 1;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					film[i][j] = Integer.parseInt(st.nextToken());
			}
			
			if (!qualityTest(film)) { 
				pickRow(0);
				ans = minValue;
			}
			
			bw.write("#" + index + " " + ans + "\n");
		}
		br.close();
		bw.close();
	}
	
	public static boolean qualityTest(int[][] arr) {
		boolean pass = false;
		int sequence = 0;
	
		for (int j = 0; j < W; j++) {
			pass = false;
			sequence = 1;
			for (int i = 0; i < D - 1; i++) {
				if (arr[i][j] == arr[i + 1][j]) sequence++;
				else sequence = 1;
				
				if (sequence >= K) {
					pass = true;
					//System.out.println("i, j = " + i + ", " + j);
					break;
				}
			}
			if (!pass) return false;
		}
		
		//System.out.println("PASS");
		return true;
	}
	// 이거 고른거에 대해서 또 부분집합 써야됨ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
	public static void pickRow(int depth) {
		//if (minValue < D + 1) return;
		if (depth == D) {
			int cnt = 0;
			order = new int[D + 1];
			for (int i = 0; i < D; i++)
				if (selected[i]) order[cnt++] = i;
			color = new boolean[cnt + 1];
			//System.out.println("cnt: " + cnt);
			if (cnt > minValue) return;
			
			addChemical(cnt, 0);
			
			return;
		}
		selected[depth] = false;
		pickRow(depth + 1);
		selected[depth] = true;
		pickRow(depth + 1);
	}
	
	public static void addChemical(int bound, int depth) {
		if (depth == bound) {
			int[][] copy = Arrays.stream(film).map(int[]::clone).toArray(int[][]::new);
			for (int i = 0; i < bound; i++) {
				if (color[i]) { // A로 칠하기
					//System.out.print("A-" + order[i] + " ");
					for (int j = 0; j < W; j++)
						copy[order[i]][j] = 0;
				} else { // B로 칠하기
					//System.out.print("B-" + order[i] + " ");
					for (int j = 0; j < W; j++)
						copy[order[i]][j] = 1;
				}
			}
//			System.out.println("\nbound: " + bound);
//			for (int[] row : copy) {
//				for (int col : row)
//					System.out.print(col + " ");
//				System.out.println();
//			}
			
			if (qualityTest(copy)) minValue = Math.min(minValue, bound);
			
			return;
		}
		
		color[depth] = true;
		addChemical(bound, depth + 1);
		color[depth] = false;
		addChemical(bound, depth + 1);
	}

}
