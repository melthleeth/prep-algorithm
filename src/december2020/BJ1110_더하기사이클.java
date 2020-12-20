package december2020;
import java.io.*;

// 2020.12.20

public class BJ1110_더하기사이클 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		
		int cycle = 0;
		int prev = N, next = 0, newNum = -1;
		
		while(newNum != N) {
			int pNum1 = prev / 10;
			int pNum2 = prev % 10;
			next = pNum1 + pNum2;
			
			int nNum1 = next / 10;
			int nNum2 = next % 10;
			
			newNum = pNum2 * 10 + nNum2;
			cycle++;
			prev = newNum;
		}
		
		System.out.println(cycle);
	}

}
