package december2020;
import java.io.*;
import java.util.*;

//2020.12.20

public class BJ1652_누울자리를찾아라 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int horizontal = 0, vertical = 0;
		char[][] map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			
			// horizontal
			int cnt = 0;
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'X') {
					flag = false;
					cnt = 0;
				}
				if (map[i][j] == '.') cnt++;
				if (cnt >= 2 && !flag) {
					flag = true;
					horizontal++;
				}
			}
		}
		
		// vertical
		for (int j = 0; j < N; j++) {
			int cnt = 0;
			boolean flag = false;
			for (int i = 0; i < N; i++) {
				if (map[i][j] == 'X') {
					flag = false;
					cnt = 0;
				}
				if (map[i][j] == '.') cnt++;
				if (cnt >= 2 && !flag) {
					flag = true;
					vertical++;
				}
			}
		}
	
		bw.write(horizontal + " " + vertical + "\n");
		br.close();
		bw.close();
	}

}
